import sys
sys.path.insert(1, '../main')

import unittest
import tkinter as tk
from Main import create_navbar, create_list  
class TestTkinterLayout(unittest.TestCase):
    def setUp(self):
        self.root = tk.Tk()
        self.navbar = create_navbar(self.root)
        self.root.update_idletasks()  

    def testNavbarExisits(self):
        self.assertIsNotNone(self.navbar)

    def testNavbarCharacteristics(self):
        self.root.update_idletasks()
        self.assertEqual(self.navbar.winfo_height(), 75)       
        expected_bg = 'white'  
        navbar_bg = self.navbar.cget('bg')  
        self.assertEqual(navbar_bg, expected_bg)

    def tearDown(self):
        self.root.destroy()

if __name__ == '__main__':
    unittest.main()
