import sys
sys.path.insert(1, '../main')

import unittest
import tkinter as tk
from cards import Cards
from lists import Lists
from Main import CardContext
from new_card import New_Card
from history import Action, ActionHistory
from navbar import Navbar

#Class which tests the functionality of the navbar and its buttons
class TestNavbarFunction(unittest.TestCase):
    #Set ups the root and action history to track changes
    def setUp(self):
        self.root = tk.Tk()
        #Don't need the other return values so use *_
        self.to_do_list, *_ = Lists.create_list("To-do", 100, 'grey', self.root)
        self.to_do_cards = []
        self.action_history = ActionHistory() 
        #Attaches the context to action history
        self.context = CardContext(self.to_do_list, self.to_do_list, self.to_do_list, self.to_do_list, self.to_do_cards, self.to_do_cards, self.to_do_cards, self.to_do_cards)
        self.context.action_history = self.action_history

        self.navbar = Navbar(self.root, None, None)

    #Testing undo by adding a card, then applying undo and checking if card not in list anymore
    def testUndoAdd(self):
        new_card_data = Cards.create_card_data("Test Card", ["Task 1", "Task 2"], "red", 1)
        self.to_do_cards.append(new_card_data)
        #Recording the action so can undo it later
        self.context.action_history.record_action(Action(new_card_data, self.to_do_cards, None, action_type="add"))

        self.context.action_history.undo(self.context)
        self.assertNotIn(new_card_data, self.to_do_cards)

    #Testing redo by repeating last test, but then adding redo at the end and checking if now card inside list
    def testRedoUndo(self):
        new_card_data = Cards.create_card_data("Test Card", ["Task 1", "Task 2"], "red", 1)
        self.to_do_cards.append(new_card_data)
        self.context.action_history.record_action(Action(new_card_data, self.to_do_cards, None, action_type="add"))

        #Undo then redo
        self.context.action_history.undo(self.context)
        self.context.action_history.redo(self.context)
        self.assertIn(new_card_data, self.to_do_cards)

    #Testing if the help window is generated when button pressed
    def testHelpButton(self):
        self.navbar.show_help_window()
        self.assertTrue(self.navbar.help_window_open)

    #General tear down to remove roots after testing
    def tearDown(self):
        self.root.destroy()

if __name__ == '__main__':
    unittest.main()
