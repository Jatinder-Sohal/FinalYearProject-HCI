import customtkinter as ctk
import tkinter as tk
import tkinter.ttk as ttk

ctk.set_appearance_mode("light")

root = ctk.CTk()
root.title("Project planning")
root.geometry("1200x800+300+100")
root.configure(bg_color="#F9F7F7")



navbar = tk.Frame(root, height=75, bg='white') 
navbar.pack(side=tk.TOP, fill=tk.X)

label = tk.Label(root, text = "Project board", bg='white', font=("Arial", 20))
label.place(relx = 0.5, rely = 0.06, anchor = tk.CENTER)

button = ctk.CTkButton(root, text="Share", fg_color="black",text_color="white", font=("Arial", 20), hover_color="grey", width=80, height=30)                    
button.place(relx=0.845, rely=0.06, anchor=tk.CENTER)


options = ["PNG", "JPG", "Image"]
dropdown = ctk.CTkOptionMenu(root, values=options, width=100, fg_color="black", button_color='black',font=("Arial", 20))
dropdown.pack(pady=20)
dropdown.set("Export")
dropdown.place(relx=0.93, rely=0.06, anchor=tk.CENTER)

root.mainloop()
