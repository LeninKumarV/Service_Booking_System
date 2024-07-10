import React, { useState } from "react";
import "./Register.css";
import Api from './ApiRequest';
import { Link, useNavigate } from "react-router-dom";


function CompanyRegister() {

  const navigate=useNavigate();
  const [cpassword,setCPassword] =useState();
  const [data, setData] = useState({
    email: "",
    password: "",
    fname: "",
    phone: "",
  });

  const handleCompanySignup =async (e) => {
    e.preventDefault();
      try{
        const response=await Api.post("/company-signup",data);
        console.log(response.data);
        navigate('/login');
      }
      catch(err){
        console.log(err);
      }
  };

  const handleValue = (e) => {
    setData({
      ...data,
      [e.target.name]: e.target.value,
    });
  };
  return (
    <div className="CompanyRegister">
      .
      <div className="company-signup">
        <form>
          <h2>Company Signup</h2>
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
            type="password"
            name="cpassword"
            placeholder="Confirm Password"
            value={cpassword}
            onInput={(e) =>setCPassword(e.target.value)}
          />
          <input
            type="text"
            name="fname"
            placeholder="Name"
            value={data.fname}
            onInput={(e) => handleValue(e)}
          />
          <input
            type="number"
            name="phone"
            placeholder="Phone"
            value={data.phone}
            onInput={(e) => handleValue(e)}
          />
          <button onClick={(e) => handleCompanySignup(e)}>Register</button>
          <p>Or <Link to='/login'>login now!</Link></p>
        </form>
      </div>
    </div>
  );
}

export default CompanyRegister;
