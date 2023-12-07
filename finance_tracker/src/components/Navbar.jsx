import React from "react";
import { useLocation } from "react-router-dom";

import SettingsMenu from './SettingsMenu';

/**
 * Navbar with consistent elements throughout application, but with varying styling
 * depending on what page the application is on
 * @returns the navbar as a single div
 */
function Navbar(){
  /**
   * Getting site location, to switch css variables
   */
  const location = useLocation();

  /**
   * Setting css variables to home page elements
   */
  let navbarClass = "navbar navbar-expand-lg navbar-custom";
  let buttonClass = "btn btn-outline-info"; 
  let homeLink = "nav-link";
  let enterLink = "nav-link";
  let displayLink = "dropdown-item";

  /**
   * If loop which changes css variables to specific names depending on site location
   * homeLink var turns navbar text white to show which page
   */
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
    /**
     * Main navbar structure
     */
    <nav className={navbarClass} data-bs-theme="dark">
    <div className="container-fluid">
      {/* Financial tracker logo at start  */}
      <a className="navbar-brand" href="/">Financial Tracker</a>
      {/* Created in case of the page being minimized */}
      <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span className="navbar-toggler-icon"></span>
      </button>
      <div className="collapse navbar-collapse" id="navbarSupportedContent">
        <ul className="navbar-nav me-auto mb-2 mb-lg-0">
          {/* Home button */}
          <li className="nav-item">
            <a className={homeLink} aria-current="page" href="/">Home</a>
          </li>
          {/* Enter data button */}
          <li className="nav-item">
            <a className={enterLink} href="Enter">Enter data</a>
          </li>
          {/* Dropdown for selecting output of data */}
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
        {/* Span which stores items on the right of navbar */}
        <span className="help-text">
          {/* Settings icon */}
          <SettingsMenu /> 
          <a href="Help" type="button" className={buttonClass}>Need help?</a>        
        </span>    
      </div>
    </div>
    </nav>
    );
}

export default Navbar;