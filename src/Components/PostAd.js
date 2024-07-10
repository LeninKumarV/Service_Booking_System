import axios from "axios";
import React, { useEffect, useState } from "react";
import "./Register.css";
import { useNavigate } from "react-router-dom";

function PostAd({ 
  id ,
  fileItem,
  setFile,
  fileData,
  setFileData,
  description,
  setDescription,
  service_name,
  setService_name,
  price,
  result,
  SetResult,
  setPrice

}) {
  const navigate=useNavigate();

  const handleFile = (e) => {
    const formdata = new FormData();
    setFileData(e.target.files[0]);
    formdata.append("img", fileData);
    setFile(formdata);
    console.log(fileItem,fileData);

    if (fileData === null) {
      alert("file doesn't get properly,try again");
    } else {
      alert("file get succesfully");
    }
  };

  const handleUpload = async (e) => {

    e.preventDefault();
    console.log(description,price,service_name);


    if (fileItem != null) {
      const response = await axios
        .post(
          `http://localhost:8080/api/company/postAd/${id}/${description}/${price}/${service_name}`,
          fileItem
        )
        .catch((err) => console.log(err));
      SetResult(response);
      console.log(result);
      navigate("/ads");
    } else {
      alert("Something went wrong! file is null,please select correct file!");
    }
  };

  return (
    <div className="postAd" >
      <form>
        <h2>Post Ad</h2>
        <input type="file" onChange={(e) => handleFile(e)} name="img" />
        {fileData!=null && fileItem!=null ? <img src={URL.createObjectURL(fileData)}  style={{width:"150px", height:"100px",backgroundSize:"cover"}}/> : null}
        <input
          type="text"
          placeholder="description"
          onInput={(e) => setDescription(e.target.value)}
        />
        <input
          type="number"
          placeholder="price"
          onInput={(e) => setPrice(e.target.value)}
        />
        <input
          type="text"
          placeholder="service_name"
          onInput={(e) => setService_name(e.target.value)}
        />
        <button onClick={(e) => handleUpload(e)}>Upload</button>
      </form>
    </div>
  );
}

export default PostAd;
