import Header from "./Components/Header";
import "./App.css";
import CompanyRegister from "./Components/CompanyRegister";
import ClientRegister from "./Components/ClientRegister";
import { Route, Routes } from "react-router-dom";
import Home from "./Components/Home";
import RegisterRoute from "./Components/RegisterRoute";
import Login from "./Components/Login";
import { useState } from "react";
import ClientDashboard from "./Components/ClientDashboard";
import CompanyDashboard from "./Components/CompanyDashboard";
import Bookings from "./Components/Bookings";
import PostAd from "./Components/PostAd";
import Ads from "./Components/Ads";
import Update from "./Components/Update";
import Search from "./Components/Search";
import ViewAd from "./Components/ViewAd";
import ClientBookings from "./Components/ClientBookings";

function App() {
  const [click, setClick] = useState(false);
  const [logClk, sertLogClk] = useState("");
  const [id, setId] = useState(null);

  const [logResponse, setLogResponse] = useState(" ");

  const [fileItem, setFile] = useState(null);
  const [fileData, setFileData] = useState(null);
  const [description, setDescription] = useState("");
  const [service_name, setService_name] = useState("");
  const [price, setPrice] = useState(0.0);
  const [result, SetResult] = useState("");

  const [adId, setAdId] = useState(null);

  return (
    <div className="App">
      <Header
        click={click}
        setClick={setClick}
        logClk={logClk}
        sertLogClk={sertLogClk}
        logResponse={logResponse}
        setLogResponse={setLogResponse}
        id={id}
        setId={setId}
        fileItem={fileItem}
        setFile={setFile}
        fileData={fileData}
        setFileData={setFileData}
      />
      <Routes>
        <Route path="/" element={<Home />} index={Header} />
        <Route path="/register" element={<RegisterRoute />} />
        <Route path="/client-signup" element={<ClientRegister />} />
        <Route path="/company-signup" element={<CompanyRegister />} />
        <Route
          path="/login"
          element={
            <Login
              logResponse={logResponse}
              setLogResponse={setLogResponse}
              sertLogClk={sertLogClk}
              setClick={setClick}
              id={id}
              setId={setId}
            />
          }
        />
        <Route path="/client-dashboard" element={<ClientDashboard/>} />
        <Route path="/company-dashboard/:id" element={<CompanyDashboard />} />
        <Route path="/bookings" element={<ClientBookings />} />
        <Route
          path="/postAd"
          element={
            <PostAd
              id={id}
              fileItem={fileItem}
              setFile={setFile}
              fileData={fileData}
              setFileData={setFileData}
              description={description}
              setDescription={setDescription}
              service_name={service_name}
              setService_name={setService_name}
              price={price}
              setPrice={setPrice}
              result={result}
              SetResult={SetResult}
            />
          }
        />
        <Route
          path="/ads"
          element={
            <Ads
              id={id}
              adId={adId}
              setAdId={setAdId}
              result={result}
              SetResult={SetResult}
            />
          }
        />
        <Route
          path="/updateAd"
          element={
            <Update
              id={id}
              fileItem={fileItem}
              setFile={setFile}
              fileData={fileData}
              setFileData={setFileData}
              description={description}
              setDescription={setDescription}
              service_name={service_name}
              setService_name={setService_name}
              price={price}
              setPrice={setPrice}
              result={result}
              SetResult={SetResult}
              adId={adId}
            />
          }
        />

        <Route path="/serach" element={<Search/>}/>
        <Route path="/viewAd/:id"  element={<ViewAd/>}/>
      </Routes>
    </div>
  );
}

export default App;
