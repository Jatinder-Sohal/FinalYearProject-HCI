import sys
sys.path.insert(1, '../main')

import unittest
import tkinter as tk
from Main import create_navbar, create_list, create_card

class TestCreateCard(unittest.TestCase):
    def setUp(self):
        self.root = tk.Tk()
        self.list_frame = create_list("Test List", 100, 'grey', self.root)  
        self.card, self.move_left_button, self.move_right_button, self.checkbox = create_card(self.list_frame, "Test Card", "Card Content", "red")

    def testCardExists(self):
        self.assertIsNotNone(self.card)

    def testCardSize(self):
        self.root.update_idletasks()
        self.assertGreater(self.card.winfo_height(), 100)
        self.assertEqual(self.card.winfo_width(), 275)
        
    def testButtonExists(self):
        self.root.update_idletasks()
        self.assertIsNotNone(self.move_left_button)
        self.assertIsNotNone(self.move_right_button)
        self.assertIsNotNone(self.checkbox)    

    def tearDown(self):
        self.root.after(500)  
        self.root.destroy()



if __name__ == '__main__':
    unittest.main()
