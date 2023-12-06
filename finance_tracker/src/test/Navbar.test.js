import React from 'react';
import { render, screen } from '@testing-library/react';
import { MemoryRouter } from 'react-router-dom';
import Navbar from '../components/Navbar';


test('Navbar elements exist', () => {
    render(<MemoryRouter><Navbar /></MemoryRouter>);

    const homeLink = screen.getByText(/Home/i);
    expect(homeLink.classList.contains('nav-link')).toBe(true);
    expect(homeLink.classList.contains('active')).toBe(true);
      
});

