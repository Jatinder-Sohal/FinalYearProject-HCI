import React from 'react';
import { render, screen } from '@testing-library/react';
import '@testing-library/jest-dom'; 

import GetStarted from './GetStarted';

test('renders GetStarted component', () => {
  render(<GetStarted />);
  
  expect(screen.getByRole('button', { name: /Get Started/i })).toBeInTheDocument();

  const financialHeader = screen.getByRole('heading', { name: /Financial/i });
  const trackerHeader = screen.getByRole('heading', { name: /Tracker/i });

  expect(financialHeader).toBeInTheDocument();
  expect(trackerHeader).toBeInTheDocument();
});
