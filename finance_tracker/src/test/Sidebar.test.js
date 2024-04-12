import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import '@testing-library/jest-dom'; 
import { useState } from 'react';
import Sidebar from '../components/Sidebar';

/**
 * Testing if sidebar sheets are in document
 */
test('Sheets in sidebar', () => {
    const sheets = ['Sheet1', 'Sheet2', 'Sheet3'];
    render(<Sidebar sheets={sheets} />);
    //Looping through sheets and checking screen
    sheets.forEach((sheet) => {
      expect(screen.getByText(sheet)).toBeInTheDocument();
    });
});
/**
 * Testing if the right sheet was going to be removed
 */
test('Delete function called with correct argument', () => {
  const sheets = ['Sheet1', 'Sheet2', 'Sheet3'];
  const fakeRemove = jest.fn();
  render(<Sidebar sheets={sheets} RemoveSheet={fakeRemove} />);

  fireEvent.click(screen.getAllByAltText('Delete sheet')[0]);

  //Checking if the function was called with the correct argument
  expect(fakeRemove).toHaveBeenCalledWith('Sheet1');
});
/**
 * Testing if OnSheetClick function works 
 */
test('OnSheetClick function called on sheet click', () => {
  const sheets = ['Sheet1', 'Sheet2', 'Sheet3'];
  const fakeOnSheetClick = jest.fn();
  render(<Sidebar sheets={sheets} OnSheetClick={fakeOnSheetClick} />);

  fireEvent.click(screen.getByText('Sheet2'));
  //Checking argument that function was called with
  expect(fakeOnSheetClick).toHaveBeenCalledWith('Sheet2');
});

   