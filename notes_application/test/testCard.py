import sys
sys.path.insert(1, '../main')

import unittest
import tkinter as tk
import customtkinter as ctk
from cards import Cards
from lists import Lists
from Main import CardContext

class TestCreateCard(unittest.TestCase):
    def setUp(self):
        self.root = tk.Tk()
        
        to_do_cards = [Cards.create_card_data("Card Title 1", ["Content 1"], "red", 0), Cards.create_card_data("Card Title 2", ["Subtask 1", "Subtask 2", "Subtask 4"], "orange", 2)]
        progress_cards = [Cards.create_card_data("Card Title 3", ["Subtask 1", "Subtask 2", "Subtask 2"], "green", 2)]
        finished_cards = [Cards.create_card_data("Card Title 4", ["Subtask 1", "Subtask 2"], "orange", 1), Cards.create_card_data("Card Title 5", ["Content 1"], "red", 0)]
        on_hold_cards = [Cards.create_card_data("Card Title 6", ["Subtask 1", "Subtask 2"], "green", 1)]

        To_Do = Lists.create_list("To-do", 100, 'grey', self.root)
        Progress = Lists.create_list("In progress", 420, 'orange', self.root)
        Finished = Lists.create_list("Finished", 740, 'green', self.root)
        On_Hold = Lists.create_list("On Hold", 1060, 'pink', self.root)
        
        self.context = CardContext(To_Do, Progress, Finished, On_Hold, to_do_cards, progress_cards, finished_cards, on_hold_cards)          
        self.list_frame = Lists.create_list("Test List", 100, 'grey', self.root)
        self.card, self.move_left_button, self.move_right_button = Cards.create_card(self.list_frame, self.context.to_do_cards, {'title': 'Test Card', 'content': 'Card Content', 'priority': 'red', 'tasks': 0})

    def testCardExists(self):
        self.assertIsNotNone(self.card)

    def testCardSize(self):
        self.root.update_idletasks()
        self.assertGreater(self.card.winfo_height(), 100)
        self.assertEqual(self.card.winfo_width(), 272)
        
    def testButtonExists(self):
        self.root.update_idletasks()
        self.assertIsNotNone(self.move_left_button)
        self.assertIsNotNone(self.move_right_button)


    def tearDown(self):
        self.root.after(500)  
        self.root.destroy()



if __name__ == '__main__':
    unittest.main()
