import React from 'react';
import "../css/Cover.css";
import { useNavigate } from "react-router-dom";
import cover from "../images/main-bg.jpg"


export default function Cover() {
    
// document.body.style.backgroundImage = {cover};
// document.body.style.backgroundImage = "url('../images/main-bg.jpg')"; 
document.body.style.backgroundImage = `url(${cover})`;
document.body.style.height = '100vh'
document.body.style.width = '100vw'
document.body.style.backgroundSize = "cover"

const navigate = useNavigate();
  return (
    <div class="container">
        <div id="main" class="container">
            <div class="row text-center">
                <div class="col-xl-6">
                    <div id="patient" class="container mt-6">
                        <button class="btn btn-secondary btn-lg" onClick={() => navigate("/patient")}>I'm a Patient</button>
                    </div>
                </div>
                <div class="col-xl-6">
                    <div  id="doctor" class="container mt-6">
                        <button class="btn btn-light btn-lg" onClick={() => navigate("/doctor")}>I'm a Doctor</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
  )
}
