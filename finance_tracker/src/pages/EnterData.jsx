import React from "react";
import Navbar from "../components/Navbar";
import Sidebar from "../components/Sidebar";
import ExpenceTable from "../components/ExpenceTable";

import Pencil from '../images/Pencil.png';
import Save from '../images/Save.png';


function EnterData(){
    return <div>
        <Navbar />
        <Sidebar />
        <div className="heading">
            <h2 className="sheet-heading" >Novemeber sheet</h2>
            <img id="pencil" src={Pencil} alt="Your Icon Alt Text" height="32" width="32"/>
            <h3> 21/10/23</h3>
        </div>
        <div className="save">
            <button className="btn btn-primary button-save" type="submit">
                <span className="text">Save sheet</span>
                <img src={Save} alt="Your Icon Alt Text" height="32" width="32"/>  
            </button>
        </div>
        <ExpenceTable />
    </div>
}

export default EnterData;