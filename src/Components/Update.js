import axios from "axios";
import React, { useCallback, useEffect, useState } from "react";
import "./Register.css";
import { useNavigate } from "react-router-dom";

function Update({
  id,
  adId,
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
  setPrice,
}) {
  const [data, setData] = useState([]);
  const [imgData, setImgData] = useState(null);
  const navigate=useNavigate();

  //getting data
  useEffect(() => {
    setImgData(null);
    setFileData(null);
    setFile(null);
    handleDisplay();
    console.log(adId);
  }, []);


  const handleDisplay = async () => {
    const response = await axios
      .get(`http://localhost:8080/api/company/displaySingleData/${adId}`)
      .catch((err) => console.log(err));

    setData(response.data);
    setDescription(response.data[0].description);
    setService_name(response.data[0].serviceName);
    setPrice(response.data[0].price);
    setImgData(response.data[0].returnedImg);
    console.log(response.data);
  };


  const handleFile = (e) => {
    const formdata = new FormData();
    setFileData(e.target.files[0]);
    console.log(fileData,e.target.files[0]);
    if(fileData!=null){
      console.log(fileData,e.target.files[0]);
      formdata.append("img", fileData);
      setFile(formdata);
      alert("file get succesfully");
    }
    else{
      alert("file doesn't get properly,try again");
      setFileData(null);
      setFileData(e.target.files[0]);
      return;
    }
    console.log(fileItem,fileData);
  };


  const handleUpload = async (e) => {
    e.preventDefault();
    console.log(description,price,service_name);

    if (fileItem === null) {
      alert("Something went wrong! file is null,please select correct file!");
    } else {
      const response = await axios
        .put(
          `http://localhost:8080/api/company/updateAd/${adId}/${id}/${description}/${price}/${service_name}`,
          fileItem
        )
        .catch((err) => console.log(err));
        SetResult(response);
        setImgData(null);
        setFileData(null);
        setFile(null);
        SetResult(response.data);
        alert(result);      
        navigate("/ads")
        console.log(result);
    }
  };

  return (
    <div className="postAd">
      <form>
        <h2>Update Ad</h2>

        {data.length === 0 ? (
          <h1>No Posts here!</h1>
        ) : (
          <>
            {fileData ? (
              <img
                src={URL.createObjectURL(fileData)}
                style={{
                  width: "150px",
                  height: "100px",
                  backgroundSize: "cover",
                }}
              />
            ) : 
            <img
              src={`data:image/png;charset=utf-8;base64,${imgData}`}
              style={{
                width: "150px",
                height: "100px",
                backgroundSize: "cover",
              }}
            />
          }

            
            <input type="file" onChange={(e) => handleFile(e)} name="img" />
            <input
              type="text"
              placeholder="description"
              value={description}
              onInput={(e) => setDescription(e.target.value)}
            />
            <input
              type="number"
              placeholder="price"
              value={price}
              onInput={(e) => setPrice(e.target.value)}
            />
            <input
              type="text"
              placeholder="service_name"
              value={service_name}
              onChange={(e) => setService_name(e.target.value)}
            />
            <button onClick={(e) => handleUpload(e)}>Upload</button>
          </>
        )}
      </form>
    </div>
  );
}

export default Update;
