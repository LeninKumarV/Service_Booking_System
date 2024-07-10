import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import "./Ads.css";
import Search from "./Search";

function ClientDashboard() {
  const [data, setData] = useState([]);
  const navigate = useNavigate();
  const [searchData, setSearchData] = useState([]);
  const [searchClick, setSearchClick] = useState(false);

  useEffect(() => {
    handleDisplay();
  }, []);

  const handleDisplay = async () => {
    const response = await axios
      .get(`http://localhost:8080/client/clientData`)
      .catch((err) => console.log(err));
    setData(response.data);
    console.log(data);
  };

  const handleViewData = () => {
    navigate("/viewAd");
  };

  return (
    <div className="ClientDashboard" style={{ marginTop: "5%" }}>
      <Search
        searchData={searchData}
        setSearchData={setSearchData}
        searchClick={searchClick}
        setSearchClick={setSearchClick}
      />
      {searchData.length !== 0 && searchClick === true ? (
        searchData.map((m) => {
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
                  <Link to={`/viewAd/${m.id}`}>
                    <button onClick={() => handleViewData(m.id)}>View</button>
                  </Link>
                </div>
              </div>
            </div>
          );
        })
      ) : (
        <>
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
                      <Link to={`/viewAd/${m.id}`}>
                        <button onClick={() => handleViewData(m.id)}>
                          View
                        </button>
                      </Link>
                    </div>
                  </div>
                </div>
              );
            })
          )}
        </>
      )}
    </div>
  );
}

export default ClientDashboard;
