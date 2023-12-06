import React from 'react';
import { render, screen } from '@testing-library/react';
import { MemoryRouter } from 'react-router-dom';
import Navbar from '../components/Navbar';


test('Home navbar highlighted', () => {
    render(<MemoryRouter><Navbar /></MemoryRouter>);

    const homeLink = screen.getByText(/Home/i);
    expect(homeLink.classList.contains('nav-link')).toBe(true);
    expect(homeLink.classList.contains('active')).toBe(true);
      
});
test('Home navbar not highlighted', () => {
    render(<MemoryRouter initialEntries={['/Help']}><Navbar /></MemoryRouter>);
  
    const navbar = screen.getByRole('navigation');
    expect(navbar.classList.contains('navbar', 'navbar-expand-lg', 'navbar-custom')).toBe(true);
  
    const nonHomeLink = screen.getByText(/Home/i);
    expect(nonHomeLink.classList.contains('nav-link')).toBe(true);
    expect(nonHomeLink.classList.contains('active')).toBe(false);
});
  
