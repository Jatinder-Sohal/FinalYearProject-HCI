"""
Module containing a class for creating lists with cards and a scrollbar.
"""

import tkinter as tk
import tkinter.ttk as ttk
import customtkinter as ctk


class Lists:
    """
    Class which creates lists to store card instances inside

    Methods:
    - create_list: Main method which creates main elements of list
    - scrollbar: Method which adds a scrollbar to list
    """
    def create_list(title, placementx, colour, root):
        """
        Create a list with specified title, position, color, and window.

        Parameters:
        - title: Title of the list.
        - placementx: X coord position of the list.
        - colour: Colour of the list.
        - root: Window of the GUI.

        Returns:
        Elements of the list e.g its container, canvas and scrollbar
        """ 
        list_frame = ctk.CTkFrame(root, height=800, width=285, fg_color='white', corner_radius=10)
        list_frame.place(x=placementx, y=100)
        list_frame.pack_propagate(False)

        #Header to store the title and create a top border
        header_frame = ctk.CTkFrame(list_frame, fg_color='white')
        header_frame.pack(side='top', fill='x')
        
        #Adding a border to the top of header
        border_frame = ctk.CTkFrame(header_frame, fg_color=colour, height=5)
        border_frame.pack(side='top', fill='x')

        title_label = ctk.CTkLabel(header_frame, text=title, font=("Arial Bold", 25))
        title_label.pack(pady=(6, 20))

        #Adding a scrollbar to list by calling next method
        container, canvas, scrollbar = Lists.scrollbar(list_frame)
        #Returning first element to add cards to and last 2 for testing
        return container, canvas, scrollbar

    
    def scrollbar(list_frame):
        """
        Add a scrollbar to a list for scrolling through card content.

        Parameters:
        - list_frame: The frame representing the list.

        Returns:
        Elements of the list e.g its container, canvas and scrollbar
        """
        
        canvas = tk.Canvas(list_frame, bg='white', highlightthickness=0, width=255)  
        canvas.pack(side=tk.LEFT, fill=tk.BOTH, expand=True)

        ###Using code from the internet to create this: https://stackoverflow.com/questions/16188420/tkinter-scrollbar-for-frame
        #Creates a scroll bar on the right of list and allows the previous canvas to be scrolled
        scrollbar = ttk.Scrollbar(list_frame, orient='vertical', command=canvas.yview)
        scrollbar.pack(side=tk.RIGHT, fill='y')

        canvas.configure(yscrollcommand=scrollbar.set)
        container = ctk.CTkFrame(canvas, fg_color='white')
        window_id = canvas.create_window((0, 0), window=container, anchor='nw')

        def on_frame_configure(event):
            canvas.configure(scrollregion=canvas.bbox("all"))

        container.bind('<Configure>', on_frame_configure)
        canvas.bind('<Configure>', lambda e: canvas.configure(scrollregion=canvas.bbox('all')))
        ###
    
        return container, canvas, scrollbar
