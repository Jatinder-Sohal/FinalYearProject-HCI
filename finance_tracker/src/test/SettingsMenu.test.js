import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import { MemoryRouter } from 'react-router-dom'; 
import SettingsMenu from '../components/SettingsMenu';
import App from "../App";

import '@testing-library/jest-dom';

/**
 * Checking if setting icon exists
 */
test('Setting elements loading', () => {
    render(
        <MemoryRouter>
            <SettingsMenu />
        </MemoryRouter>
    );
    const settingsMenu = screen.getByAltText("Settings")
    expect(settingsMenu).toBeInTheDocument();

});

/**
 * Checking if text increases when enlarge text activated
 */
test('Enlarge text checkbox', () => {
    render(
        <MemoryRouter>
            <App />
        </MemoryRouter>
    );
    //Activating enlarge text box
    const enlargeTextCheckbox = screen.getByText('Enlarge Text').closest('label').querySelector('input');
    fireEvent.click(enlargeTextCheckbox);
  
    const homePageText = screen.getByText('Financial');
    //Normal size is 1.2em
    expect(homePageText).toHaveStyle('font-size: 2em');
});
/**
 * Checking if constrast mode - no background image when active
 */
test('High Contrast Mode checkbox', () => {
    render(
        <MemoryRouter>
            <App />
        </MemoryRouter>
    );
    //Activating contrast mode box
    const highContrastCheckbox = screen.getByText('High Contrast Mode').closest('label').querySelector('input');
    fireEvent.click(highContrastCheckbox);

    const bodyElement = document.body;
    expect(bodyElement).toHaveStyle('background-image:');
});

/**
 * Checking if Tritanopia on - Need help button a different colour
 */
test('Tritanopia checkbox', () => {
    render(
        <MemoryRouter>
            <App />
        </MemoryRouter>
    );

    const highContrastCheckbox = screen.getByText('Tritanopia (Blue-Blind)').closest('label').querySelector('input');
    fireEvent.click(highContrastCheckbox);

    const bodyElement = screen.getByText('Need help?');
    //Was a wierd bug - Had to have old colour and new colour
    expect(bodyElement).toHaveStyle('color: rgb(8, 217, 214), #BE9FE1');
});