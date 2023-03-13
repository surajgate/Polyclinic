import React, { useEffect, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
export var p_id;
export default function Login() {

    document.body.style.backgroundColor = "rgb(215, 230, 253)"

    const [cat, setcat] = useState([])
    const navigate = useNavigate();
    useEffect(() => {

        fetch("http://localhost:8080/patient/allPatients")
        .then(res => res.json())
        .then(valueFromAPI=>{
            console.log('API DATA CALLED');
            console.log(valueFromAPI);
            setcat(valueFromAPI)
          })
        },[]);

       var M1 = () => {
            var email = document.getElementById("exampleInputEmail1").value;
            var password = document.getElementById("exampleInputPassword1").value;
            alert(email +" "+ password);
            var b = false;
            console.log(b);
            console.log(email);
            console.log(password);
    
            cat.forEach(element => {
                    if (element.email === email && element.password === password) {
                        b = true;
                        p_id = element.patient_id
                    }
                });
           
            console.log(b);
            c();
            function c() {
    
                if (b === true) {
                    navigate("/appointment");
                }
                else {
                    navigate("/login");
                }
            }
        }
  return (
    <div className="container-fluid w-25 p-3 h-100 mt-5 ">

            <form className="form-control-md">
                <h1 className="text-center mb-4 display-5">Patient Login</h1>
                <div className="mb-3">
                    <label for="exampleInputEmail1" className="form-label">Email address</label>    
                    <input type ="text"  className="form-control" id="exampleInputEmail1"/>
                </div>
                <div className="mb-3">
                    <label for="exampleInputPassword1" className="form-label">Password</label>
                    <input type="password"  className="form-control" id="exampleInputPassword1" />

                </div>
                <div className="text-center">
                    <button type="submit" className="btn btn-secondary"  onClick={M1}>Login</button>
                </div>
                <div className='text-center'>
                <p>
                <br/>
                <span className='col-xl-6'>For Sign-Up <Link to = '/register'>Register</Link></span>
                
                </p>
                </div>
            </form>
            
        </div>
  )
}
