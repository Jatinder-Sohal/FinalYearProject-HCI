import React from 'react';
import { render, screen } from '@testing-library/react';
import { MemoryRouter } from 'react-router-dom';
import Navbar from '../components/Navbar';


test('Default highlighting', () => {
    render(<MemoryRouter><Navbar /></MemoryRouter>);

    const homeLink = screen.getByText(/Home/i);
    expect(homeLink.classList.contains('nav-link')).toBe(true);
    expect(homeLink.classList.contains('active')).toBe(true);
      
});

test('Hightlighting on different page', () => {
    render(<MemoryRouter initialEntries={['/Enter']}><Navbar /></MemoryRouter>);
  
    const HomeLink = screen.getByText(/Home/i);
    expect(HomeLink.classList.contains('nav-link')).toBe(true);
    expect(HomeLink.classList.contains('active')).toBe(false);

    const enterLink = screen.getByText(/Enter/i);
    expect(enterLink.classList.contains('nav-link')).toBe(true);
    expect(enterLink.classList.contains('active')).toBe(true);
});

test('Testing navbar functionality', () => {
    render(<MemoryRouter initialEntries={['/Help']}><Navbar /></MemoryRouter>);
  
    const navbar = screen.getByRole('navigation');
    expect(navbar.classList.contains('navbar-help', 'custom-helps')).toBe(true);
    
});
  

