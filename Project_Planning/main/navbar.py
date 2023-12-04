import tkinter as tk
import tkinter.ttk as ttk
import customtkinter as ctk
from PIL import Image, ImageTk
from tktooltip import ToolTip

#Class which creates the navbar and the elements inside it
class Navbar:
    #Initialses the root and other elements and calls the methods
    def __init__(self, root, open_add_card_window, context):
        self.root = root
        self.open_add_card_window = open_add_card_window
        self.context = context
        #The 2 methods of the class
        self.create_navbar()
        self.top_bar = self.create_top_bar()
        #Created for testing
        self.help_window_open = False 

    #Creates the actual white bar, the title and the buttons on right    
    def create_navbar(self):
        navbar = tk.Frame(self.root, height=75, bg='#F9F7F7') 
        navbar.pack(side=tk.TOP, fill=tk.X)

        label = tk.Label(self.root, text = "Project board", bg='#F9F7F7', font=("Arial", 22))
        label.place(relx = 0.5, rely = 0.05, anchor = tk.CENTER)


        #Help button with question mark image attached on the right. Calls last method when pressed
        help_img = Image.open("../resources/help-alt-svgrepo-com.png")
        help_photo = ctk.CTkImage(help_img)
        help_button = ctk.CTkButton(self.root, text="Help", hover_color="grey", image=help_photo, compound=tk.RIGHT, width=50, height=30, font=("Arial", 18), text_color="white",  fg_color="#3F72AF", command=self.show_help_window) 
        help_button.place(relx=0.71, rely=0.05, anchor=tk.CENTER)
        ToolTip(help_button, msg="Click this button to get information")


        #Export dropdown, sets export as original value.
        options = ["PNG", "JPG", "Image"]
        dropdown = ctk.CTkOptionMenu(self.root, values=options, width=100, height=30, text_color="white", fg_color="#3F72AF", button_color='#3F72AF',font=("Arial", 18))
        dropdown.pack(pady=20)
        dropdown.set("Export")
        dropdown.place(relx=0.781, rely=0.05, anchor=tk.CENTER)
        ToolTip(dropdown, msg="Click to export board as an image")

        #Search bar placed in top right
        search_entry = ctk.CTkEntry(self.root, width=235, placeholder_text="search", font=("Arial", 18))
        search_entry.place(relx=0.91, rely=0.05, anchor=tk.CENTER)
        ToolTip(search_entry, msg="Search for a setting here")

        #Attaching the search icon to the search bar
        search_image = Image.open("../resources/magnifier-left-svgrepo-com.png")
        search_image = search_image.resize((19, 19), Image.ANTIALIAS)
        #Resizing image and placing on right
        self.root.search_image = ImageTk.PhotoImage(search_image)
        search_image_label = tk.Label(self.root, image=self.root.search_image, bg="white")
        search_image_label.image = self.root.search_image
        search_image_label.place(relx = 0.98, rely=0.05, anchor = tk.CENTER)
        ToolTip(search_image_label, msg="Click to search")

        return navbar

    #Creates the elements on the left of the navbar
    def create_top_bar(self):
        top_bar = tk.Frame(self.root, bg='white') 
        top_bar.place(relx = 0.13, rely = 0.05, anchor = tk.CENTER)
        
        #Add card button with icon attached
        add_img = Image.open("../resources/add-circle-svgrepo-com.png")
        add_photo = ctk.CTkImage(add_img)
        add_card_button = ctk.CTkButton(top_bar, text="Add card", hover_color="grey", image=add_photo, width=100, height=30, font=("Arial", 18), text_color="white", command=self.open_add_card_window, fg_color="#3F72AF")
        add_card_button.pack(side=tk.LEFT)
        ToolTip(add_card_button, msg="Click this button to add a new card")

        #Undo button with icon attached
        undo_img = Image.open("../resources/undo-svgrepo-com.png")
        undo_photo = ctk.CTkImage(undo_img)
        undo_button = ctk.CTkButton(top_bar, text="Undo", image=undo_photo, hover_color="grey", text_color="white", width=100, height=30, font=("Arial", 18), fg_color="#3F72AF", command=lambda: self.context.action_history.undo(self.context))
        undo_button.pack(side=tk.LEFT, padx=10)
        ToolTip(undo_button, msg="Click this button to undo any changes")

        #Redo button with icon attached
        redo_img = Image.open("../resources/redo-svgrepo-com.png")
        redo_photo = ctk.CTkImage(redo_img)
        redo_button = ctk.CTkButton(top_bar, text="Redo", image=redo_photo, hover_color="grey", text_color="white", width=100, height=30, font=("Arial", 18), fg_color="#3F72AF", command=lambda: self.context.action_history.redo(self.context))
        redo_button.pack(side=tk.LEFT)
        ToolTip(redo_button, msg="Click this button to redo any changes")

        return top_bar


    #Method which displays help window when button pressed
    def show_help_window(self):
            self.help_window_open = True
            #Creates a top level window - above the root window
            help_window = tk.Toplevel(self.root)
            help_window.title("Help and Support")
            help_window.geometry("600x500+630+140") 


            contact_info_label = tk.Label(help_window, text="Contact Information", font=("Arial Bold", 22))
            contact_info_label.pack(pady=10)

            contact_details = """
            Email: ProjectPlanningHelp@gmail.com
            
            Phone: +449848436078
            
            Twitter: @ProjectPlanningUK
            
            Facebook: @ProjectPlanningUK
            """
            #Displays the text above in the text attribute
            contact_text = tk.Text(help_window, height=10, bg="gainsboro", width=150, font=("Arial Bold", 22))
            contact_text.insert("end", contact_details)
            contact_text.config(state="disabled")  
            contact_text.place(relx=1.88, rely=0.5, anchor="center")
        