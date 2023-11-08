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


def create_card(title):
    card_frame = ctk.CTkFrame(root, height=700, width=275, corner_radius=10)
    card_frame.place(x=200, y=100)
    #NOTE - stops content affecting size of frame
    card_frame.pack_propagate(False)

    border_frame = ctk.CTkFrame(card_frame, fg_color='blue', height=5)
    border_frame.pack(side="top", fill="x")

    title_label = ctk.CTkLabel(card_frame, text=title)
    title_label.pack(pady=(6, 10))
    

    return card_frame


create_navbar()
card = create_card("To do")

root.mainloop()
