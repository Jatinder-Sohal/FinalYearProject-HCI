import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import '@testing-library/jest-dom'; 

import Sidebar from '../components/Sidebar';

test('Sheets in sidebar', () => {
    const sheets = ['Sheet1', 'Sheet2', 'Sheet3'];
    render(<Sidebar sheets={sheets} />);
  
    sheets.forEach((sheet) => {
      expect(screen.getByText(sheet)).toBeInTheDocument();
    });
  });
  