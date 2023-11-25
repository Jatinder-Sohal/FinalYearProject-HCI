import tkinter as tk
import tkinter.ttk as ttk
import customtkinter as ctk
from PIL import Image, ImageTk
from tktooltip import ToolTip

from navbar import Navbar
from cards import Cards

ctk.set_appearance_mode("light")




class Lists:
    def create_list(title, placementx, colour, root):
        list_frame = ctk.CTkFrame(root, height=800, width=285, fg_color='white', corner_radius=10)
        list_frame.place(x=placementx, y=100)
        list_frame.pack_propagate(False)


        header_frame = ctk.CTkFrame(list_frame, fg_color='white')
        header_frame.pack(side='top', fill='x')

        border_frame = ctk.CTkFrame(header_frame, fg_color=colour, height=5)
        border_frame.pack(side='top', fill='x')

        title_label = ctk.CTkLabel(header_frame, text=title, font=("Arial Bold", 25))
        title_label.pack(pady=(6, 20))

        return Lists.scrollbar(list_frame)


    def scrollbar(list_frame):
        canvas = tk.Canvas(list_frame, bg='white', highlightthickness=0, width=255)  # Width is less to accommodate scrollbar
        canvas.pack(side=tk.LEFT, fill=tk.BOTH, expand=True)

        ###Using code from the internet to create this: https://stackoverflow.com/questions/16188420/tkinter-scrollbar-for-frame
        scrollbar = ttk.Scrollbar(list_frame, orient='vertical', command=canvas.yview)
        scrollbar.pack(side=tk.RIGHT, fill='y')

        canvas.configure(yscrollcommand=scrollbar.set)
        container = ctk.CTkFrame(canvas, fg_color='white')
        window_id = canvas.create_window((0, 0), window=container, anchor='nw')

        def on_frame_configure(event):
            canvas.configure(scrollregion=canvas.bbox("all"))

        container.bind('<Configure>', on_frame_configure)
        canvas.bind('<Configure>', lambda e: canvas.configure(scrollregion=canvas.bbox('all')))

        return container

    

class new_card:
    def add_card(title, subtasks_list, priority, window):
        subtasks = subtasks_list.split('\n')
        new_card = Cards.create_card_data(title, subtasks, priority, len(subtasks)-2)
        to_do_cards.append(new_card)
        Cards.sync_ui(context)
        window.destroy()    
    
        
    def open_add_card_window():
        add_card_window = tk.Toplevel(root)
        add_card_window.title("New Card Window")
        add_card_window.geometry("700x600+600+200")

        header = tk.Label(add_card_window, text="Add new card", font=("Arial Bold", 27),width=30, pady=20)
        header.place(relx = 0.3, rely = 0.10, anchor = tk.CENTER)

        title_label = tk.Label(add_card_window, text="Title:", font=("Arial", 22))
        title_label.place(relx = 0.18, rely = 0.2, anchor = tk.CENTER)
        title_entry = ctk.CTkEntry(add_card_window, width=200, height=50, font=("Arial ", 20))
        title_entry.place(relx = 0.28, rely = 0.3, anchor = tk.CENTER)

        
        subtasks_label = tk.Label(add_card_window, text="Subtasks (one per line):", font=("Arial", 22))
        subtasks_label.place(relx = 0.35, rely = 0.4, anchor = tk.CENTER)
        subtasks_text = tk.Text(add_card_window, height=3, width=25, font=("Arial", 18), borderwidth=1, relief="solid")
        subtasks_text.place(relx = 0.37, rely = 0.52, anchor = tk.CENTER)


        priority_label = tk.Label(add_card_window, text="Priority:", font=("Arial", 22))
        priority_label.place(relx = 0.20, rely = 0.66, anchor = tk.CENTER)
        priority_choices = ['red', 'orange', 'green']
        priority_dropdown = ctk.CTkOptionMenu(add_card_window, values=priority_choices, width=150, fg_color="white", button_color='royal blue', font=("Arial", 18))
        priority_dropdown.configure(text_color='black')
        priority_dropdown.place(relx = 0.24, rely = 0.74, anchor = tk.CENTER)


        submit_button = ctk.CTkButton(add_card_window, text="Add Card", font=("Arial Bold", 22),fg_color='royal blue', command=lambda: new_card.add_card(title_entry.get(), subtasks_text.get("1.0", tk.END), priority_dropdown.get(), add_card_window))
        submit_button.place(relx = 0.23, rely = 0.87, anchor = tk.CENTER)

        
class CardContext:
    def __init__(self, to_do, progress, finished, on_hold, to_do_cards, progress_cards, finished_cards, on_hold_cards):
        self.To_Do = to_do
        self.Progress = progress
        self.Finished = finished
        self.On_Hold = on_hold
        self.to_do_cards = to_do_cards
        self.progress_cards = progress_cards
        self.finished_cards = finished_cards
        self.on_hold_cards = on_hold_cards

if __name__ == "__main__":
    root = ctk.CTk()
    root.title("Project planning")
    root.geometry("1400x960+250+20")
    root.configure(fg_color="#DBE2EF")

    navbar = Navbar(root, new_card.open_add_card_window)


    
    to_do_cards = [Cards.create_card_data("Card Title 1", ["Content 1"], "red", 0), Cards.create_card_data("Card Title 2", ["Subtask 1", "Subtask 2", "Subtask 4"], "orange", 2)]
    progress_cards = [Cards.create_card_data("Card Title 3", ["Subtask 1", "Subtask 2", "Subtask 2"], "green", 2)]
    finished_cards = [Cards.create_card_data("Card Title 4", ["Subtask 1", "Subtask 2"], "orange", 1), Cards.create_card_data("Card Title 5", ["Content 1"], "red", 0)]
    on_hold_cards = [Cards.create_card_data("Card Title 6", ["Subtask 1", "Subtask 2"], "green", 1)]


    To_Do = Lists.create_list("To-do", 100, 'grey', root)
    Progress = Lists.create_list("In progress", 420, 'orange', root)
    Finished = Lists.create_list("Finished", 740, 'green', root)
    On_Hold = Lists.create_list("On Hold", 1060, 'pink', root)

    context = CardContext(To_Do, Progress, Finished, On_Hold, to_do_cards, progress_cards, finished_cards, on_hold_cards)
    Cards.sync_ui(context)

    
    root.mainloop() 
