import React, { useState } from 'react'
import $ from 'jquery';
import { useNavigate } from 'react-router-dom';

export default function Register() {

  const navigate = useNavigate();
  const [user, setUser] = useState({

    patient_id: "",
    first_name: "",
    last_name: "",
    patient_age: "",
    blood_group: "",
    gender: "",
    date_of_birth: "",
    phone_number: "",
    address: "",
    username: "",
    email: "",
    password: "",
    confirm_password: "",
    doctor_id: "1001"
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
      patient_id,
      first_name,
      last_name,
      patient_age,
      blood_group,
      gender,
      date_of_birth,
      phone_number,
      address,
      username,
      email,
      password,
      confirm_password,
      doctor_id
    } = user;

    const res = await fetch("http://localhost:8080/patient/savePatient", {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        // patient_id: patient_id,
        first_name: first_name,
        last_name: last_name,
        patient_age: patient_age,
        blood_group: blood_group,
        gender: gender,
        date_of_birth: date_of_birth,
        phone_number: phone_number,
        address: address,
        username: username,
        email: email,
        password: password,
        confirm_password: confirm_password,
        // doctor_id: 1002
      })
    })
      .then((response) => response.json())
      .then((data) => {
        console.log(data)
        // xyz("/user-page")
        alert("Registration Successful !!");
        navigate("/login");
      });
  }



  return (

    <div className='container-fluid'>
      <div class="container">
        <form class="">
          <center>
            <h1 className='form-title'> Patient Registeration Form</h1>
          </center>
          <hr /><br />

          <div class="col-sm-10">
            <div class="form-group row">
              <label class="col-sm-2">Firstname : </label>
              <input id="firstname" class='form-control-sm col-sm-4' type="text" name="first_name" placeholder="Firstname"
                size="15" value={user.first_name} onChange={HandleInputs} required />
            </div><br />
            <div class="form-group row">
              <label class="col-sm-2"> Lastname: </label>
              <input id="lastname" class='form-control-sm col-sm-4' type="text" name="last_name" placeholder="Lastname" size="15"
                required value={user.last_name} onChange={HandleInputs} />
            </div><br />
            <div class="form-group row">
              <label class="col-sm-2"> Age: </label>
              <input id="age" class='form-control-sm col-sm-4' type="text" name="patient_age" placeholder="Age" size="15"
                required value={user.patient_age} onChange={HandleInputs} />
            </div><br />
            <div class="form-group ">
              <label class="">
                Blood Group : &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;
              </label>
              <select id="blood_group" name='blood_group' class='form-control-sm' value={user.blood_group} onChange={HandleInputs} >
                <option value="O+ve">O+ve</option>
                <option value="O-ve">O-ve</option>
                <option value="A+ve">A+ve</option>
                <option value="A-ve">A-ve</option>
                <option value="B+ve">B+ve</option>
                <option value="B-ve">B-ve</option>
                <option value="AB+ve">AB+ve</option>
                <option value="AB-ve">AB-ve</option>
              </select>
            </div>
            <br />
            <div class="form-group row">
              <label class="col-sm-2">Gender : </label>
              <input id="gender" class='form-control-sm col-sm-4' type="text" name="gender" placeholder="Male / Female / Other"
                size="15" value={user.gender} onChange={HandleInputs} required />
            </div><br />

            <div class="form-group-sm row">
              <label class="col-sm-2" for="date"> Date Of Birth: </label>
              <input id="date_of_birth" class='form-control-sm col-sm-4' type="date" name="date_of_birth" value={user.date_of_birth} onChange={HandleInputs} />
            </div>

            <br />
            <div class="form-group-sm row">
              <label class="col-sm-2">
                Phone :
              </label>
              <input class='form-control-sm col-sm-1' type="text" name="country code" placeholder="Country Code"
                value="+91" size="2" />&nbsp;
              <input id="phone" class='form-control-sm col-sm-3' type="text" name="phone_number" placeholder="phone no."
                size="10" value={user.phone_number} onChange={HandleInputs} />
            </div><br />
            <div class="form-group row">
              <label class="col-sm-2">
                Current Address :
              </label>
              <textarea id="address" type="text" class='form-control-sm col-sm-4' cols="80" rows="3" placeholder="Current Address"
                required name='address' value={user.address} onChange={HandleInputs}>
              </textarea>
            </div><br />
            <div class="form-group row">
              <label class="col-sm-2" for="email">Email :</label>
              <input id="email" class='form-control-sm col-sm-4' type="text" placeholder="Enter Email" name="email"
                required value={user.email} onChange={HandleInputs} />
            </div><br />
            <div class="form-group row">
              <label class="col-sm-2"> Username : </label>
              <input id="username" class='form-control-sm col-sm-4' type="text" name="username" placeholder="Username" size="15"
                required value={user.username} onChange={HandleInputs} />
            </div><br />
            <div class="form-group row">
              <label class="col-sm-2" for="psw">Password :</label>
              <input id="password" class='form-control-sm col-sm-4' type="password" placeholder="Enter Password" name="password"
                required value={user.password} onChange={HandleInputs} />
            </div><br />
            <div class="form-group row">
              <label class="col-sm-2" for="psw-repeat">Confirm Password :</label>
              <input id="confirm_password" class='form-control-sm col-sm-4' type="password" placeholder="Retype Password"
                name="confirm_password" required value={user.confirm_password} onChange={HandleInputs} /><br />
            </div><br /><br />
            <div class="form-group row">
              <div class="col-sm-2"></div>
              <button class='btn btn-success col-sm-2' type="submit" onClick={M1}>Register</button>
              <div class="col-sm-2"></div>
            </div><br />
          </div>


        </form>

      </div>
    </div>
  )
}
