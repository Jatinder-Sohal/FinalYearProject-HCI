import React from 'react';
import { render, screen } from '@testing-library/react';
import { MemoryRouter } from 'react-router-dom'; 
import SettingsMenu from '../components/SettingsMenu';
import '@testing-library/jest-dom';

test('Settings element loads', () => {
  render(
    <MemoryRouter>
      <SettingsMenu />
    </MemoryRouter>
  );
  const settingsMenu = screen.getByAltText("Settings")
  expect(settingsMenu).toBeInTheDocument();
});