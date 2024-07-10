import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import Api from './ApiRequest';

function ClientRegister() {

    const navigate=useNavigate();
    const [data,setData]=useState({
        email:"",
        password:"",
        fname:"",
        lname:"",
        phone:""        
    });

    const handleClientSignup=async (e)=>{
        e.preventDefault();
        try{
          const response=await Api.post("/client-signup",data);
          console.log(response.data);
          alert("successfully registered")
          navigate('/login');
        }
        catch(err){
          console.log(err);
        }
      }

    const handleValue=(e)=>{
        setData({
            ...data,
            [e.target.name] : e.target.value
        })
    }   

    return (
    <div className="ClientRegister">      .
      <div className="client-signup">
        <form >
          <h2>Client Signup</h2>
          <input
            type="email"
            name="email"
            placeholder="Email"
            value={data.email}
            onInput={(e) => handleValue(e)}
          />
          <input
            type="password"
            name="password"
            placeholder="Password"
            value={data.password}
            onInput={(e) => handleValue(e)}
          />
          <input
            type="text"
            name="fname"
            placeholder="Fname"
            value={data.fname}
            onInput={(e) => handleValue(e)}
          />
          <input
            type="text"
            name="lname"
            placeholder="Lname"
            value={data.lname}
            onInput={(e) => handleValue(e)}
          />
          <input
            type="number"
            name="phone"
            placeholder="Phone"
            value={data.phone}
            onInput={(e) => handleValue(e)}
          />

          <button onClick={(e)=>handleClientSignup(e)}>Register</button>
          <p>Or <Link to='/login'>login now!</Link></p>
        </form>
      </div>
    </div>
  );
}

export default ClientRegister;
