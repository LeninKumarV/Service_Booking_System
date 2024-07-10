import React from "react";
import { Link } from "react-router-dom";
import "./RegisterRoute.css";

function RegisterRoute() {
  return (
    <div className="RegisterRoute">
      <form>
        <h3>Welcome to the Register page!</h3>
        <button style={{ border: "none", outline: "none" }}>
          <Link to="/client-signup" color="#333" className="link">
            Client Register
          </Link>
        </button>
        <button style={{ border: "none", outline: "none" }}>
          <Link to="/company-signup" className="link">
            Company Register
          </Link>
        </button>
      </form>
    </div>
  );
}

export default RegisterRoute;
