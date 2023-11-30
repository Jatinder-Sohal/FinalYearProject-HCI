import React from "react";
import Navbar from "../components/Navbar";
import HelpCards from "../components/HelpCards";
import './HelpPage.css';

function HelpPage(){
    return (
    <div className="page2-container">
        <Navbar />
        <HelpCards />
    </div>
    );
}

export default HelpPage;