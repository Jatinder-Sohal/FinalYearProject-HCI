import React from "react";
import Navbar from "../components/Navbar";
import Sidebar from "../components/Sidebar";
import ExpenceTable from "../components/ExpenceTable";

import Pencil from '../images/Pencil.png';
import Save from '../images/Save.png';

import './EnterData.css';

function EnterData(){
    return <div className="page3-container">
        <Navbar />
        <Sidebar />
        <div className="heading">
            <h1 className="sheet-heading" >Novemeber sheet</h1>
            <img id="pencil" src={Pencil} alt="Icon of pencil, to change title" height="32" width="32"/>
            <h2 className="page3-h2"> 21/10/23</h2>
        </div>
        <div className="save">
            <button className="btn btn-primary button-save" type="submit">
                <span className="text">Save sheet</span>
                <img src={Save} alt="Save button" height="32" width="32"/>  
            </button>
        </div>
        <ExpenceTable />
    </div>
}

export default EnterData;