import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import '@testing-library/jest-dom';
import Toolbar from '../components/Toolbar';

const mockStarBoard = jest.fn();
const mockDeleteCards = jest.fn();
const mockSortLists = jest.fn();
beforeEach(() => {
    render(<Toolbar starBoard={mockStarBoard} deleteCards={mockDeleteCards} sortLists={mockSortLists} />);
});

test('Rendering toolbar element correct', async () => {
    expect(screen.getByAltText('Favourite Board')).toBeInTheDocument();
    expect(screen.getByAltText('Undo last actions')).toBeInTheDocument();
    expect(screen.getByAltText('Redo last actions')).toBeInTheDocument();
    expect(screen.getByAltText('Sort cards')).toBeInTheDocument();
    expect(screen.getByAltText('Filter cards')).toBeInTheDocument();
    expect(screen.getByAltText('Delete all cards')).toBeInTheDocument();
});
test('Delete cards method is called when button pressed', () => {
    window.confirm = jest.fn(() => true);  
    const deleteButton = screen.getByAltText('Delete all cards');
    fireEvent.click(deleteButton);
    expect(mockDeleteCards).toHaveBeenCalled();
    expect(window.confirm).toHaveBeenCalledWith('WARNING - all cards will be removed');
});
test('Sort lists method is called when button pressed', () => {
    const sortButton = screen.getByAltText('Sort cards');
    fireEvent.click(sortButton); 

    const sortOption = screen.getByText('A - Z');
    fireEvent.click(sortOption);
    expect(mockSortLists).toHaveBeenCalledWith('AZ');
});