import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import '@testing-library/jest-dom'; 
import { useState } from 'react';
import Sidebar from '../components/Sidebar';

test('Sheets in sidebar', () => {
    const sheets = ['Sheet1', 'Sheet2', 'Sheet3'];
    render(<Sidebar sheets={sheets} />);
  
    sheets.forEach((sheet) => {
      expect(screen.getByText(sheet)).toBeInTheDocument();
    });
});
test('Delete function called with correct argument', () => {
  const sheets = ['Sheet1', 'Sheet2', 'Sheet3'];
  const fakeRemove = jest.fn();
  render(<Sidebar sheets={sheets} RemoveSheet={fakeRemove} />);

  fireEvent.click(screen.getAllByAltText('Delete sheet')[0]);

  expect(fakeRemove).toHaveBeenCalledWith('Sheet1');
});
test('OnSheetClick function called on sheet click', () => {
  const sheets = ['Sheet1', 'Sheet2', 'Sheet3'];
  const fakeOnSheetClick = jest.fn();
  render(<Sidebar sheets={sheets} OnSheetClick={fakeOnSheetClick} />);

  fireEvent.click(screen.getByText('Sheet2'));

  expect(fakeOnSheetClick).toHaveBeenCalledWith('Sheet2');
});

   