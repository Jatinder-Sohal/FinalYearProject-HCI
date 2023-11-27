import sys
sys.path.insert(1, '../main')

import unittest
import tkinter as tk
from cards import Cards
from lists import Lists
from Main import CardContext
from new_card import New_Card
from history import Action, ActionHistory

class TestNavbarFunction(unittest.TestCase):
    def setUp(self):
        self.root = tk.Tk()
        self.to_do_list, *_ = Lists.create_list("To-do", 100, 'grey', self.root)
        self.to_do_cards = []
        self.action_history = ActionHistory() 

        self.context = CardContext(self.to_do_list, self.to_do_list, self.to_do_list, self.to_do_list, self.to_do_cards, self.to_do_cards, self.to_do_cards, self.to_do_cards)
        self.context.action_history = self.action_history

    def testUndoAdd(self):
        new_card_data = Cards.create_card_data("Test Card", ["Task 1", "Task 2"], "red", 1)
        self.to_do_cards.append(new_card_data)
        self.context.action_history.record_action(Action(new_card_data, self.to_do_cards, None, action_type="add"))

        self.context.action_history.undo(self.context)
        self.context.action_history.redo(self.context)
        self.assertIn(new_card_data, self.to_do_cards)


    def testRedoUndo(self):
        new_card_data = Cards.create_card_data("Test Card", ["Task 1", "Task 2"], "red", 1)
        self.to_do_cards.append(new_card_data)
        self.context.action_history.record_action(Action(new_card_data, self.to_do_cards, None, action_type="add"))

        self.context.action_history.redo(self.context)
        self.assertIn(new_card_data, self.to_do_cards)     

    def tearDown(self):
        self.root.destroy()

if __name__ == '__main__':
    unittest.main()
