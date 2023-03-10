import React, { useEffect, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom';
import { doctor_id } from './Doctor';
import logo from "../images/Logo-navbar.png"
export default function DoctorHome() {

    document.body.style.backgroundColor = "white";
    const [cat, setcat] = useState([])
    const [abc, setAbc] = useState([])
    const navigate = useNavigate();
    useEffect(() => {

        fetch(`http://localhost:8080/appointment/allAppointment/${doctor_id}`)
            .then(res => res.json())
            .then(valueFromAPI => {
                console.log('API DATA CALLED');
                console.log(valueFromAPI);
                setAbc(valueFromAPI)
            })

        fetch("http://localhost:8080/patient/allPatients")
            .then(res => res.json())
            .then(valueFromAPI => {
                console.log('API DATA CALLED');
                console.log(valueFromAPI);
                setcat(valueFromAPI)
            })
    }, []);


    // var M1 = () => {

    var merged = [];
    for (var i=0; i<cat.length; i++) {
        for (var j=0; j<abc.length; j++) {
            if (cat[i].patient_id === abc[j].patient_id) {
                merged.push({
                    appointment_number:abc[j].appointment_number,
                    first_name: cat[i].first_name, 
                    last_name: cat[i].last_name,
                    date_of_appointment: abc[j].date_of_appointment,
                    time_of_appointment: abc[j].time_of_appointment
                });
            }
        }
    }
    // const merged = cat.map(item => {
    //     const resp1Item = abc.find(r => r.patient_id === item.patient_id);

    //     return {
    //         ...item,
    //         ...resp1Item
    //     }
    // });
    console.log("MERGED");
    console.log(merged);



    // }
    return (
        <div>
            <header>
                <nav class="navbar navbar-expand-lg bg-body-tertiary  ">
                    <div class="container-fluid ">
                        <img src={logo} width="50px" height="50px" alt="" onClick={() => navigate("/")} />

                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse  justify-content-end" id="navbarNav">
                            <ul class="navbar-nav" >

                                <li class="nav-item px-2">
                                    <button class="nav1 btn btn-outline-success" onClick={() => navigate("/doctor")}>Logout</button>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </header><br />

            <table class='table table-striped'>
                <thead>
                    <tr>
                        <th scope="col">Appointment No.</th>
                        <th scope="col">First Name</th>
                        <th scope="col">Last Name</th>
                        <th scope="col">Date Of Appoinment</th>
                        <th scope="col">Time Of Appoinment</th>
                    </tr>
                </thead>

                {
                    merged.length > 0 && merged.map((val) =>

                        <tbody>
                            <tr>
                                <td>{val.appointment_number}</td>
                                <td>{val.first_name}</td>
                                <td>{val.last_name}</td>
                                <td>{val.date_of_appointment}</td>
                                <td>{val.time_of_appointment}</td>

                            </tr>
                        </tbody>
                    )
                }
            </table>
        </div>
    )
}
