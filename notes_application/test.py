import tkinter as tk
import tkinter.ttk as ttk
from tkinter import *


root = tk.Tk()
root.title("Project planning")
root.geometry("1200x800+300+100")




navbar = tk.Frame(root, height=75, bg='#DBE2EF') 
navbar.pack(side=tk.TOP, fill=tk.X)

label = Label(root, text = "Project board", bg='#DBE2EF', font=("Arial", 20))


label.place(relx = 0.5, rely = 0.06, anchor = CENTER)


