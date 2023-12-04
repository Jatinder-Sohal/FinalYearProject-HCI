import sys
import unittest
import tkinter as tk
import customtkinter as ctk
sys.path.insert(1, '../main')  
from lists import Lists

class TestLists(unittest.TestCase):
    #Setting up the root window and creating a list 
    def setUp(self):
        self.root = tk.Tk()
        self.root.geometry("1000x800")
        self.list_frame, self.canvas, self.scrollbar = Lists.create_list("Test List", 100, 'grey', self.root)
        self.root.update

    #Testing if list exsits
    def testCanvasExists(self):
        self.assertIsNotNone(self.canvas, "No canvas found")

    #Testing list dimensions
    def testListMade(self):
        self.root.update()
        self.assertIsNotNone(self.list_frame)
        self.assertGreater(self.list_frame.winfo_height(), 100)
        self.assertGreater(self.list_frame.winfo_width(), 100)

    #Test if scrollbar is created
    def testScrollbarExists(self):
        self.assertIsNotNone(self.scrollbar, "Scrollbar does not exist")

    #Testing properperties of list e.g its colour and thickness = 0
    def testCanvasProperties(self):
        self.assertEqual(self.canvas['bg'], 'white', "Canvas background colour is not white")
        self.assertEqual(self.canvas['highlightthickness'], "0", "Hightlight thickness is not zero")

    #Testing if canvas packed
    def testCanvasPacking(self):
        self.assertEqual(self.canvas.pack_info()['side'], 'left', "left side of canvas not packed")
        self.assertEqual(self.canvas.pack_info()['fill'], 'both', "both sides of canvas not packed")

    #Normal teardown after waitng 500. This fixed some bugs where elements were not be created in time    
    def tearDown(self):
        self.root.after(500)
        self.root.destroy()

if __name__ == '__main__':
    unittest.main()
