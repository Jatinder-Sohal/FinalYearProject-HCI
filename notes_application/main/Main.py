import tkinter as tk
import tkinter.ttk as ttk
import customtkinter as ctk
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

        add_card_button = ctk.CTkButton(top_bar, text="Add card", image=add_photo, width=100, height=30, font=("Arial", 18), command=new_card.open_add_card_window)
        add_card_button.pack(side=tk.LEFT)
        ToolTip(add_card_button, msg="Click this button to add a new card")


        undo_button = ctk.CTkButton(top_bar, text="Undo", image=undo_photo, width=100, height=30, font=("Arial", 18))
        undo_button.pack(side=tk.LEFT, padx=10)
        ToolTip(undo_button, msg="Click this button to undo any changes")

        redo_button = ctk.CTkButton(top_bar, text="Redo", image=redo_photo, width=100, height=30, font=("Arial", 18))
        redo_button.pack(side=tk.LEFT)
        ToolTip(redo_button, msg="Click this button to redo any changes")

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
            card, move_left_button, move_right_button = Cards.create_card(list_frame, card_data['title'], card_data['content'], card_data['priority'], card_data['tasks'])
            #NOTE - Lambda lets me use small function in one line
            if list_frame == To_Do:
                move_left_button.pack_forget()
                move_right_button.pack(side='top', padx=10, pady=10, anchor='center')
                move_right_button.configure(command=lambda card=card_data: Cards.move_card(card, to_do_cards, progress_cards))
            elif list_frame == Progress:
                move_left_button.configure(command=lambda card=card_data: Cards.move_card(card, progress_cards, to_do_cards))
                move_right_button.configure(command=lambda card=card_data: Cards.move_card(card, progress_cards, finished_cards))
            elif list_frame == Finished:
                move_left_button.configure(command=lambda card=card_data: Cards.move_card(card, finished_cards, progress_cards))
                move_right_button.configure(command=lambda card=card_data: Cards.move_card(card, finished_cards, on_hold_cards))
            elif list_frame == On_Hold:
                move_right_button.pack_forget()
                move_left_button.pack(side='top', padx=10, pady=10, anchor='center')
                move_left_button.configure(command=lambda card=card_data: Cards.move_card(card, on_hold_cards, finished_cards))


    def create_card(list_frame, card_title, card_content, priority, tasks):
        card = ctk.CTkFrame(list_frame, width=250, height=100, corner_radius=10)  
        card.pack(pady=5, fill='x', expand=False)  

        header_frame = ctk.CTkFrame(card, width=10)
        header_frame.pack(side='top', expand=False, pady=2)

        title_label = ctk.CTkLabel(header_frame, text=card_title, width=225, anchor="w", font=("Arial", 20))
        title_label.pack(side='left', padx=5)

        priority_dot = ctk.CTkLabel(header_frame, text="•", text_color=priority, font=("Arial", 40))
        priority_dot.pack(side='right', padx=10)
        ToolTip(priority_dot, msg="Indicites importance: Red being the most, green the least")

        
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
        add_card_window.geometry("400x600+800+200")

        header = tk.Label(add_card_window, text="Add new card", font=("Arial Bold", 27), bg="lightblue", width=30, pady=20)
        header.pack()

        title_label = tk.Label(add_card_window, text="Title:", font=("Arial Bold", 22))
        title_label.pack(pady=(20,0))
        title_entry = ctk.CTkEntry(add_card_window, width=200, height=30, font=("Arial Bold", 20))
        title_entry.pack(pady=(5,10))

        
        subtasks_label = tk.Label(add_card_window, text="Subtasks (one per line):", font=("Arial Bold", 22))
        subtasks_label.pack()
        subtasks_text = tk.Text(add_card_window, height=5, width=25, font=("Arial Bold", 18), borderwidth=1, relief="solid")
        subtasks_text.pack()


        priority_label = tk.Label(add_card_window, text="Priority:", font=("Arial Bold", 22))
        priority_label.pack(pady=3)
        priority_choices = ['red', 'orange', 'green']
        priority_dropdown = ctk.CTkOptionMenu(add_card_window, values=priority_choices, width=150, fg_color="white", button_color='royal blue', font=("Arial", 18))
        priority_dropdown.configure(text_color='black')
        priority_dropdown.pack(pady=1)


        submit_button = ctk.CTkButton(add_card_window, text="Add Card", font=("Arial Bold", 22),fg_color='royal blue', command=lambda: new_card.add_card(title_entry.get(), subtasks_text.get("1.0", tk.END), priority_dropdown.get(), add_card_window))
        submit_button.pack(pady=30)




class SetUp:
    def __init__(self):
        Navbar.create_navbar(root)
        Navbar.create_top_bar(root)

        Cards.sync_ui()


if __name__ == "__main__":
    root = ctk.CTk()
    root.title("Project planning")
    root.geometry("1400x960+250+20")
    root.configure(bg_color="#F9F7F7")


    to_do_cards = [Cards.create_card_data("Card Title 1", ["Content 1"], "red", 0), Cards.create_card_data("Card Title 2", ["Subtask 1", "Subtask 2", "Subtask 4"], "orange", 2)]
    progress_cards = [Cards.create_card_data("Card Title 3", ["Subtask 1", "Subtask 2", "Subtask 2"], "green", 2)]
    finished_cards = [Cards.create_card_data("Card Title 4", ["Subtask 1", "Subtask 2"], "orange", 1), Cards.create_card_data("Card Title 5", ["Content 1"], "red", 0)]
    on_hold_cards = [Cards.create_card_data("Card Title 6", ["Subtask 1", "Subtask 2"], "green", 1)]


    To_Do = Lists.create_list("To-do", 100, 'grey', root)
    Progress = Lists.create_list("In progress", 420, 'orange', root)
    Finished = Lists.create_list("Finished", 740, 'green', root)
    On_Hold = Lists.create_list("On Hold", 1060, 'pink', root)
    SetUp()
    
    root.mainloop() 
