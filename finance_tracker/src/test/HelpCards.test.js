import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import HelpCards from '../components/HelpCards';
import '@testing-library/jest-dom'; 

/**
 * Testing if cards are loading on the page
 */
test('Loading of cards', () => {
  render(<HelpCards />);

  const chatTitle = screen.getByText('Start a live chat');
  expect(chatTitle).toBeInTheDocument();

});
/**
 * Testing if the live chat opens by checking colour of live chat button
 */
test('Opening live chat', () => {
    render(<HelpCards />);

    const chatBox = screen.queryByTestId('chat-box');
    expect(chatBox).toBeNull();
  
    const liveChatButton = screen.getByText('Live chat');
    fireEvent.click(liveChatButton);
  
    const liveChatButtone = screen.getByText('Live chat');
    //Checking colour of button
    expect(liveChatButtone).toHaveStyle('background-color: ButtonFace');
});