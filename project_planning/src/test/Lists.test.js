import React from 'react';
import { render, screen } from '@testing-library/react';
import '@testing-library/jest-dom';
import App from '../App';

test('Testing if Lists have been rendered', async () => {
  render(<App />);

  const listOne = await screen.findByRole('list', { name: 'To Do' });
  expect(listOne).toBeInTheDocument();

  const listTwo = await screen.findByRole('list', { name: 'In Progress' });
  expect(listTwo).toBeInTheDocument();
});
test('Testing list contents', async () => {
    render(<App />);
    
    const listItemOne = await screen.findByText('Add tasks to git');
    expect(listItemOne).toBeInTheDocument();
  
    const listItemTwo = await screen.findByText('Create teams meeting');
    expect(listItemTwo).toBeInTheDocument();
});
test('Reordering of list items via drag-and-drop', async () => {
    render(<App />);

    const item = await screen.findByText('Task 1');
    const dropzone = screen.getByText('Task 2');
  
    fireEvent.dragStart(item);
    fireEvent.drop(dropzone);
  

    const list = await screen.findByRole('list', { name: 'To Do' });
    expect(list.children[0].textContent).toBe('Task 1');
});