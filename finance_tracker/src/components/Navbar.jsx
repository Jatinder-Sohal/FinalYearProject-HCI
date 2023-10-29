import React from "react";

import { useLocation } from "react-router-dom";



function Navbar(){
  const location = useLocation();

  let navbarClass = "navbar navbar-expand-lg navbar-custom";
  let buttonClass = "btn btn-outline-info"; 
  let homeLink = "nav-link";
  let enterLink = "nav-link";
  let displayLink = "dropdown-item";

  if (location.pathname === "/") {
    navbarClass = "navbar navbar-expand-lg navbar-home";
    buttonClass = "btn btn-outline-info custom-home"; 
    homeLink = "nav-link active";
  } else if (location.pathname === "/Help") {
    navbarClass = "navbar navbar-expand-lg navbar-help";
    buttonClass = "btn btn-outline-info custom-helps";
  } else if (location.pathname === "/Enter") {
    navbarClass = "navbar navbar-expand-lg navbar-enter";
    buttonClass = "btn btn-outline-info custom-enter"; 
    enterLink = "nav-link active";
  } else if (location.pathname === "/Display") {
    navbarClass = "navbar navbar-expand-lg navbar-display";
    buttonClass = "btn btn-outline-info custom-display"; 
    displayLink ="dropdown-item active"
  }
   return (
    <nav className={navbarClass} data-bs-theme="dark">
    <div className="container-fluid">
      <a className="navbar-brand" href="/">Financial Tracker</a>
      <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span className="navbar-toggler-icon"></span>
      </button>
      <div className="collapse navbar-collapse" id="navbarSupportedContent">
        <ul className="navbar-nav me-auto mb-2 mb-lg-0">
          <li className="nav-item">
            <a className={homeLink} aria-current="page" href="/">Home</a>
          </li>
          <li className="nav-item">
            <a className={enterLink} href="Enter">Enter data</a>
          </li>
          <li className="nav-item dropdown">
            <a className="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Select Output
            </a>
            <ul className="dropdown-menu">
              <li><a className={displayLink} href="Display">Pie chart</a></li>
              <li><hr className="dropdown-divider" /></li>
              <li><a className={displayLink} href="Display">Line graph</a></li>
              <li><hr className="dropdown-divider" /></li>
              <li><a className={displayLink} href="Display">Bar graph</a></li>
            </ul>
          </li>       
        </ul> 
        <span className="help_text">
          <a href="Help" type="button" className={buttonClass}>Need help?</a>        
        </span>    
      </div>
    </div>
    </nav>
    );
}

export default Navbar;