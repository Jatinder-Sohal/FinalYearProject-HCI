import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';

function sidebar(){
    return (
        <div class="sidebar">
        <div class="sidebar-content">
            <h1>Your sheets</h1>
            <ul class="sheet-list">
                <li class="sheet-item">Sheet 1</li>
                <li class="sheet-item">December 2021</li>
                <li class="sheet-item">Sheet 2</li>
                <li class="sheet-item">Feburary 2022</li>
                <li class="sheet-item">October 2023</li>
            </ul>
        </div>
        </div>   
    );
}

export default sidebar;