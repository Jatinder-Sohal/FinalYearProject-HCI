import React from 'react';
import binIcon from '../images/Bin.png'; 

// Used for event propagation: https://stackoverflow.com/questions/38619981/how-can-i-prevent-event-bubbling-in-nested-react-components-on-click#:~:text=class%20List%20extends%20React.Component%20,li


/**
 * Sidebar component which displays sheets array and allows dynamic deleting of any
 * @param {array} sheets array which contains all sidebar sheets
 * @param {prop} RemoveSheet prop which allows any sheet to be removed
 * @param {prop} OnSheetClick prop which updates name of current sheet with sidebar name
 * @returns component as a single div
 */
function Sidebar({ sheets, RemoveSheet, OnSheetClick }) {
    /**
     * Stops delete button click from updating sheet name 
     * @param {String} sheet Sheet to be removed from sider
     */
    const handleDeleteClick = (event, sheet) => {
        event.stopPropagation();
        //Removing sheet from sidebar 
        RemoveSheet(sheet);
    };

    return (
        <div className="sidebar">
            <div className="sidebar-content">
                <h1 className="sidebar-heading">Your sheets</h1>
                <ul className="sidebar-list">
                    {/* Mapping over sheet arrat and printing out in sidebar*/}
                    {sheets.map((sheet, index) => (
                        //Sidebar item which updates whole sheet name with a click
                        <li key={index} className="sidebar-item" onClick={() => OnSheetClick(sheet)}>
                            {sheet}
                            {/* Delete button for sidebar item */}
                            <img src={binIcon} alt="Delete sheet" className="sidebar-sheet-delete" onClick={(event) => handleDeleteClick(event, sheet)}/>
                        </li>
                    ))}
                </ul>
            </div>
        </div>   
    );
}

export default Sidebar;