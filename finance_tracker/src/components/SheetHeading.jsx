import React, { useState } from "react";
import Pencil from '../images/Pencil.png';
import Save from '../images/Save.png';

//Used https://stackoverflow.com/questions/71039088/what-is-onchange-e-setnamee-target-value-in-react-mean

function SheetHeading({AddSheet}) {
    const [sheetName, setSheetName] = useState('');

    const handleSave = () => {
        AddSheet(sheetName);
    };

    return (
        <div>
            <div className="heading">
                <input className="sheet-heading" value={sheetName} onChange={(e) => setSheetName(e.target.value)} type="text" placeholder="November sheet" aria-label="User Input for expense sheet"></input>
                <img id="pencil" src={Pencil} alt="Icon of pencil, to change title" height="32" width="32"/>
                <h2 className="page3-h2"> 29/11/23</h2>
            </div>
            <div className="save-sheet">
                <button className="btn button-save" type="submit" onClick={handleSave}>
                    <span className="text">Save sheet</span>
                    <img className="save-icon" src={Save} alt="Save button" height="32" width="32"/>  
                </button>
            </div>
        </div>
        );
    }
    
    export default SheetHeading