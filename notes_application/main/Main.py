import tkinter as tk
import tkinter.ttk as ttk
import customtkinter as ctk
import random
from PIL import Image, ImageTk
from tktooltip import ToolTip

ctk.set_appearance_mode("light")



class Navbar:
    def create_navbar(root):
        navbar = tk.Frame(root, height=75, bg='white') 
        navbar.pack(side=tk.TOP, fill=tk.X)

        label = tk.Label(root, text = "Project board", bg='white', font=("Arial", 22))
        label.place(relx = 0.5, rely = 0.05, anchor = tk.CENTER)

        button = ctk.CTkButton(root, text="Share", fg_color="black",text_color="white", font=("Arial", 18), hover_color="grey", width=80, height=30)                    
        button.place(relx=0.71, rely=0.05, anchor=tk.CENTER)
        ToolTip(button, msg="Click to share board with others")

        options = ["PNG", "JPG", "Image"]
        dropdown = ctk.CTkOptionMenu(root, values=options, width=100, fg_color="black", button_color='black',font=("Arial", 18))
        dropdown.pack(pady=20)
        dropdown.set("Export")
        dropdown.place(relx=0.781, rely=0.05, anchor=tk.CENTER)
        ToolTip(dropdown, msg="Click to export board as an image")


        search_entry = ctk.CTkEntry(root, width=235, placeholder_text="search", font=("Arial", 18))
        search_entry.place(relx=0.91, rely=0.05, anchor=tk.CENTER)
        ToolTip(search_entry, msg="Search for a setting here")
        
        search_image = Image.open("../resources/magnifier-left-svgrepo-com.png")
        search_image = search_image.resize((19, 19), Image.ANTIALIAS)
        root.search_image = ImageTk.PhotoImage(search_image)

        
        search_image_label = tk.Label(root, image=root.search_image)
        search_image_label.image = root.search_image
        search_image_label.place(relx = 0.98, rely=0.05, anchor = tk.CENTER)
        ToolTip(search_image_label, msg="Click to search")

        return navbar

    def create_top_bar(root):
        top_bar = tk.Frame(root, bg='white') 
        top_bar.place(relx = 0.13, rely = 0.05, anchor = tk.CENTER)
        
        add_img = Image.open("../resources/add-circle-svgrepo-com.png")
        add_photo = ctk.CTkImage(add_img)
        
        undo_img = Image.open("../resources/undo-svgrepo-com.png")
        undo_photo = ctk.CTkImage(undo_img)

        redo_img = Image.open("../resources/redo-svgrepo-com.png")
        redo_photo = ctk.CTkImage(redo_img)

        undo_button = ctk.CTkButton(top_bar, text="Add card", image=add_photo, width=100, height=30, font=("Arial", 18))
        undo_button.pack(side=tk.LEFT)
        ToolTip(undo_button, msg="Click this button to undo any changes")


        undo_button = ctk.CTkButton(top_bar, text="Undo", image=undo_photo, width=100, height=30, font=("Arial", 18))
        undo_button.pack(side=tk.LEFT, padx=10)
        ToolTip(undo_button, msg="Click this button to undo any changes")

        redo_button = ctk.CTkButton(top_bar, text="Redo", image=redo_photo, width=100, height=30, font=("Arial", 18))
        redo_button.pack(side=tk.LEFT)
        ToolTip(redo_button, msg="Click this button to redo any changes")

class Lists:
    def create_list(title, placementx, colour, root):
        list_frame = ctk.CTkFrame(root, height=800, width=275, fg_color='white', corner_radius=10)
        list_frame.place(x=placementx, y=100)
        #NOTE - stops content affecting size of frame
        list_frame.pack_propagate(False)

        border_frame = ctk.CTkFrame(list_frame, fg_color=colour, height=5)
        border_frame.pack(side="top", fill="x")

        title_label = ctk.CTkLabel(list_frame, text=title,font=("Arial Bold", 25))
        title_label.pack(pady=(6, 20))

        container = ctk.CTkFrame(list_frame, fg_color='white')
        container.pack(fill="both", expand=True)
        list_frame.container = container
        
        return list_frame

class Cards:
    def create_card_data(title, content, priority):
        return {
            'title': title,
            'content': content,
            'priority': priority
        }

    def create_and_place_cards(list_frame, cards):
        for card_data in cards:
            Cards.create_card(list_frame, card_data['title'], card_data['content'], card_data['priority'])


    def create_card(list_frame, card_title, card_content, priority):
        card = ctk.CTkFrame(list_frame.container, width=250, height=100, corner_radius=10)  
        card.pack(pady=5, fill='x', expand=False)  

        header_frame = ctk.CTkFrame(card, width=10)
        header_frame.pack(side='top', expand=False, pady=2)

        title_label = ctk.CTkLabel(header_frame, text=card_title, width=225, anchor="w", font=("Arial", 20))
        title_label.pack(side='left', padx=5)

        priority_dot = ctk.CTkLabel(header_frame, text="•", text_color=priority, font=("Arial", 40))
        priority_dot.pack(side='right', padx=10)
        ToolTip(priority_dot, msg="Indicites importance: Red being the most, green the least")

        

        checked_state = tk.BooleanVar(value=True)
        i = 0
        while (i < random.randint(0, 2)):
            sub_task_frame = ctk.CTkFrame(card, fg_color='gainsboro')
            sub_task_frame.pack(side='top', expand=True, pady=2)
            sub_task_label = ctk.CTkLabel(sub_task_frame, text="task " +str(i) + ": start task", width=45, anchor="w", font=("Arial", 16))
            sub_task_label.pack(side='left', padx=35)
            
            checkbutton =  ctk.CTkCheckBox(sub_task_frame, width=40, text="", variable=checked_state)
            checkbutton.pack(side='right', padx=15, pady=5)
            i = i + 1

        #Unchecked box   
        sub_task_frame = ctk.CTkFrame(card, fg_color='gainsboro')
        sub_task_frame.pack(side='top', expand=True, pady=2)
        sub_task_label = ctk.CTkLabel(sub_task_frame, text="task " +str(i) + ": do task", width=45, anchor="w", font=("Arial", 16))
        sub_task_label.pack(side='left', padx=42)
        checkbox = ctk.CTkCheckBox(sub_task_frame,  width=40, text="")
        checkbox.pack(side='right', padx=21)

        progress_var = tk.DoubleVar(value=0)
        
        progress_var.set(i/(i+1) * 100) 
        progress_frame = ctk.CTkFrame(card)
        progress_frame.pack(pady=(5, 0))
        progress_bar = ttk.Progressbar(progress_frame, orient='horizontal', length=170, mode='determinate', variable=progress_var, maximum=100)
        progress_bar.pack(fill='x', padx=5)

        move_left_button = ctk.CTkButton(card, text="<- Move left", font=("Arial Bold", 15), width=50 )
        move_left_button.pack(side='left', padx=10, pady=10)
        ToolTip(move_left_button, msg="Click to move card to the left list")

        move_right_button = ctk.CTkButton(card, text="Move right ->", font=("Arial Bold", 15), width=50)
        move_right_button.pack(side='right', padx=5, pady=10)  
        ToolTip(move_right_button, msg="Click to move card to the right list")
        
        return card, move_left_button, move_right_button, checkbox

class SetUp:
    def init():
        to_do_cards = [
            Cards.create_card_data("Card Title 1", "Content 1", "red"),
            Cards.create_card_data("Card Title 2", "Content 2", "orange"),
        ]

        progress_cards = [
            Cards.create_card_data("Card Title 3", "Content 3", "green"),
        ]

        finished_cards = [
            Cards.create_card_data("Card Title 4", "Content 4", "orange"),
            Cards.create_card_data("Card Title 5", "Content 5", "red"),
        ]

        on_hold_cards = [
            Cards.create_card_data("Card Title 6", "Content 6", "green"),
        ]

        Navbar.create_navbar(root)
        Navbar.create_top_bar(root)

        To_Do = Lists.create_list("To-do", 100, 'grey', root)
        Progress = Lists.create_list("In progress", 420, 'orange', root)
        Finished = Lists.create_list("Finished", 740, 'green', root)
        On_Hold = Lists.create_list("On Hold", 1060, 'pink', root)

        Cards.create_and_place_cards(To_Do, to_do_cards)
        Cards.create_and_place_cards(Progress, progress_cards)
        Cards.create_and_place_cards(Finished, finished_cards)
        Cards.create_and_place_cards(On_Hold, on_hold_cards)

if __name__ == "__main__":
    root = ctk.CTk()
    root.title("Project planning")
    root.geometry("1400x960+250+20")
    root.configure(bg_color="#F9F7F7")
    SetUp.init()
    root.mainloop()
