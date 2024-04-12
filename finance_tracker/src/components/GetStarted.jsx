import React from "react";

/**
 * GetStarted component, display text on home screen
 * @returns GetStarted component as a div
 */
function GetStarted(){
    return(
    <div className="text-center">
        {/* Split into 2 h1 due to wierd bug */}
        <h1 id="topWord" className="page1-h1">Financial </h1>
        <h1 className="page1-h1">Tracker</h1>
        <h2 className="page1-h2">Keep track of your spending habits</h2>
        {/* Get started button with right arrow */}
        <a href="Enter">
            <button type="button" className="btn btn-primary btn-lg" >
                Get Started
                <svg id="arrow" xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor" className="bi bi-arrow-right-circle-fill" viewBox="0 0 16 16">
                    <path d="M8 0a8 8 0 1 1 0 16A8 8 0 0 1 8 0zM4.5 7.5a.5.5 0 0 0 0 1h5.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H4.5z"></path>
                </svg>    
            </button>
        </a>         
    </div>
    );
}

export default GetStarted;