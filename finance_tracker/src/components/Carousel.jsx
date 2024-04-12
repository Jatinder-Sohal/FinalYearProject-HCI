import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';
import Pie_chart from '../images/Pie_chart.png';
import Bar_graph from '../images/Bar_graph.png';
import Line_graph from '../images/Line_graph.png';

/**
 * Carousel component which puts 3 images in a scrolling slideshow
 * @returns carousel as a div
 */
function Carousel(){
    return(
        <div id="carouselExampleIndicators" className="carousel slide">
            {/* Indicators for which picture is being shown */}
            <div className="carousel-indicators">
              <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" className="active" aria-current="true" aria-label="Slide 1"></button>
              <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
              <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
            </div>
            {/* The images stored in seperate divs */}
            <div className="carousel-inner">
              <div className="carousel-item active">
                <img src={Pie_chart} className="d-block w-100" alt="Pie chart" />
              </div>
              <div className="carousel-item">
                <img src={Bar_graph} className="d-block w-100" alt="Bar graph" />
              </div>
              <div className="carousel-item">
                <img src={Line_graph} className="d-block w-100" alt="Line graph" />
              </div>
            </div>
            {/* Buttons to move back and forth between pictures in carousel */}
            <button className="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
              <span className="carousel-control-prev-icon" aria-hidden="true"></span>
              <span className="visually-hidden">Previous</span>
            </button>
            <button className="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
              <span className="carousel-control-next-icon" aria-hidden="true"></span>
              <span className="visually-hidden">Next</span>
            </button>
        </div>
    );
}

export default Carousel;