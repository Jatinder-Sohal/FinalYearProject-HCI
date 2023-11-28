import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';

import Pencil from '../images/Pencil.png';
import Save from '../images/Save.png';

function SheetHeading() {
    return (
        <div>
            <div className="heading">
                <input className="sheet-heading" type="text" placeholder="November sheet" aria-label="User Input for expence sheet"></input>
                <img id="pencil" src={Pencil} alt="Icon of pencil, to change title" height="32" width="32"/>
                <h2 className="page3-h2"> 21/10/23</h2>
            </div>
            <div className="save-sheet">
                <button className="btn button-save" type="submit">
                    <span className="text">Save sheet</span>
                    <img className="save-icon" src={Save} alt="Save button" height="32" width="32"/>  
                </button>
            </div>
        </div>
        );
    }
    
    export default SheetHeading