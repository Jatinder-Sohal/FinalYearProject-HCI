import tkinter as tk
import tkinter.ttk as ttk
import customtkinter as ctk
from PIL import Image, ImageTk
from tktooltip import ToolTip
from history import Action
from tkinter import messagebox

#Class which creates cards that will be stored inside lists
class Cards:
    #Method which creates a dictionary with representing the cards data
    def create_card_data(title, content, priority, tasks):
        return {
            'title': title,
            'content': content,
            'priority': priority,
            'tasks': tasks
        }
    
    #Moves cards from one list to another and then syncs the UI
    def move_card(card, from_list, to_list, context, is_undo_action=False):
        from_list.remove(card)
        to_list.append(card)
        Cards.sync_ui(context)

        #If not an undo action we record as an action that can be undone - This stops a never ending undo loop
        if not is_undo_action:
            context.action_history.record_action(Action(card, from_list, to_list))

    #Syncs the UI by deleting every widgit inside all lists and then recreating them    
    def sync_ui(context):
        #Destorys all widgits
        #Code from https://stackoverflow.com/questions/15781802/python-tkinter-clearing-a-frame
        for widget in context.To_Do.winfo_children():
            widget.destroy()
        for widget in context.Progress.winfo_children():
            widget.destroy()
        for widget in context.Finished.winfo_children():
            widget.destroy()
        for widget in context.On_Hold.winfo_children():
            widget.destroy()

        #Calls the method to add cards to their respective lists   
        Cards.create_and_place_cards(context.To_Do, context.to_do_cards, context)
        Cards.create_and_place_cards(context.Progress, context.progress_cards, context)
        Cards.create_and_place_cards(context.Finished, context.finished_cards, context)
        Cards.create_and_place_cards(context.On_Hold, context.on_hold_cards, context)


    #Method initialses all cards and places them inside the correct lists. Also adds functionality to move left and right buttons for those cards.
    def create_and_place_cards(list_frame, cards, context):
        #Need to check which list to place the card in
        for card_data in cards:
            #If To.do remove left button and intialise right button to move to in progress list
            if list_frame == context.To_Do:
                card, move_left_button, move_right_button = Cards.create_card(list_frame, context.to_do_cards, card_data)
                move_left_button.pack_forget()
                move_right_button.pack(side='top', padx=10, pady=10, anchor='center')
                move_right_button.configure(command=lambda card=card_data: Cards.move_card(card, context.to_do_cards, context.progress_cards, context))
            #If progress intialise left button moving to To-Do and right button to moving to done
            elif list_frame == context.Progress:
                card, move_left_button, move_right_button = Cards.create_card(list_frame, context.progress_cards, card_data)
                move_left_button.configure(command=lambda card=card_data: Cards.move_card(card, context.progress_cards, context.to_do_cards, context))
                move_right_button.configure(command=lambda card=card_data: Cards.move_card(card, context.progress_cards, context.finished_cards, context))
            elif list_frame == context.Finished:
                card, move_left_button, move_right_button = Cards.create_card(list_frame, context.finished_cards, card_data)
                move_left_button.configure(command=lambda card=card_data: Cards.move_card(card, context.finished_cards, context.progress_cards, context))
                move_right_button.configure(command=lambda card=card_data: Cards.move_card(card, context.finished_cards, context.on_hold_cards, context))
            #If on hold list, remove move right button
            elif list_frame == context.On_Hold:
                card, move_left_button, move_right_button = Cards.create_card(list_frame, context.on_hold_cards, card_data)
                move_right_button.pack_forget()
                move_left_button.pack(side='top', padx=10, pady=10, anchor='center')
                move_left_button.configure(command=lambda card=card_data: Cards.move_card(card, context.on_hold_cards, context.finished_cards, context))

    #Method which creates the singular card and initalises all its data and elements
    def create_card(list_frame, cards_list, card_data):
        #Getting the cards data from its dictionary
        card_title = card_data['title']
        card_content = card_data['content']
        priority = card_data['priority']
        tasks = card_data['tasks']
      
        card = ctk.CTkFrame(list_frame, height=100, corner_radius=10)  
        card.pack(pady=5, fill='x', expand=False)  

        #Header to store delete and the title
        header_frame = ctk.CTkFrame(card)
        header_frame.pack(side='top', fill="x", expand=False, pady=2)

        #Adding a dot to indicate important
        priority_dot = ctk.CTkLabel(header_frame, text="•", text_color=priority, font=("Arial", 40))
        priority_dot.pack(side='left', padx=10)
        ToolTip(priority_dot, msg="Indicites importance: Red being the most, green the least")

        #Title of card
        title_label = ctk.CTkLabel(header_frame, text=card_title, width=180, anchor="w", font=("Arial", 22), wraplength=180)
        title_label.pack(side='left')          

        #Delete icon with a hover effect, added to right of header. Added onclick event which calls last function
        bin_img = Image.open("../resources/bin-svgrepo-com.png")
        bin_photo = ctk.CTkImage(bin_img)
        bin_button = ctk.CTkButton(header_frame, text="", fg_color="orange", hover_color="orange3", image=bin_photo, width=5, command=lambda: Cards.delete_card(card, card_data, cards_list))
        bin_button.image = bin_photo  
        bin_button.pack(side='right', padx=10)
        ToolTip(bin_button, msg="This will DELETE the card")

        #Loop which goes over each subtasks and adds to card with a progress box 
        i = 0
        while (i <= tasks):
            task = card_content[i] 
            sub_task_frame = ctk.CTkFrame(card, fg_color='gainsboro')
            sub_task_frame.pack(side='top', expand=True, pady=2)

            #If subtask if a certain character limit, split onto 2 lines
            task_height = 0
            if (len(task) >= 11):
                task_height=2

            #Adding tasks with a label e.g task 1: or task 5: etc    
            sub_task_label = tk.Text(sub_task_frame, height=task_height, width=14, font=("Arial", 14), borderwidth=0, highlightthickness=0, wrap="word", bg='gainsboro')  
            sub_task_label.insert("end", "Task " +str(i+1)+": "+task)
            sub_task_label.pack(side='left', padx=(15, 10), pady = 5)
            sub_task_label.configure(state="disabled", inactiveselectbackground=sub_task_label.cget("selectbackground"))

            #Making the progress box ticked unless the last tasks - Fake loop for looks of the UI as need to show board in progress
            checked_state = tk.BooleanVar(value=True)
            if (i==tasks):
                checked_state = tk.BooleanVar(value=False)  
            checkbutton =  ctk.CTkCheckBox(sub_task_frame, width=40, text="", variable=checked_state)
            checkbutton.pack(side='right', padx=15, pady=1)
            i = i + 1   

        #Adding a progress bar to card
        progress_var = tk.DoubleVar(value=0)
        #If one task, will not be ticked - so should be empty. Else set using equation
        if (i==1):
            progress_var.set(0)
        else:
            i=i-1
            progress_var.set(i/(i+1) * 100)

        #Placing progress bar on bottom of card
        progress_frame = ctk.CTkFrame(card)
        progress_frame.pack(pady=(5, 0))
        progress_bar = ttk.Progressbar(progress_frame, orient='horizontal', length=170, mode='determinate', variable=progress_var, maximum=100)
        progress_bar.pack(fill='x', padx=5)

        #Adding move buttons to card
        left_img = Image.open("../resources/left-svgrepo-com.png")
        left_photo = ctk.CTkImage(left_img)
        move_left_button = ctk.CTkButton(card, text="Move left ", fg_color="#3F72AF", hover_color="grey", text_color="white", image=left_photo, width=10, height=30, font=("Arial Bold", 15))
        move_left_button.pack(side='left', padx=8, pady=10, anchor='center')

        right_img = Image.open("../resources/right-3-svgrepo-com.png")
        right_photo = ctk.CTkImage(right_img)
        move_right_button = ctk.CTkButton(card, text="Move right", fg_color="#3F72AF", hover_color="grey", text_color="white", image=right_photo, font=("Arial Bold", 15), width=100, compound=tk.RIGHT)
        move_right_button.pack(side='right', padx=10, pady=10, anchor='center')
        
        return card, move_left_button, move_right_button


    #Delete function which loads a message box and depending on result removes card
    def delete_card(card, card_data, cards_list):
        response = messagebox.askyesno("Delete Confirmation (CANNOT UNDO)", "Are you sure you want to delete this card?")
        #Destroy card and remove from list - this avoids use of sync as we destroy widgit here
        if response:
            cards_list.remove(card_data)  
            card.destroy()

    
