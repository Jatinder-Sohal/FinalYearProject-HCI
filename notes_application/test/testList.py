import sys
import unittest
import tkinter as tk
sys.path.insert(1, '../main')  
from lists import Lists

class TestLists(unittest.TestCase):
    def setUp(self):
        self.root = tk.Tk()
        self.root.geometry("1000x800")
        self.list_frame = Lists.create_list("Test List", 100, 'grey', self.root)

    def testListMade(self):
        self.root.update()
        self.assertIsNotNone(self.list_frame)
        self.assertGreater(self.list_frame.winfo_height(), 100)
        self.assertGreater(self.list_frame.winfo_width(), 100)

    def tearDown(self):
        self.root.destroy()

if __name__ == '__main__':
    unittest.main()
