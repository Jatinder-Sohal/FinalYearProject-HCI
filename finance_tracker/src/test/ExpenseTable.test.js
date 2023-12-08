import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import ExpenseTable from '../components/ExpenseTable';

/**
 * Testing if all 5 rows load in table
 */
test('Initial expenses loading', () => {
    render(<ExpenseTable deleteTitle={() => {}} />);

    const expenseRows = screen.getAllByTestId('expense-row');
    expect(expenseRows).toHaveLength(5);
});
/**
 * Testing if add row increases row amount
 */
test('Add row button', () => {
    render(<ExpenseTable deleteTitle={() => {}} />);
  
    let expenseRows = screen.getAllByTestId('expense-row');
    expect(expenseRows).toHaveLength(5);

    fireEvent.click(screen.getByTestId('add-row'));
  
    expenseRows = screen.getAllByTestId('expense-row');
    expect(expenseRows).toHaveLength(6);
});
/**
 * Testing if delete button sets table to 0 rows
 */
test('Delete button', () => {
    render(<ExpenseTable deleteTitle={() => {}} />);
  
    let expenseRows = screen.getAllByTestId('expense-row');
    expect(expenseRows).toHaveLength(5);

    fireEvent.click(screen.getByTestId('delete-table'));
  
    expect(screen.queryAllByTestId('expense-row')).toHaveLength(0);
});
/**
 * Testing if reset button reset the table
 */
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
/**
 * Testing a singular row delete and if it reduces rows by 1
 */
test('Delete single row', () => {
    render(<ExpenseTable deleteTitle={() => {}} />);
  
    fireEvent.click(screen.getAllByTestId('delete-row')[0]);
  
    let expenseRows = screen.getAllByTestId('expense-row');
    expect(expenseRows).toHaveLength(4);
});