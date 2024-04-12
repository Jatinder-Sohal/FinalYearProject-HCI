import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import '@testing-library/jest-dom';
import Modal from '../components/Modal';

const mockCard = { id: 1, title: 'Example Card' };
const mockOnClose = jest.fn();
const mockDeleteCard = jest.fn();

beforeEach(() => {
    render(<Modal card={mockCard} onClose={mockOnClose} listTitle="Todo" deleteCard={mockDeleteCard} />);
});
test('Testing Modal renders correctly', async () => {
    expect(screen.getByText('Example Card')).toBeInTheDocument();
    expect(screen.getByText('In list: Todo')).toBeInTheDocument();
});
test('Progress bar renders correctly inside modal', () => {
    const progressBar = screen.getByRole('progressbar');
    expect(progressBar).toHaveStyle('width: 33.3%');
});
test('Testing adding and deleting items', () => {
    userEvent.click(screen.getByText('Add an item'));
    userEvent.type(screen.getByPlaceholderText('Add an item'), 'New Task');
    userEvent.click(screen.getByText('Add'));
  
    expect(screen.getByText('New Task')).toBeInTheDocument();
  
    const deleteButtons = screen.getAllByAltText('Delete checkbox row');
    userEvent.click(deleteButtons[deleteButtons.length - 1]); 
    expect(screen.queryByText('New Task')).not.toBeInTheDocument();
});
test('Progress bar dynamically updating', () => {
    const checkboxes = screen.getAllByRole('checkbox');
    userEvent.click(checkboxes[1]); 
    expect(screen.getByRole('progressbar')).toHaveStyle('width: 66.6%');
  
    userEvent.click(checkboxes[1]); 
    expect(screen.getByRole('progressbar')).toHaveStyle('width: 33.3%');
});
