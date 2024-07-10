import React, { useCallback, useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import "./Register.css";
import Api from "./ApiRequest";
import axios from "axios";

function Login({
  logResponse,
  setLogResponse,
  sertLogClk,
  setClick,
  id,
  setId,
}) {

  const navigate = useNavigate();

  const [data, setData] = useState({
    email: "",
    password: "",
  });

  const handleData = (e) => {
    setData({
      ...data,
      [e.target.name]: e.target.value,
    });
  };

  const handleLogin =async (e) => {
    e.preventDefault();

    try {
      const response = await axios.get(`http://localhost:8080/service_booking/login/${data.email}/${data.password}`);
      const responseData = await setLogResponse(await response.data.role);
      const responseId = await setId(await response.data.id);
      console.log(logResponse, id);

      if (logResponse === "CLIENT") {
        sertLogClk(true);
        setClick("client");
        navigate("/client-dashboard");
      }
       else if (logResponse === "COMPANY") {
        sertLogClk(true);
        setClick("company");
        navigate(`/company-dashboard/${id}`);
      } 
      else if(logResponse==="ERROR"){
        alert(response.data);
        sertLogClk(false);
        setClick("");
      }
    } catch (err) {
      console.log(err);
    }

  };

  const result=useCallback(async (e)=>{
    e.preventDefault()
    return await handleLogin(e);
  },[handleLogin]); 

    // useEffect(() => {
  //   handleLogin();  
  // }, [handleLogin]);
  return (
    <div className="login">
      <form >
        <h2>Login</h2>
        <input
          type="email"
          name="email"
          placeholder="Email"
          email={data.email}
          onInput={(e) => handleData(e)}
        />
        <input
          type="password"
          name="password"
          placeholder="Password"
          value={data.password}
          onInput={(e) => handleData(e)}
        />

        <button onClick={(e)=>handleLogin(e)}>Login</button>
        <p>
          You don't have accoount? <Link to="/register">signup now!</Link>
        </p>
      </form>
    </div>
  );
}

export default Login;
