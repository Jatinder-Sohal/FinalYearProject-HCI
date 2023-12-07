import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import { MemoryRouter } from 'react-router-dom'; 
import SettingsMenu from '../components/SettingsMenu';
import App from "../App";

import '@testing-library/jest-dom';

test('Setting elements loading', () => {
    render(
        <MemoryRouter>
            <SettingsMenu />
        </MemoryRouter>
    );
    const settingsMenu = screen.getByAltText("Settings")
    expect(settingsMenu).toBeInTheDocument();

});

test('Enlarge text checkbox', () => {
    render(
        <MemoryRouter>
            <App />
        </MemoryRouter>
    );
    const enlargeTextCheckbox = screen.getByText('Enlarge Text').closest('label').querySelector('input');
    fireEvent.click(enlargeTextCheckbox);
  
    const homePageText = screen.getByText('Financial');
    expect(homePageText).toHaveStyle('font-size: 2em');
});
test('High Contrast Mode checkbox', () => {
    render(
        <MemoryRouter>
            <App />
        </MemoryRouter>
    );

    const highContrastCheckbox = screen.getByText('High Contrast Mode').closest('label').querySelector('input');
    fireEvent.click(highContrastCheckbox);

    const bodyElement = document.body;
    expect(bodyElement).toHaveStyle('background-image:');
});

test('Tritanopia checkbox', () => {
    render(
        <MemoryRouter>
            <App />
        </MemoryRouter>
    );

    const highContrastCheckbox = screen.getByText('Tritanopia (Blue-Blind)').closest('label').querySelector('input');
    fireEvent.click(highContrastCheckbox);

    const bodyElement = screen.getByText('Need help?');
    expect(bodyElement).toHaveStyle('color: rgb(8, 217, 214), #BE9FE1');
});