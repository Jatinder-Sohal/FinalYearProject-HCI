import React from "react";
import Navbar from "../components/Navbar";
import Sidebar from "../components/Sidebar";
import ExpenceTable from "../components/ExpenceTable";
import SheetHeading from "../components/SheetHeading";

import './EnterData.css';

function EnterData(){
    return <div className="page3-container">
        <Navbar />
        <Sidebar />
        <SheetHeading />
        <ExpenceTable />
    </div>
}

export default EnterData;