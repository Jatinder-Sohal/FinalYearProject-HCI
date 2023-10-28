import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';

function Navbar(){
   return (
    <nav className="navbar navbar-expand-lg navbar-custom" data-bs-theme="dark">
    <div className="container-fluid">
      <a className="navbar-brand" href="#">Financial Tracker</a>
      <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span className="navbar-toggler-icon"></span>
      </button>
      <div className="collapse navbar-collapse" id="navbarSupportedContent">
        <ul className="navbar-nav me-auto mb-2 mb-lg-0">
          <li className="nav-item">
            <a className="nav-link active" aria-current="page" href="./home.html">Home</a>
          </li>
          <li className="nav-item">
            <a className="nav-link " href="./data.html">Enter data</a>
          </li>
          <li className="nav-item dropdown">
            <a className="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Select Output
            </a>
            <ul className="dropdown-menu">
              <li><a className="dropdown-item" href="#">Plain text</a></li>
              <li><hr className="dropdown-divider" /></li>
              <li><a className="dropdown-item" href="#">Pie chart</a></li>
              <li><hr className="dropdown-divider" /></li>
              <li><a className="dropdown-item" href="#">Line graph</a></li>
              <li><hr className="dropdown-divider" /></li>
              <li><a className="dropdown-item" href="#">Bar graph</a></li>
            </ul>
          </li>       
        </ul> 
        <span className="navbar-text">
          <button type="button" className="btn btn-outline-info" onclick="loadHelp()">Need help?</button>         
        </span>       
      </div>
    </div>
    </nav>
    );
}

export default Navbar;