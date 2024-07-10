import axios from "axios";
import React, { useCallback, useEffect, useState } from "react";
import "./Ads.css";
import { Link, useNavigate } from "react-router-dom";

function Ads({ id ,setAdId,adId,result,SetResult}) {
  const [data, setData] = useState([]);
  const navigate=useNavigate();

  useEffect(() => {
    handleDisplay();
    console.log(id);
  }, []);

  const handleDisplay = async () => {
    const response = await axios
      .get(`http://localhost:8080/api/company/displayAd/${id}`)
      .catch((err) => console.log(err));
    setData(response.data);
    SetResult(String.toString(response.data));
  };


  const handleUpdateData=(mid)=>{
    if(mid!=null){
      setAdId(mid);
      navigate("/updateAd")
      console.log(adId);
    }else{
      return;
    } 
  }

  const res=useCallback((mid)=>{
    return handleUpdateData(mid);
  },[handleUpdateData]); 

  
  const handleDeleteData=async (mid)=>{
    const response=await axios.delete(`http://localhost:8080/api/company/deleteAd/${mid}`)
    .catch((err)=>console.log(err));
    SetResult(String.toString(response.data));
    alert(result);      
  }
  return (
    <div className="ads">
      {data.length === 0 ? (
        <h1>No Posts here!</h1>
      ) : (
        data.map((m) => {
          return (
            <div className="box" key={m.id}>
              <div className="box1">
                <img
                  src={`data:image/png;charset=utf-8;base64,${m.returnedImg}`}
                />
              </div>

              <div className="box2">
                <h4>{m.serviceName}</h4>
                <p>Price:{m.price}</p>
                <p className="desc">{m.description}</p>
                <div className="btns">
                  <button onClick={()=>handleUpdateData(m.id)}>Update</button>
                  <button onClick={()=>handleDeleteData(m.id)}>Delete</button>
                </div>
              </div>
            </div>
          );
        })
      )}
    </div>
  );
}

export default Ads;
