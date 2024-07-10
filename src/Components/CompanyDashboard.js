import axios from "axios";
import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

function CompanyDashboard() {
  const [data, setData] = useState([]);
  const replace = "Not Mentioned";
  const { id } = useParams();

  useEffect(() => {
    handleView();
  }, []);

  const handleView = async () => {
    const response = await axios
      .get(`http://localhost:8080/client/getCompanyAds/${id}`)
      .catch((err) => console.log(err));

    setData(response.data);
    console.log(data);
  };

  const handleAccept = async (m) => {
    const response = await axios
      .put(`http://localhost:8080/client/accepted/${m}`)
      .catch((err) => console.log(err));
      handleView();
    console.log(response.data);
  };

  const handleReject = async (m) => {
    const response = await axios
      .put(`http://localhost:8080/client/rejected/${m}`)
      .catch((err) => console.log(err));
      handleView();
    console.log(response.data);
  };

  return (
    <div className="CompanyDashboard" style={{ marginTop: "15%" }}>
      <div style={{ marginTop: "10%" }} className="clientBooking">
        <table>
          <tr>
            <th>Client Name</th>
            <th>Service Name</th>
            <th>Date</th>
            <th>Reservation Status</th>
            <th>Response</th>
          </tr>

          {data.map((m) => {
            return (
              <tr key={m.reservid}>
                <td>{m.username ? m.username : replace} </td>
                <td>{m.servicename ? m.servicename : replace}</td>
                <td>{m.bookDate ? m.bookDate : replace}</td>
                <td>{m.reservationStatus ? m.reservationStatus : replace}</td>
                <td>
                  {m.reservationStatus === "PENDING" ? (
                    <>
                      <button onClick={() => handleAccept(m.reservid)}>
                        Accept
                      </button>
                      <button onClick={() => handleReject(m.reservid)}>
                        Reject
                      </button>
                    </>
                  ) : null}
                </td>
              </tr>
            );
          })}
        </table>
      </div>
    </div>
  );
}

export default CompanyDashboard;
