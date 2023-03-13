import React from 'react'
import "../css/Patient.css"
import logo from "../images/Logo-navbar.png"
import { Link, useNavigate } from "react-router-dom";
import doctor from "../images/Doctorpic.JPG"

export default function Patient() {
    const navigate = useNavigate();
    document.body.style.backgroundImage = "none";
    document.body.style.backgroundColor = "white"
    return (
        <div class="container-fluid">
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
                                    <Link class="nav1 nav-link active" aria-current="page" to="/patient">Home</Link>
                                </li>
                                <li class="nav-item px-2">
                                    <a class="nav1 nav-link" href="#specialities">Specialities</a>
                                </li>
                                <li class="nav-item px-2">
                                    <button class="nav1 btn btn-outline-success" onClick={() => navigate("/doctor")}>I'm Doctor</button>
                                </li>
                                <li class="nav-item px-2">
                                    <button class="nav1 btn btn-outline-success" onClick={() => navigate("/login")}>Login / SignUp</button>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </header>
            <br />

            <section class="patient_home_banner" id="home">
                <div class="container  mt-5">
                    <div class="row">
                        <div class="col-lg-6 order-sm-1 order-1">
                            <div class="banner_title" data-animation="fadeInLeft" animation-delay="2s" data-delay="0.3s">
                                <h1 class="h1 display-1">Your Health<br /><span>Our Priority</span></h1>
                                <p class="py-3">India's Hassle Free Doctor Appointment Booking App. Get Seamless OPD experience by
                                    booking the free appointment with India’s Top specialize doctor online.Enhance the connection between patient and doctor in best possible manner.
                                </p>
                            </div>
                        </div>
                        <div class="col-lg-6 order-sm-2 order-2">
                            <img src="https://t3.ftcdn.net/jpg/02/60/79/68/360_F_260796882_QyjDubhDDk0RZXV9z7XBEw9AKnWCizXy.jpg" alt="no pic" />
                        </div>
                    </div>
                </div>
            </section>
            <br />
            <br />
            <br />
            <h2 class="display-5">Specialities</h2>
            <br />
            <br />

            <section class="patient_home_banner" id="specialities">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-3">
                            <img class="img-thumbnail" src={doctor} alt="no pic" />
                            <br /><br />
                            <p class="text-center"><b>Dr. Samiksha Jadhav</b><br />
                                M.D.<br />
                                General Medicine</p>
                        </div>
                        <div class="col-xl-3">
                            <img class="img-thumbnail" src={doctor} alt="no pic" />
                            <br /><br />
                            <p class="text-center"><b>Dr. Nilam Vatkar</b><br />
                                M.D.<br />
                                Health Administration</p></div>
                        <div class="col-xl-3">
                            <img class="img-thumbnail" src={doctor} alt="no pic" />
                            <br /><br />
                            <p class="text-center"><b>Dr. Tripti Verma</b><br />
                                BPT<br />
                                Physiotherapist</p></div>
                        <div class="col-xl-3">
                            <img class="img-thumbnail" src={doctor} alt="no pic" />
                            <br /><br />
                            <p class="text-center"><b>Dr. Sunaina Chaudhary</b><br />
                                M.D.<br />
                                Gynecologist </p></div>
                    </div>
                </div>
            </section>
            <br />

            <footer>
                <br />
                <div class="container-fluid">
                    <div class="container">
                        <div class="row">
                            <div class="col-6 ">
                                <div class="row">
                                    <div class="col-sm-2 ">
                                        <i class="fa-solid fa-phone"></i>
                                    </div>
                                    <div class="col-6 ">
                                        <p> 022 - 25101102 </p>
                                    </div>
                                </div>
                            </div>

                            <div class="col-6 ">
                                <div class="row">
                                    <div class=" col-sm-2">
                                        <i class="fa-solid fa-envelope"></i>
                                    </div>
                                    <div class="col-6 ">
                                        <p>reception@polyclinic.com</p>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>

                    <br />
                    <div class="container text-center">
                        &copy; MET Mumbai
                    </div>
                </div>
                <br />
            </footer>
        </div>
    )
}
