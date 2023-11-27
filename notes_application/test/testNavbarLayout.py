import sys
sys.path.insert(1, '../main')
import unittest
import tkinter as tk
import customtkinter as ctk
from tkinter import Image, PhotoImage
from navbar import Navbar
from Main import CardContext


def fake_function():
    pass

class TestNavbar(unittest.TestCase):
    def setUp(self):
        self.root = tk.Tk()
        self.root.geometry("1400x960")
        self.navbar_object = Navbar(self.root, fake_function, context = CardContext("test", "test","test","test","test","test","test","test"))  
        self.navbar = self.navbar_object.create_navbar()  
        self.root.update_idletasks()
   
    def testNavbarExisits(self):
        self.assertIsNotNone(self.navbar)

    def testNavbarSize(self):
        self.root.update_idletasks()
        self.assertEqual(self.navbar.winfo_width(), 1400)
        self.assertEqual(self.navbar.winfo_height(), 75)

    def testNavbarPosition(self):
        self.root.update_idletasks()
        self.assertEqual(self.navbar.winfo_x(), 0)

    def testNavbarColour(self):
        self.root.update_idletasks()    
        expected_bg = '#F9F7F7'  
        navbar_bg = self.navbar.cget('bg')  
        self.assertEqual(navbar_bg, expected_bg)

    def testButtonsExist(self):
        self.root.update_idletasks()
        top_bar = self.navbar_object.top_bar  
        children = top_bar.winfo_children()  
      
        expected_buttons = ["Add card", "Undo", "Redo"] 
        #Used resources online to make this - not my code
        for button_name in expected_buttons:
            self.assertTrue(any(button.cget("text") == button_name for button in children if isinstance(button, ctk.CTkButton)), f"Button '{button_name}' not found in Navbar")
               
    def tearDown(self):
        self.root.destroy()


if __name__ == '__main__':
    unittest.main()
