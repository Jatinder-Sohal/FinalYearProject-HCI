import tkinter as tk
import tkinter.ttk as ttk
import customtkinter as ctk
from PIL import Image, ImageTk
from tktooltip import ToolTip

from navbar import Navbar

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

    
class Cards:
    def create_card_data(title, content, priority, tasks):
        return {
            'title': title,
            'content': content,
            'priority': priority,
            'tasks': tasks
        }
    def move_card(card, from_list, to_list):
        from_list.remove(card)
        to_list.append(card)
        Cards.sync_ui()
        
    def sync_ui():
        #Code from https://stackoverflow.com/questions/15781802/python-tkinter-clearing-a-frame
        for widget in To_Do.winfo_children():
            widget.destroy()
        for widget in Progress.winfo_children():
            widget.destroy()
        for widget in Finished.winfo_children():
            widget.destroy()
        for widget in On_Hold.winfo_children():
            widget.destroy()
            
        Cards.create_and_place_cards(To_Do, to_do_cards)
        Cards.create_and_place_cards(Progress, progress_cards)
        Cards.create_and_place_cards(Finished, finished_cards)
        Cards.create_and_place_cards(On_Hold, on_hold_cards)


    def create_and_place_cards(list_frame, cards):
        for card_data in cards:
            if list_frame == To_Do:
                card, move_left_button, move_right_button = Cards.create_card(list_frame, to_do_cards, card_data)
                move_left_button.pack_forget()
                move_right_button.pack(side='top', padx=10, pady=10, anchor='center')
                move_right_button.configure(command=lambda card=card_data: Cards.move_card(card, to_do_cards, progress_cards))
            elif list_frame == Progress:
                card, move_left_button, move_right_button = Cards.create_card(list_frame, progress_cards, card_data)
                move_left_button.configure(command=lambda card=card_data: Cards.move_card(card, progress_cards, to_do_cards))
                move_right_button.configure(command=lambda card=card_data: Cards.move_card(card, progress_cards, finished_cards))
            elif list_frame == Finished:
                card, move_left_button, move_right_button = Cards.create_card(list_frame, finished_cards, card_data)
                move_left_button.configure(command=lambda card=card_data: Cards.move_card(card, finished_cards, progress_cards))
                move_right_button.configure(command=lambda card=card_data: Cards.move_card(card, finished_cards, on_hold_cards))
            elif list_frame == On_Hold:
                card, move_left_button, move_right_button = Cards.create_card(list_frame, on_hold_cards, card_data)
                move_right_button.pack_forget()
                move_left_button.pack(side='top', padx=10, pady=10, anchor='center')
                move_left_button.configure(command=lambda card=card_data: Cards.move_card(card, on_hold_cards, finished_cards))


    def create_card(list_frame, cards_list, card_data):
        card_title = card_data['title']
        card_content = card_data['content']
        priority = card_data['priority']
        tasks = card_data['tasks']
      
        card = ctk.CTkFrame(list_frame, height=100, corner_radius=10)  
        card.pack(pady=5, fill='x', expand=False)  

        header_frame = ctk.CTkFrame(card)
        header_frame.pack(side='top', fill="x", expand=False, pady=2)

        priority_dot = ctk.CTkLabel(header_frame, text="•", text_color=priority, font=("Arial", 40))
        priority_dot.pack(side='left', padx=10)
        ToolTip(priority_dot, msg="Indicites importance: Red being the most, green the least")
        
        title_label = ctk.CTkLabel(header_frame, text=card_title, width=180, anchor="w", font=("Arial", 20))
        title_label.pack(side='left')          

        def delete_card():
            cards_list.remove(card_data)  
            card.destroy()
            Cards.sync_ui()
   
        bin_button = ctk.CTkButton(header_frame, text="", fg_color="orange", hover_color="orange3", image=bin_photo, width=5, command=delete_card)
        bin_button.image = bin_photo  
        bin_button.pack(side='right', padx=10)
        ToolTip(bin_button, msg="This will DELETE the card")

     
        i = 0
        while (i <= tasks):
            task = card_content[i] 
            sub_task_frame = ctk.CTkFrame(card, fg_color='gainsboro')
            sub_task_frame.pack(side='top', expand=True, pady=2)
            sub_task_label = ctk.CTkLabel(sub_task_frame, text="Task " +str(i+1)+": "+task, width=45, anchor="w", font=("Arial", 16))
            sub_task_label.pack(side='left', padx=35)

            checked_state = tk.BooleanVar(value=True)
            if (i==tasks):
                checked_state = tk.BooleanVar(value=False)  
            checkbutton =  ctk.CTkCheckBox(sub_task_frame, width=40, text="", variable=checked_state)
            checkbutton.pack(side='right', padx=15, pady=5)
            i = i + 1   

        progress_var = tk.DoubleVar(value=0)
        if (i==1):
            progress_var.set(0)
        else:
            progress_var.set(i/(i+1) * 100)
 
        progress_frame = ctk.CTkFrame(card)
        progress_frame.pack(pady=(5, 0))
        progress_bar = ttk.Progressbar(progress_frame, orient='horizontal', length=170, mode='determinate', variable=progress_var, maximum=100)
        progress_bar.pack(fill='x', padx=5)

        left_img = Image.open("../resources/left-svgrepo-com.png")
        left_photo = ctk.CTkImage(left_img)
        move_left_button = ctk.CTkButton(card, text="Move left ", image=left_photo, width=10, height=30, font=("Arial Bold", 15))
        move_left_button.pack(side='left', padx=8, pady=10, anchor='center')

        right_img = Image.open("../resources/right-3-svgrepo-com.png")
        right_photo = ctk.CTkImage(right_img)
        move_right_button = ctk.CTkButton(card, text="Move right", image=right_photo, font=("Arial Bold", 15), width=100, compound=tk.RIGHT)
        move_right_button.pack(side='right', padx=10, pady=10, anchor='center')
        
        return card, move_left_button, move_right_button

    
        


class new_card:
    def add_card(title, subtasks_list, priority, window):
        subtasks = subtasks_list.split('\n')
        new_card = Cards.create_card_data(title, subtasks, priority, len(subtasks)-2)
        to_do_cards.append(new_card)
        Cards.sync_ui()
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

        


if __name__ == "__main__":
    root = ctk.CTk()
    root.title("Project planning")
    root.geometry("1400x960+250+20")
    root.configure(fg_color="#DBE2EF")

    navbar = Navbar(root, new_card.open_add_card_window)

    bin_img = Image.open("../resources/bin-svgrepo-com.png")
    bin_photo = ctk.CTkImage(bin_img)
    
    to_do_cards = [Cards.create_card_data("Card Title 1", ["Content 1"], "red", 0), Cards.create_card_data("Card Title 2", ["Subtask 1", "Subtask 2", "Subtask 4"], "orange", 2)]
    progress_cards = [Cards.create_card_data("Card Title 3", ["Subtask 1", "Subtask 2", "Subtask 2"], "green", 2)]
    finished_cards = [Cards.create_card_data("Card Title 4", ["Subtask 1", "Subtask 2"], "orange", 1), Cards.create_card_data("Card Title 5", ["Content 1"], "red", 0)]
    on_hold_cards = [Cards.create_card_data("Card Title 6", ["Subtask 1", "Subtask 2"], "green", 1)]


    To_Do = Lists.create_list("To-do", 100, 'grey', root)
    Progress = Lists.create_list("In progress", 420, 'orange', root)
    Finished = Lists.create_list("Finished", 740, 'green', root)
    On_Hold = Lists.create_list("On Hold", 1060, 'pink', root)
    Cards.sync_ui()
    
    root.mainloop() 
