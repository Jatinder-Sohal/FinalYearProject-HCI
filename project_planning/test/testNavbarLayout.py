import sys
sys.path.insert(1, '../main')
import unittest
import tkinter as tk
import customtkinter as ctk
from tkinter import Image, PhotoImage
from navbar import Navbar
from Main import CardContext



#Class which tests the layout of the navbar and it's elements
class TestNavbar(unittest.TestCase):
    #Sets up the window and navbar using its respective classes
    def setUp(self):
        self.root = tk.Tk()
        #Setting up dimensions to test navbars placement inside it
        self.root.geometry("1400x960")
        self.navbar_object = Navbar(self.root, None, context = CardContext("test", "test","test","test","test","test","test","test"))  
        self.navbar = self.navbar_object.create_navbar()  
        self.root.update_idletasks()

    #Checks navbar is not null
    def testNavbarExisits(self):
        self.assertIsNotNone(self.navbar)

    #Checks the navbar's dimensions y and x
    def testNavbarSize(self):
        self.root.update_idletasks()
        self.assertEqual(self.navbar.winfo_width(), 1400)
        self.assertEqual(self.navbar.winfo_height(), 75)

    #Checks wheres the navbar is placed inside window
    def testNavbarPosition(self):
        #Runs any idle events - fixed some bugs I had
        self.root.update_idletasks()
        self.assertEqual(self.navbar.winfo_x(), 0)

    #Tests if the colour of navbar is expected colour
    def testNavbarColour(self):
        self.root.update_idletasks()    
        expected_bg = '#F9F7F7'  
        navbar_bg = self.navbar.cget('bg')  
        self.assertEqual(navbar_bg, expected_bg)

    #Tests if the buttons exsits, this test contains some code that is not mine
    def testButtonsExist(self):
        self.root.update_idletasks()
        top_bar = self.navbar_object.top_bar  
        children = top_bar.winfo_children()  
      
        expected_buttons = ["Add card", "Undo", "Redo"] 
        #Used resources online to make this - not my code
        for button_name in expected_buttons:
            self.assertTrue(any(button.cget("text") == button_name for button in children if isinstance(button, ctk.CTkButton)), f"Button '{button_name}' not found in Navbar")

    #Standard tear down to remove windows after tests           
    def tearDown(self):
        self.root.destroy()


if __name__ == '__main__':
    unittest.main()
