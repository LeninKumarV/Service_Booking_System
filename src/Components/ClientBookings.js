import axios from "axios";
import React, { useEffect, useState } from "react";
import "./ClientBookings.css";
import { useNavigate } from "react-router-dom";

function ClientBookings() {
  const [data, setData] = useState([]);
    const replace="Not Mentioned";

  useEffect(() => {
    handleView();
  }, []);

  const handleView = async () => {
    const response = await axios
      .get("http://localhost:8080/client/getAllBookings")
      .catch((err) => console.log(err));

    setData(response.data);
    console.log(data);
  };

  return (
    <div style={{ marginTop: "10%" }} className="clientBooking">
      <table>
        <tr>
          <th>Company Name</th>
          <th>Service Name</th>
          <th>Date</th>
          <th>Reservation Status</th>
        </tr>

        {data.map((m) => {
          return (
            <tr key={m.reservid}>
              <td>{m.companyname ? m.companyname : replace} </td>
              <td>{m.servicename ? m.servicename : replace}</td>
              <td>{m.bookDate ? m.bookDate : replace}</td>
              <td>{m.reservationStatus ? m.reservationStatus : replace}</td>
            </tr>
          );
        })}
      </table>
    </div>
  );
}

export default ClientBookings;
