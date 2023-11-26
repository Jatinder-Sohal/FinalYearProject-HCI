import tkinter as tk
import tkinter.ttk as ttk
import customtkinter as ctk
from PIL import Image, ImageTk
from tktooltip import ToolTip


class Navbar:
    def __init__(self, root, open_add_card_window, context):
        self.root = root
        self.open_add_card_window = open_add_card_window
        self.create_navbar()
        self.top_bar = self.create_top_bar()
        self.context = context

        
    def create_navbar(self):
        navbar = tk.Frame(self.root, height=75, bg='#F9F7F7') 
        navbar.pack(side=tk.TOP, fill=tk.X)

        label = tk.Label(self.root, text = "Project board", bg='#F9F7F7', font=("Arial", 22))
        label.place(relx = 0.5, rely = 0.05, anchor = tk.CENTER)

        button = ctk.CTkButton(self.root, text="Share", fg_color="#3F72AF",text_color="white", font=("Arial", 18), hover_color="grey", width=80, height=30)                    
        button.place(relx=0.71, rely=0.05, anchor=tk.CENTER)
        ToolTip(button, msg="Click to share board with others")

        options = ["PNG", "JPG", "Image"]
        dropdown = ctk.CTkOptionMenu(self.root, values=options, width=100, text_color="white", fg_color="#3F72AF", button_color='#112D4E',font=("Arial", 18))
        dropdown.pack(pady=20)
        dropdown.set("Export")
        dropdown.place(relx=0.781, rely=0.05, anchor=tk.CENTER)
        ToolTip(dropdown, msg="Click to export board as an image")


        search_entry = ctk.CTkEntry(self.root, width=235, placeholder_text="search", font=("Arial", 18))
        search_entry.place(relx=0.91, rely=0.05, anchor=tk.CENTER)
        ToolTip(search_entry, msg="Search for a setting here")
        
        search_image = Image.open("../resources/magnifier-left-svgrepo-com.png")
        search_image = search_image.resize((19, 19), Image.ANTIALIAS)
        self.root.search_image = ImageTk.PhotoImage(search_image)

        
        search_image_label = tk.Label(self.root, image=self.root.search_image, bg="white")
        search_image_label.image = self.root.search_image
        search_image_label.place(relx = 0.98, rely=0.05, anchor = tk.CENTER)
        ToolTip(search_image_label, msg="Click to search")

        return navbar

    def create_top_bar(self):
        top_bar = tk.Frame(self.root, bg='white') 
        top_bar.place(relx = 0.13, rely = 0.05, anchor = tk.CENTER)
        
        add_img = Image.open("../resources/add-circle-svgrepo-com.png")
        add_photo = ctk.CTkImage(add_img)
        
        undo_img = Image.open("../resources/undo-svgrepo-com.png")
        undo_photo = ctk.CTkImage(undo_img)

        redo_img = Image.open("../resources/redo-svgrepo-com.png")
        redo_photo = ctk.CTkImage(redo_img)

        add_card_button = ctk.CTkButton(top_bar, text="Add card", hover_color="grey", image=add_photo, width=100, height=30, font=("Arial", 18), text_color="white", command=self.open_add_card_window, fg_color="#3F72AF")
        add_card_button.pack(side=tk.LEFT)
        ToolTip(add_card_button, msg="Click this button to add a new card")


        undo_button = ctk.CTkButton(top_bar, text="Undo", image=undo_photo, hover_color="grey", text_color="white", width=100, height=30, font=("Arial", 18), fg_color="#3F72AF", command=lambda: self.context.action_history.undo(self.context))
        undo_button.pack(side=tk.LEFT, padx=10)
        ToolTip(undo_button, msg="Click this button to undo any changes")

        redo_button = ctk.CTkButton(top_bar, text="Redo", image=redo_photo, hover_color="grey", text_color="white", width=100, height=30, font=("Arial", 18), fg_color="#3F72AF", command=lambda: self.context.action_history.redo(self.context))
        redo_button.pack(side=tk.LEFT)
        ToolTip(redo_button, msg="Click this button to redo any changes")

        return top_bar
