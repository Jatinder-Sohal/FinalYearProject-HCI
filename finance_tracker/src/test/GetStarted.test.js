import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import '@testing-library/jest-dom'; 

import GetStarted from '../components/GetStarted';
import { MemoryRouter } from 'react-router-dom';

test('If elements exist', () => {
  render(<GetStarted />);
  
  expect(screen.getByRole('button', { name: /Get Started/i })).toBeInTheDocument();

  const financialHeader = screen.getByRole('heading', { name: /Financial/i });
  const trackerHeader = screen.getByRole('heading', { name: /Tracker/i });

  expect(financialHeader).toBeInTheDocument();
  expect(trackerHeader).toBeInTheDocument();

  const getStarted = screen.getByRole('button', { name: /Get Started/i });
  expect(getStarted).toBeInTheDocument();  
});

