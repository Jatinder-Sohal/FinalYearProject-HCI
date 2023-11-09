import customtkinter as ctk
import tkinter as tk
import tkinter.ttk as ttk

ctk.set_appearance_mode("light")

root = ctk.CTk()
root.title("Project planning")
root.geometry("1400x900+300+50")
root.configure(bg_color="#F9F7F7")


def create_navbar():
    navbar = tk.Frame(root, height=75, bg='white') 
    navbar.pack(side=tk.TOP, fill=tk.X)

    label = tk.Label(root, text = "Project board", bg='white', font=("Arial", 20))
    label.place(relx = 0.5, rely = 0.05, anchor = tk.CENTER)

    button = ctk.CTkButton(root, text="Share", fg_color="black",text_color="white", font=("Arial", 20), hover_color="grey", width=80, height=30)                    
    button.place(relx=0.859, rely=0.05, anchor=tk.CENTER)


    options = ["PNG", "JPG", "Image"]
    dropdown = ctk.CTkOptionMenu(root, values=options, width=100, fg_color="black", button_color='black',font=("Arial", 20))
    dropdown.pack(pady=20)
    dropdown.set("Export")
    dropdown.place(relx=0.93, rely=0.05, anchor=tk.CENTER)


def create_list(title, placementx, colour):
    list_frame = ctk.CTkFrame(root, height=700, width=275, fg_color='white', corner_radius=10)
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


def create_card(list_frame, card_title, card_content, priority):
    card = ctk.CTkFrame(list_frame.container, width=250, height=100, corner_radius=10)  
    card.pack(pady=5, fill='x', expand=False)  

    header_frame = ctk.CTkFrame(card, width=10)
    header_frame.pack(fill='x', expand=False, pady=2)

    title_label = ctk.CTkLabel(header_frame, text=card_title, anchor="w", font=("Arial", 20))
    title_label.pack(side='left', padx=5)

    priority_dot = ctk.CTkLabel(header_frame, text="•", text_color=priority, font=("Arial", 40))
    priority_dot.pack(side='right', padx=10)


    content = ctk.CTkLabel(card, text=card_content, font=("Arial", 16), wraplength=230) 
    content.pack(fill='x', padx=5, pady=2)

    move_left_button = ctk.CTkButton(card, text="<- Move left", font=("Arial Bold", 15), width=50 )
    move_left_button.pack(side='left', padx=10, pady=10)

    move_right_button = ctk.CTkButton(card, text="Move right ->", font=("Arial Bold", 15), width=50)
    move_right_button.pack(side='right', padx=5, pady=10)

    

    return card



create_navbar()
To_Do = create_list("To-do", 100, 'grey')
Progress = create_list("In progress", 420, 'orange')
Finished = create_list("Finished", 740, 'green')
On_Hold = create_list("On Hold", 1060, 'red')

create_card(To_Do, "Card Title", "This is the content of the card. testing extra chars", "red")
create_card(To_Do, "Card Title", "This is the content of the card. testing extra chars", "orange")
create_card(Progress, "Card Title", "This is the content of the card. testing extra chars", "green")
create_card(Finished, "Card Title", "This is the content of the card. testing extra chars", "orange")
create_card(Finished, "Card Title", "This is the content of the card. testing extra chars", "red")
create_card(On_Hold, "Card Title", "This is the content of the card. testing extra chars", "green")


root.mainloop()
