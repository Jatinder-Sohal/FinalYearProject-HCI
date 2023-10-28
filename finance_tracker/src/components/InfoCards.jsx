import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';

function InfoCards(){
    return (
        <div className="d-flex justify-content-center align-items-center">
          <div className="row page1-row">
            <div className="col page1-col">
              <div className="card bg-custom-1 mb-2">
                <div className="card-header"><h5 className="card-title">How to use</h5></div>
                <div className="card-body">
                  <p className="card-text">Start by entering your income and key expenditures into the calculator, which will provide you with a visual breakdown</p>
                </div>
              </div>
            </div>
            <div className="col page1-col">
              <div className="card bg-custom-1 mb-3">
                <div className="card-header"><h5 className="card-title">Benefits?</h5></div>
                <div className="card-body">
                  <p className="card-text">The calculator will show several ways to view the results, calculate taxes owed, and even provide some recommendations on how to cut costs</p>
                </div>
              </div>
            </div>
            <div className="col page1-col">
              <div className="card bg-custom-1 mb-3">
                <div className="card-header"><h5 className="card-title">I entered a wrong value</h5></div>
                <div className="card-body">
                  <p className="card-text">You can reset the calculator by clicking the refresh button, which will start the process again. If you need extra help, please click the button in the top right of the page</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      );
    }

export default InfoCards;
