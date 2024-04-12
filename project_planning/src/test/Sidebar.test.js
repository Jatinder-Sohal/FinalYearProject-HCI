import React from 'react';
import { render, screen } from '@testing-library/react';
import '@testing-library/jest-dom';
import Sidebar from '../components/Sidebar';

const favoriteBoards = ['Board 1', 'Board 2'];
const allBoards = ['Board 1', 'Board 2', 'Board 3'];
const mockAddNewBoard = jest.fn();
const mockSidebarItemClick = jest.fn();
test('Sidebar renders correctly', async () => {
    render(<Sidebar favoriteBoards={favoriteBoards} allBoards={allBoards} addNewBoard={mockAddNewBoard} sidebarItemClick={mockSidebarItemClick} />);

    expect(screen.getByText('Favorite Boards')).toBeInTheDocument();
    expect(screen.getByText('All Boards')).toBeInTheDocument();
    expect(screen.getAllByText('Board 1').length).toBeGreaterThan(0); 
    expect(screen.getByText('Board 2')).toBeInTheDocument();
    expect(screen.getByText('Board 3')).toBeInTheDocument();
});
test('Dropdowns work in hiding and showing elements', async () => {
    render(<Sidebar favoriteBoards={favoriteBoards} allBoards={allBoards} addNewBoard={mockAddNewBoard} sidebarItemClick={mockSidebarItemClick} />);

    const favSectionHeader = screen.getByText('Favorite Boards');
    const allSectionHeader = screen.getByText('All Boards');

    expect(screen.getByText('Board 1')).toBeVisible();

    userEvent.click(favSectionHeader);
    userEvent.click(allSectionHeader);
    expect(screen.queryByText('Board 1')).not.toBeVisible(); 

    userEvent.click(favSectionHeader);
    userEvent.click(allSectionHeader);
    expect(screen.getByText('Board 1')).toBeVisible();
});
test('Adding new board', () => {
    render(<Sidebar favoriteBoards={favoriteBoards} allBoards={allBoards} addNewBoard={mockAddNewBoard} sidebarItemClick={mockSidebarItemClick} />);
  
    const addButton = screen.getByText('Add New Board');
    userEvent.click(addButton);
    expect(mockAddNewBoard).toHaveBeenCalled();
});