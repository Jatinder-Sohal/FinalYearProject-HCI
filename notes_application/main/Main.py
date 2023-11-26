import tkinter as tk
import tkinter.ttk as ttk
import customtkinter as ctk
from PIL import Image, ImageTk
from tktooltip import ToolTip

from navbar import Navbar
from cards import Cards
from lists import Lists
from new_card import New_Card
from history import ActionHistory

ctk.set_appearance_mode("light")
           
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

 
    to_do_cards = [Cards.create_card_data("Get new picture", ["Image of paper"], "orange", 0), Cards.create_card_data("Fix errors", ["Images not loading", "Text small", "Colour not right"], "red", 2)]
    progress_cards = [Cards.create_card_data("Add to navbar", ["Dropdown", "Home", "Data page"], "green", 2)]
    finished_cards = [Cards.create_card_data("Set up", ["Choose language", "Research"], "orange", 1), Cards.create_card_data("Go to meeting", ["26/11/23"], "red", 0)]
    on_hold_cards = [Cards.create_card_data("Allow multiple editors", ["Database", "Web server"], "green", 1)]
    To_Do, *_ = Lists.create_list("To-do", 100, 'grey', root)
    Progress, *_ = Lists.create_list("In progress", 420, 'orange', root)
    Finished, *_ = Lists.create_list("Finished", 740, 'green', root)
    On_Hold, *_ = Lists.create_list("On Hold", 1060, 'pink', root)

    context = CardContext(To_Do, Progress, Finished, On_Hold, to_do_cards, progress_cards, finished_cards, on_hold_cards)
    context.action_history = ActionHistory()
    Cards.sync_ui(context)

    card_add = New_Card(root, context)
    navbar = Navbar(root, card_add.open_add_card_window, context)
  
    root.mainloop() 
