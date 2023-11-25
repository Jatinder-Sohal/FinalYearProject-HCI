import sys
import unittest
import tkinter as tk
import customtkinter as ctk
sys.path.insert(1, '../main')  
from lists import Lists

class TestLists(unittest.TestCase):
    def setUp(self):
        self.root = tk.Tk()
        self.root.geometry("1000x800")
        self.list_frame, self.canvas, self.scrollbar = Lists.create_list("Test List", 100, 'grey', self.root)
        self.root.update

    def testListMade(self):
        self.root.update()
        self.assertIsNotNone(self.list_frame)
        self.assertGreater(self.list_frame.winfo_height(), 100)
        self.assertGreater(self.list_frame.winfo_width(), 100)

    def testCanvasExists(self):
        self.assertIsNotNone(self.canvas, "No canvas found")

    def testScrollbarExists(self):
        self.assertIsNotNone(self.scrollbar, "Scrollbar does not exist")

    def testCanvasProperties(self):
        self.assertEqual(self.canvas['bg'], 'white', "Canvas background colour is not white")
        self.assertEqual(self.canvas['highlightthickness'], "0", "Hightlight thickness is not zero")
    
    def testCanvasPacking(self):
        self.assertEqual(self.canvas.pack_info()['side'], 'left', "left side of canvas not packed")
        self.assertEqual(self.canvas.pack_info()['fill'], 'both', "both sides of canvas not packed")
        
    def tearDown(self):
        self.root.after(500)
        self.root.destroy()

if __name__ == '__main__':
    unittest.main()
