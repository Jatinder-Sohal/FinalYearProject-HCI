import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import '@testing-library/jest-dom'; 

import GetStarted from '../components/GetStarted';

test('if get start elements exsist', () => {
  render(<GetStarted />);
  
  expect(screen.getByRole('button', { name: /Get Started/i })).toBeInTheDocument();

  const financialHeader = screen.getByRole('heading', { name: /Financial/i });
  const trackerHeader = screen.getByRole('heading', { name: /Tracker/i });

  expect(financialHeader).toBeInTheDocument();
  expect(trackerHeader).toBeInTheDocument();

  const button = screen.getByRole('button', { name: /Get Started/i });
  expect(button).toBeInTheDocument();  
});
