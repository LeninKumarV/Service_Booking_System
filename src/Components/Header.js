import React from "react";
import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import { Link, useNavigate } from "react-router-dom";

function Header({
  setClick,
  click,
  logClk,
  sertLogClk,
  setLogResponse,
  id,
  setId,
  fileItem,
  setFile,
  fileData,
  setFileData,
}) {
  

  const navigate=useNavigate();
  const handleRegisterClick = (e) => {
    console.log("click");
  };

  const handleLogout=(e)=>{
    navigate("/login");
    sertLogClk(false);
    setClick("");
    setLogResponse(" ");
    setId(null);
    setFile(null);
    setFileData(null);
    console.log(id);
  }

  return (
    <div className="header">
      <Navbar
        expand="lg"
        bg="dark"
        data-bs-theme="dark"
        style={{ position: "fixed", left: "0%", right: "0%", top: "0%" ,zIndex:100}}
      >
        <Container>
          <Navbar.Brand href="#home">Service Booking System</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              {logClk && click==="client"? (
                <>
                  <Link to="/client-dashboard">
                    <Nav.Link href="#home">Dashboard</Nav.Link>
                  </Link>
                  <Link to="/bookings" >
                    <Nav.Link href="#link">Bookings</Nav.Link>
                  </Link>
                  <Link to="/login">
                    <Nav.Link href="#link" onClick={(e) => handleLogout(e)}>Logout</Nav.Link>
                  </Link>
                </>
              ) :
              logClk && click==="company"?

              <>
                  <Link to="/company-dashboard">
                    <Nav.Link href="#home">Dashboard</Nav.Link>
                  </Link>
                  <Link to="/postAd">
                    <Nav.Link href="#link">PostAd</Nav.Link>
                  </Link>
                  <Link to="/ads">
                    <Nav.Link href="#link">Ads</Nav.Link>
                  </Link>
                  <Link to="/login">
                    <Nav.Link href="#link" onClick={(e) => handleLogout(e)}>Logout</Nav.Link>
                  </Link>
                </>
              

              : (
                <>
                  <Link to="/">
                    <Nav.Link href="#home">Home</Nav.Link>
                  </Link>
                  <Link to="/register" onClick={(e) => handleRegisterClick(e)}>
                    <Nav.Link href="#link">Register</Nav.Link>
                  </Link>
                  <Link to="/login">
                    <Nav.Link href="#link">Login</Nav.Link>
                  </Link>
                </>
              )}
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
    </div>
  );
}

export default Header;
