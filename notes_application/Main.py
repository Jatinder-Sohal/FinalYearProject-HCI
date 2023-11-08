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


def create_list(title):
    card_frame = ctk.CTkFrame(root, height=700, width=275, fg_color='white', corner_radius=10)
    card_frame.place(x=200, y=100)
    #NOTE - stops content affecting size of frame
    card_frame.pack_propagate(False)

    border_frame = ctk.CTkFrame(card_frame, fg_color='grey', height=5)
    border_frame.pack(side="top", fill="x")

    title_label = ctk.CTkLabel(card_frame, text=title,font=("Arial Bold", 25))
    title_label.pack(pady=(6, 20))
    
    return card_frame


def create_card(list_frame, card_title, card_content):
    card = ctk.CTkFrame(list_frame, width=250, height=100, corner_radius=10)  
    card.pack(padx=10, pady=10, fill='x', expand=False)  

    title = ctk.CTkLabel(card, text=card_title, font=("Arial", 20), anchor="w", width=200)
    title.pack(side='top', fill='x', padx=25, pady=(2, 5))

    content = ctk.CTkLabel(card, text=card_content, font=("Arial", 16), wraplength=230) 
    content.pack(fill='x', padx=5, pady=2)

    return card



create_navbar()
list = create_list("To-do")

create_card(list, "Card Title", "This is the content of the card. testing extra chars")
create_card(list, "Card Title", "This is the content of the card. testing extra chars")




root.mainloop()
