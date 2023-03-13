import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';
import "../css/Appointment.css"
import { p_id } from './Login';
export default function Appointment() {

    document.body.style.backgroundColor = "white";
    const navigate = useNavigate();
    const [user, setUser] = useState({

        appointment_number: "",
        patient_id: p_id,
        doctor_id: "",
        date_of_appointment: "",
        time_of_appointment: ""
    })

    let name, value;

    const HandleInputs = (e) => {
        console.log(e);
        name = e.target.name;
        value = e.target.value;

        setUser({ ...user, [name]: value });
    }

    var M1 = async (e) => {

        e.preventDefault();

        const {
            appointment_number,
            patient_id,
            doctor_id,
            date_of_appointment,
            time_of_appointment
        } = user;

        const res = await fetch("http://localhost:8080/appointment/saveAppointment", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                appointment_number:appointment_number,
                patient_id: patient_id,
                doctor_id: doctor_id,
                date_of_appointment:date_of_appointment,
                time_of_appointment:time_of_appointment
            })
        })
            .then((response) => response.json())
            .then((data) => {
                console.log(data)
                // xyz("/user-page")
                alert("Appoinment Confirmed !!");
                navigate("/patient");
            });
    }
    return (
        <div>
            <div class="formbold-main-wrapper">
                <div class="formbold-form-wrapper">
                    <h2>Request an Appointment</h2><br />
                    <div class="container">
                        <div class="row">
                            <div class="col-9 ">
                                <div class="row">
                                    <div class="col-6 col-sm-2 ">
                                        <i class="fa-solid fa-phone"></i>
                                    </div>
                                    <div class="col-6 ">
                                        <p> 022 - 25101102<br />
                                            <span>Monday - Saturday</span><br />
                                            <span>9AM - 10PM</span>
                                        </p>
                                    </div>
                                </div>
                            </div>

                            <div class="col-3 ">
                                <div class="row">
                                    <div class="col-3">
                                        <i class="fa-solid fa-envelope"></i>
                                    </div>
                                    <div class="col-9 ">
                                        <p>reception@polyclinic.com</p>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>

                    <form action="https://formbold.com/s/FORM_ID" method="POST">

                        <div class="formbold-mb-5">
                            <label for="patid" class="formbold-form-label"> Patient Id </label>
                            <input type="text" name="patient_id" id="patient_id" placeholder={p_id}
                                class="formbold-form-input" value={user.patient_id} onChange={HandleInputs}/>
                        </div>
                        <div class="formbold-mb-5">
                            <label for="name" class="formbold-form-label"> Full Name </label>
                            <input type="text" name="name" id="name" placeholder="Enter your Full Name"
                                class="formbold-form-input" />
                        </div>
                        <div class="formbold-mb-5">
                            <label for="phone" class="formbold-form-label"> Phone Number </label>
                            <input type="text" name="phone" id="phone" placeholder="Enter your phone number"
                                class="formbold-form-input" />
                        </div>

                        <div class="flex flex-wrap formbold--mx-3">
                            <div class="w-full sm:w-half formbold-px-3">
                                <div class="formbold-mb-5 w-full">
                                    <label for="date" class="formbold-form-label"> Date </label>
                                    <input type="date" name="date_of_appointment" id="date_of_appointment" class="formbold-form-input" value={user.date_of_appointment} onChange={HandleInputs}/>
                                </div>
                            </div>
                            <div class="w-full sm:w-half formbold-px-3">
                                <div class="formbold-mb-5 w-full">
                                    <label for="time" class="formbold-form-label"> Time </label>
                                    <select name="time_of_appointment" id="time_of_appointment" class="formbold-form-input" aria-label="Default select example"
                                        placeholder="Select time slot"  value={user.time_of_appointment} onChange={HandleInputs}>
                                        <option value="" disabled selected hidden>Choose a Time slot</option>
                                        <option value="11 am - 12 pm">11 am - 12 pm</option>
                                        <option value="12 pm - 1 pm">12 pm - 1 pm</option>
                                        <option value="1 pm - 2 pm">1 pm - 2 pm</option>
                                        <option value="6 pm - 7 pm">6 pm - 7 pm</option>
                                        <option value="7 pm - 8 pm">7 pm - 8 pm</option>
                                        <option value="8 pm - 9 pm">8 pm - 9 pm</option>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="formbold-mb-5">
                            <label for="email" class="formbold-form-label"> Doctor to consult</label>
                            <select id='doctor_id' name="doctor_id" class="formbold-form-input" aria-label="Default select example"
                                placeholder="Select time slot" value={user.doctor_id} onChange={HandleInputs}>
                                <option value="" disabled selected hidden>Select</option>
                                <option value="1001">Dr. Nilam (M.D. ENT)</option>
                                <option value="1002">Dr. Samiksha (M.D. Gen. Medicine)</option>
                                <option value="1003">Dr. Tripti (B.P.T. Physiotherapist)</option>
                                <option value="1004">Dr. Sunaina  (M.D. Gynecologist )</option>
                                
                            </select>
                        </div>
                        <div>
                            <button class="formbold-btn" onClick={M1}>Book Appointment</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    )
}
