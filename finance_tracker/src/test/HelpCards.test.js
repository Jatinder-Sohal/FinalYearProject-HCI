import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import HelpCards from '../components/HelpCards';
import '@testing-library/jest-dom'; 

test('Loading of cards', () => {
  render(<HelpCards />);

  const chatTitle = screen.getByText('Start a live chat');
  expect(chatTitle).toBeInTheDocument();

});
test('Opening live chat', () => {
    render(<HelpCards />);

    const chatBox = screen.queryByTestId('chat-box');
    expect(chatBox).toBeNull();
  
    const liveChatButton = screen.getByText('Live chat');
    fireEvent.click(liveChatButton);
  
    const liveChatButtone = screen.getByText('Live chat');
    expect(liveChatButtone).toHaveStyle('background-color: ButtonFace');
});