import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';

function GetStarted(){
    return(
    <div class="text-center">
        <h1 id="topWord">Financial </h1>
        <h1>Tracker</h1>
        <h2>Keep track of your spending habits</h2>
        <button type="button" class="btn btn-primary btn-lg">
        Get Started
        <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor" class="bi bi-arrow-right-circle-fill" viewBox="0 0 16 16">
            <path d="M8 0a8 8 0 1 1 0 16A8 8 0 0 1 8 0zM4.5 7.5a.5.5 0 0 0 0 1h5.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H4.5z"></path>
        </svg>    
        </button>
    </div>
    );
}

export default GetStarted;