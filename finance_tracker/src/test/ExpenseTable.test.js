import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import ExpenseTable from '../components/ExpenseTable';

test('Initial expenses loading', () => {
  render(<ExpenseTable deleteTitle={() => {}} />);

  const expenseRows = screen.getAllByTestId('expense-row');
  expect(expenseRows).toHaveLength(5);
});

test('Initial expenses loading', () => {
    render(<ExpenseTable deleteTitle={() => {}} />);
  
    let expenseRows = screen.getAllByTestId('expense-row');
    expect(expenseRows).toHaveLength(5);

    fireEvent.click(screen.getByTestId('add-row'));
  
    expenseRows = screen.getAllByTestId('expense-row');
    expect(expenseRows).toHaveLength(6);
  });