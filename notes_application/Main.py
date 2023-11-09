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


def create_card(list_frame, card_title, card_content):
    card = ctk.CTkFrame(list_frame.container, width=250, height=100, corner_radius=10)  
    card.pack(padx=10, pady=10, fill='x', expand=False)  

    title = ctk.CTkLabel(card, text=card_title, font=("Arial", 20), anchor="w", width=200)
    title.pack(side='top', fill='x', padx=25, pady=(2, 5))

    content = ctk.CTkLabel(card, text=card_content, font=("Arial", 16), wraplength=230) 
    content.pack(fill='x', padx=5, pady=2)

    return card



create_navbar()
To_Do = create_list("To-do", 100, 'grey')
Progress = create_list("In progress", 420, 'orange')
Finished = create_list("Finished", 740, 'green')
Unable = create_list("Unable", 1060, 'red')

create_card(To_Do, "Card Title", "This is the content of the card. testing extra chars")
create_card(To_Do, "Card Title", "This is the content of the card. testing extra chars")




root.mainloop()
