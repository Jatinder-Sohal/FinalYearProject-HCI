import React from "react";
import Navbar from "../components/Navbar";
import HelpCards from "../components/HelpCards";
import './HelpPage.css';

/**
 * Help page component, all content inside help cards
 * @returns Help page as a div to be displayed
 */
function HelpPage(){
    return (
    <div className="page2-container">
        <Navbar />
        <HelpCards />
    </div>
    );
}

export default HelpPage;