import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import ExpenseTable from '../components/ExpenseTable';

test('Initial expenses loading', () => {
    render(<ExpenseTable deleteTitle={() => {}} />);

    const expenseRows = screen.getAllByTestId('expense-row');
    expect(expenseRows).toHaveLength(5);
});
test('Add row button', () => {
    render(<ExpenseTable deleteTitle={() => {}} />);
  
    let expenseRows = screen.getAllByTestId('expense-row');
    expect(expenseRows).toHaveLength(5);

    fireEvent.click(screen.getByTestId('add-row'));
  
    expenseRows = screen.getAllByTestId('expense-row');
    expect(expenseRows).toHaveLength(6);
});
test('Delete button', () => {
    render(<ExpenseTable deleteTitle={() => {}} />);
  
    let expenseRows = screen.getAllByTestId('expense-row');
    expect(expenseRows).toHaveLength(5);

    fireEvent.click(screen.getByTestId('delete-table'));
  
    expect(screen.queryAllByTestId('expense-row')).toHaveLength(0);
});
test('Reset button', () => {
    render(<ExpenseTable deleteTitle={() => {}} />);
    fireEvent.click(screen.getByTestId('add-row'));
    fireEvent.click(screen.getByTestId('add-row'));
    let expenseRows = screen.getAllByTestId('expense-row');
    expect(expenseRows).toHaveLength(7);

    fireEvent.click(screen.getByTestId('reset-table'));
    expenseRows = screen.getAllByTestId('expense-row');
    expect(expenseRows).toHaveLength(5);
});
test('Delete single row', () => {
    render(<ExpenseTable deleteTitle={() => {}} />);
  
    fireEvent.click(screen.getAllByTestId('delete-row')[0]);
  
    let expenseRows = screen.getAllByTestId('expense-row');
    expect(expenseRows).toHaveLength(4);
});