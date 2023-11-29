import React from 'react';
import binIcon from '../images/Bin.png'; 

function Sidebar({sheets, RemoveSheet}) {
    return (
        <div className="sidebar">
            <div className="sidebar-content">
                <h1 className="sidebar-heading">Your sheets</h1>
                <ul className="sidebar-list">
                    {sheets.map((sheet, index) => (
                        <li key={index} className="sidebar-item">
                            {sheet}
                            <img 
                                src={binIcon} 
                                alt="Delete sheet" 
                                className="sidebar-sheet-delete"
                                onClick={() => RemoveSheet(sheet)} 
                            />
                        </li>
                    ))}
                </ul>
            </div>
        </div>   
    );
}

export default Sidebar;