import tkinter as tk
import tkinter.ttk as ttk
import customtkinter as ctk
from tkinter import messagebox

from cards import Cards
from history import Action

class New_Card:
    def __init__(self, root, context):
        self.root = root
        self.context = context
        self.to_do_cards = context.to_do_cards
    
    def add_card(self, title, subtasks_list, priority, window):
        if not title.strip() or not subtasks_list.strip():
            messagebox.showerror("Input Error", "Please fill in all fields.")
            return 


        subtasks = subtasks_list.split('\n')
        new_card = Cards.create_card_data(title, subtasks, priority, len(subtasks)-2)
        self.to_do_cards.append(new_card)
        Cards.sync_ui(self.context)

        self.context.action_history.record_action(Action(new_card, self.to_do_cards, None, action_type="add"))
        window.destroy()    
    
        
    def open_add_card_window(self):
        add_card_window = tk.Toplevel(self.root)
        add_card_window.title("New Card Window")
        add_card_window.geometry("700x600+600+200")

        header = tk.Label(add_card_window, text="Add new card", font=("Arial Bold", 27),width=30, pady=20)
        header.place(relx = 0.3, rely = 0.10, anchor = tk.CENTER)

        title_label = tk.Label(add_card_window, text="Title:", font=("Arial", 22))
        title_label.place(relx = 0.18, rely = 0.2, anchor = tk.CENTER)
        title_entry = tk.Entry(add_card_window, width=23,  font=("Arial ", 19), borderwidth=1, relief="solid")
        title_entry.place(relx = 0.37, rely = 0.3, anchor = tk.CENTER)

        
        subtasks_label = tk.Label(add_card_window, text="Subtasks (one per line):", font=("Arial", 22))
        subtasks_label.place(relx = 0.35, rely = 0.4, anchor = tk.CENTER)
        subtasks_text = tk.Text(add_card_window, height=3, width=25, font=("Arial", 18), borderwidth=1, relief="solid")
        subtasks_text.place(relx = 0.37, rely = 0.52, anchor = tk.CENTER)


        priority_label = tk.Label(add_card_window, text="Priority:", font=("Arial", 22))
        priority_label.place(relx = 0.20, rely = 0.66, anchor = tk.CENTER)
        priority_choices = ['red', 'orange', 'green']
        priority_dropdown = ctk.CTkOptionMenu(add_card_window, values=priority_choices, width=150, fg_color="white", button_color='orange', font=("Arial", 18))
        priority_dropdown.configure(text_color='black')
        priority_dropdown.place(relx = 0.24, rely = 0.74, anchor = tk.CENTER)


        submit_button = ctk.CTkButton(add_card_window, text="Add Card", font=("Arial Bold", 22),fg_color="#3F72AF", command=lambda: self.add_card(title_entry.get(), subtasks_text.get("1.0", tk.END), priority_dropdown.get(), add_card_window))
        submit_button.place(relx = 0.23, rely = 0.87, anchor = tk.CENTER)

