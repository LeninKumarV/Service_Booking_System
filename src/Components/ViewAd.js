import axios from "axios";
import React, { useCallback, useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import './ViewAd.css';

function ViewAd() {

  const [adId, setAdId] = useState();
  const [userId, setUserId] = useState();
  const [description, setDescription] = useState();
  const [price, setPrice] = useState();
  const [returnedImg, setReturnedImg] = useState();
  const [serviceName, setServiceName] = useState();
  const [date, setDate] = useState(new Date());

  const { id } = useParams();

  const navigate=useNavigate();

  const handleView = async () => {
    const response = await axios
      .get(`http://localhost:8080/client/viewAd/${id}`)
      .catch((err) => console.log(err));

    setDescription(response.data.description);
    setAdId(response.data.id);
    setPrice(response.data.price);
    setReturnedImg(response.data.returnedImg);
    setUserId(response.data.userid);
    setServiceName(response.data.serviceName);

  };

  useEffect(() => {
    handleView();
  }, []);

  const handleBook=async ()=>{
    let bookDate=date.toString();

      const response=await axios.post(`http://localhost:8080/client/bookService/${adId}/${userId}/${bookDate}`).
      catch((err)=>console.log(err));
      console.log(response);
      navigate("/bookings")
  }

  return (
    <div style={{ marginTop: "10%" }}>
      <div className="container">
        <div className="left">
            <img src={`data:image/png;charset=utf-8;base64,${returnedImg}`} />

            <h4>{serviceName}</h4>
            <p>Price:{price}</p>
            <p className="desc">{description}</p>
        </div>

        <div className="right">
          <h4>Book Service</h4>
          <p>Date of Booking</p>
          <input type="date" name="date" onChange={(e)=>setDate(e.target.value)} value={date}/>
          <button onClick={handleBook}>Book</button>
        </div>
      </div>
    </div>
  );
}

export default ViewAd;
