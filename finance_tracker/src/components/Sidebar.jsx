import React from 'react';
import binIcon from '../images/Bin.png'; 

/* USed for event propagation
https://stackoverflow.com/questions/38619981/how-can-i-prevent-event-bubbling-in-nested-react-components-on-click#:~:text=class%20List%20extends%20React.Component%20,li
*/

function Sidebar({ sheets, RemoveSheet, OnSheetClick }) {
    const handleDeleteClick = (event, sheet) => {
        event.stopPropagation(); 
        RemoveSheet(sheet);
    };

    return (
        <div className="sidebar">
            <div className="sidebar-content">
                <h1 className="sidebar-heading">Your sheets</h1>
                <ul className="sidebar-list">
                    {sheets.map((sheet, index) => (
                        <li key={index} className="sidebar-item" onClick={() => OnSheetClick(sheet)}>
                            {sheet}
                            <img 
                                src={binIcon} 
                                alt="Delete sheet" 
                                className="sidebar-sheet-delete"
                                onClick={(event) => handleDeleteClick(event, sheet)}
                            />
                        </li>
                    ))}
                </ul>
            </div>
        </div>   
    );
}

export default Sidebar;