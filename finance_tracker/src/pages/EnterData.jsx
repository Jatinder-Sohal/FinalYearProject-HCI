import { useState } from "react";
import React from "react";
import Navbar from "../components/Navbar";
import Sidebar from "../components/Sidebar";
import ExpenseTable from "../components/ExpenseTable";
import SheetHeading from "../components/SheetHeading";

import './EnterData.css';

/**
 * EnterData compoent for  loading expense table, sidebar and a page heading
 * Contains consts to dynamically update sidebar content and heading of page
 * @returns EnterData page as a single div
 */
function EnterData() {
    /**
     * Orginal sidebar sheets on page loading
     */
    const initialSheets = ['Sheet 1', 'December 2021', 'Sheet 2', 'February 2022', 'October 2023', 'Sheet 3', 'January 2023', 'December 2022'];
    /**
     * Hook to update sheets
     */
    const [sheets, setSheets] = useState(initialSheets);

    /**
     * If newSheet is not empty split original sheet array and adds newSheet to the end
     * @param {String} newSheetName - Name of new sheet being added
     */
    const addSheet = (newSheetName) => {
        if (newSheetName) {
            setSheets([...sheets, newSheetName]);
        }
    };

    /**
     * Removes sheet from sidebar on delete button press
     * @param {String} sheetBeingRemoved - Sheet being removed
     */
    const removeSheet = (sheetBeingRemoved) => {
        // Only adds sheet to array if not the one being removed 
        setSheets(sheets.filter(sheet => sheet !== sheetBeingRemoved));
    };
    /**
     * Hook that sets title to Novemeber on start
     */
    const [currentName, setSheetName] = useState('November sheet');

    /**
     * function  which updates sheet name with input from user
     * @param {String} sheetName - New sheet name 
     */
    const changeSheetName= (sheetName) => {
        setSheetName(sheetName);
    };

    /**
     * Placing components inside div, with props to dynamically update sidebar and heading
     */
    return (
        <div className="page3-container">
            <Navbar />
            <Sidebar sheets={sheets} RemoveSheet={removeSheet}  OnSheetClick={changeSheetName} />
            <SheetHeading AddSheet={addSheet} currentName={currentName} />
            <ExpenseTable deleteTitle={changeSheetName} />
        </div>
    );
}

export default EnterData;