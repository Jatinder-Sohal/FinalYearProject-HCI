import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';

function sidebar(){
    return (
        <div className="sidebar">
        <div className="sidebar-content">
            <h1 className="sheet-heading">Your sheets</h1>
            <ul className="sheet-list">
                <li className="sheet-item">Sheet 1</li>
                <li className="sheet-item">December 2021</li>
                <li className="sheet-item">Sheet 2</li>
                <li className="sheet-item">Feburary 2022</li>
                <li className="sheet-item">October 2023</li>
            </ul>
        </div>
        </div>   
    );
}

export default sidebar;