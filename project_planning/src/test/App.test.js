import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import '@testing-library/jest-dom';
import App from '../App';

test('Testing if App renders elements correctly', async () => {
  render(<App />);

  const boardDate = await screen.findByText('First Created: 5/03/2024');
  expect(boardDate).toBeInTheDocument();
  
  const boardTitle = screen.getByText('Kanban Board'); 
  expect(boardTitle).toBeInTheDocument();

  const settings = screen.getByText('Contract Us'); 
  expect(settings).toBeInTheDocument();

});