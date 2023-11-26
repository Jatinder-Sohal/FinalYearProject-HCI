import sys
sys.path.insert(1, '../main')

import unittest
import tkinter as tk
import customtkinter as ctk
from cards import Cards
from lists import Lists
from Main import CardContext
from new_card import New_Card
from history import ActionHistory

class TestNewCardButton(unittest.TestCase):
    def setUp(self):
        self.root = tk.Tk()
        to_do_cards = [Cards.create_card_data("Card Title 1", ["Content 1"], "red", 0), Cards.create_card_data("Card Title 2", ["Subtask 1", "Subtask 2", "Subtask 4"], "orange", 2)]
        To_Do, *_  = Lists.create_list("To-do", 100, 'grey', self.root)
  
        action_history = ActionHistory()
        self.context = CardContext(To_Do, To_Do, To_Do, To_Do, to_do_cards, to_do_cards, to_do_cards, to_do_cards)
        self.context.action_history = ActionHistory()
        self.new_card = New_Card(self.root, self.context)
        
    def testOpenWindow(self):
        self.new_card.open_add_card_window()

    def testInvalidInput(self):
        window = tk.Toplevel(self.root)
        self.new_card.add_card("", "", "Priority", window)
        window.destroy()

    def testCorrectInput(self):
        mock_window = tk.Toplevel(self.root)
        self.new_card.add_card("Valid Title", """Valid
                               ssdsdsd""", "red", mock_window)
        mock_window.destroy()

    def tearDown(self):
        self.root.destroy()



if __name__ == '__main__':
    unittest.main()
