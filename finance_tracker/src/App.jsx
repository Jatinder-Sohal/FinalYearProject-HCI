import React from "react";
import Navbar from "./components/Navbar";
import GetStarted from "./components/GetStarted";
import InfoCards from "./components/InfoCards";
import './App.css';

function App(){
    return <div className="page1-container">
        <Navbar />
        <GetStarted />
        <InfoCards />
    </div>
}

export default App;