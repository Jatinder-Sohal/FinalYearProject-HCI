import React, { useState } from "react";
import { useEffect } from "react";
import Pencil from '../images/Pencil.png';
import Save from '../images/Save.png';

//Used https://stackoverflow.com/questions/71039088/what-is-onchange-e-setnamee-target-value-in-react-mean

/**
 * Function that sets heading
 * @param {prop} AddSheet  Passed as param so I can putting heading as a sidebar item
 * @param {prop} currentName Replaces name with this new sheet name
 * @returns 
 */
function SheetHeading({AddSheet, currentName}) {
    const [sheetName, setSheetName] = useState('');

    /**
     * Adding sheetName to new sidebar sheet
     */
    const handleSave = () => {
        AddSheet(sheetName);
    };

    /**
     * Replace sheetName with sidebar item
     */
    useEffect(() => {
        setSheetName(currentName);
    }, [currentName]);

    return (
        <div>
            <div className="heading">
                {/* Heading which waits for any input, to update sheet heading with */}
                <input className="sheet-heading" value={sheetName} onChange={(e) => setSheetName(e.target.value)} type="text"  aria-label="User Input for expense sheet"></input>
                {/* Pencil icon next to heading */}
                <img id="pencil" src={Pencil} alt="Icon of pencil, to change title" height="32" width="32"/>
                <h2 className="page3-h2"> 29/11/23</h2>
            </div>
            {/* Button to save sheet */}
            <div className="save-sheet">
                <button className="btn button-save" type="submit" onClick={handleSave}>
                    <span className="text">Save sheet</span>
                    {/* Save icon next to text */}
                    <img className="save-icon" src={Save} alt="Save button" height="32" width="32"/>  
                </button>
            </div>
        </div>
        );
    }
    
    export default SheetHeading