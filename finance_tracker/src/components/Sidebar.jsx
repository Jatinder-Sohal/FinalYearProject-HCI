import React, { useState } from 'react';
import binIcon from '../images/Bin.png'; 

function Sidebar() {
    const initialSheets = ['Sheet 1', 'December 2021', 'Sheet 2', 'February 2022', 'October 2023', 'Sheet 2', 'January 2023', 'December 2022'];
    const [sheets, setSheets] = useState(initialSheets);

    function removeSheet(sheetBeingRemoved) {
        setSheets(sheets.filter(function(sheet) {
            return sheet !== sheetBeingRemoved;
        }));
    }

    return (
        <div className="sidebar">
            <div className="sidebar-content">
                <h1 className="sidebar-heading">Your sheets</h1>
                <ul className="sheet-list">
                    {sheets.map(function(sheet, index) {
                        return (
                            <li key={index} className="sheet-item">
                                {sheet}
                                <img 
                                    src={binIcon} 
                                    alt="Delete sheet in sidebar" 
                                    className="sheet-delete" 
                                    onClick={() => removeSheet(sheet)} 
                                />
                            </li>
                        );
                    })}
                </ul>
            </div>
        </div>   
    );
}

export default Sidebar;
