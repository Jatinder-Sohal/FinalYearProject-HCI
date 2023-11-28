import { useState } from "react";
import React from "react";
import Navbar from "../components/Navbar";
import Sidebar from "../components/Sidebar";
import ExpenceTable from "../components/ExpenceTable";
import SheetHeading from "../components/SheetHeading";

import './EnterData.css';

function EnterData() {
    const initialSheets = ['Sheet 1', 'December 2021', 'Sheet 2', 'February 2022', 'October 2023', 'Sheet 3', 'January 2023', 'December 2022'];
    const [sheets, setSheets] = useState(initialSheets);

    const addSheet = (newSheetName) => {
        if (newSheetName) {
            setSheets([...sheets, newSheetName]);
        }
    };

    const removeSheet = (sheetBeingRemoved) => {
        setSheets(sheets.filter(sheet => sheet !== sheetBeingRemoved));
    };

    return (
        <div className="page3-container">
            <Navbar />
            <Sidebar sheets={sheets} RemoveSheet={removeSheet} />
            <SheetHeading AddSheet={addSheet} />
            <ExpenceTable />
        </div>
    );
}

export default EnterData;