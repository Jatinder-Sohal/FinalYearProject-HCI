import tkinter as tk
import tkinter.ttk as ttk
import customtkinter as ctk
from PIL import Image, ImageTk
from tktooltip import ToolTip
from history import Action
from tkinter import messagebox

class Cards:
    def create_card_data(title, content, priority, tasks):
        return {
            'title': title,
            'content': content,
            'priority': priority,
            'tasks': tasks
        }
    def move_card(card, from_list, to_list, context, is_undo_action=False):
        from_list.remove(card)
        to_list.append(card)
        Cards.sync_ui(context)
        
        if not is_undo_action:
            context.action_history.record_action(Action(card, from_list, to_list))
        
    def sync_ui(context):
        #Code from https://stackoverflow.com/questions/15781802/python-tkinter-clearing-a-frame
        for widget in context.To_Do.winfo_children():
            widget.destroy()
        for widget in context.Progress.winfo_children():
            widget.destroy()
        for widget in context.Finished.winfo_children():
            widget.destroy()
        for widget in context.On_Hold.winfo_children():
            widget.destroy()
            
        Cards.create_and_place_cards(context.To_Do, context.to_do_cards, context)
        Cards.create_and_place_cards(context.Progress, context.progress_cards, context)
        Cards.create_and_place_cards(context.Finished, context.finished_cards, context)
        Cards.create_and_place_cards(context.On_Hold, context.on_hold_cards, context)


    def create_and_place_cards(list_frame, cards, context):
        for card_data in cards:
            if list_frame == context.To_Do:
                card, move_left_button, move_right_button = Cards.create_card(list_frame, context.to_do_cards, card_data)
                move_left_button.pack_forget()
                move_right_button.pack(side='top', padx=10, pady=10, anchor='center')
                move_right_button.configure(command=lambda card=card_data: Cards.move_card(card, context.to_do_cards, context.progress_cards, context))
            elif list_frame == context.Progress:
                card, move_left_button, move_right_button = Cards.create_card(list_frame, context.progress_cards, card_data)
                move_left_button.configure(command=lambda card=card_data: Cards.move_card(card, context.progress_cards, context.to_do_cards, context))
                move_right_button.configure(command=lambda card=card_data: Cards.move_card(card, context.progress_cards, context.finished_cards, context))
            elif list_frame == context.Finished:
                card, move_left_button, move_right_button = Cards.create_card(list_frame, context.finished_cards, card_data)
                move_left_button.configure(command=lambda card=card_data: Cards.move_card(card, context.finished_cards, context.progress_cards, context))
                move_right_button.configure(command=lambda card=card_data: Cards.move_card(card, context.finished_cards, context.on_hold_cards, context))
            elif list_frame == context.On_Hold:
                card, move_left_button, move_right_button = Cards.create_card(list_frame, context.on_hold_cards, card_data)
                move_right_button.pack_forget()
                move_left_button.pack(side='top', padx=10, pady=10, anchor='center')
                move_left_button.configure(command=lambda card=card_data: Cards.move_card(card, context.on_hold_cards, context.finished_cards, context))


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
        
        title_label = ctk.CTkLabel(header_frame, text=card_title, width=180, anchor="w", font=("Arial", 22), wraplength=180)
        title_label.pack(side='left')          

        bin_img = Image.open("../resources/bin-svgrepo-com.png")
        bin_photo = ctk.CTkImage(bin_img)
        bin_button = ctk.CTkButton(header_frame, text="", fg_color="orange", hover_color="orange3", image=bin_photo, width=5, command=lambda: Cards.delete_card(card, card_data, cards_list))
        bin_button.image = bin_photo  
        bin_button.pack(side='right', padx=10)
        ToolTip(bin_button, msg="This will DELETE the card")
     
        i = 0
        while (i <= tasks):
            task = card_content[i] 
            sub_task_frame = ctk.CTkFrame(card, fg_color='gainsboro')
            sub_task_frame.pack(side='top', expand=True, pady=2)
            
            task_height = 0
            if (len(task) >= 11):
                task_height=2
                
            sub_task_label = tk.Text(sub_task_frame, height=task_height, width=14, font=("Arial", 14), borderwidth=0, highlightthickness=0, wrap="word", bg='gainsboro')  
            sub_task_label.insert("end", "Task " +str(i+1)+": "+task)
            sub_task_label.pack(side='left', padx=(15, 10), pady = 5) 
            sub_task_label.configure(state="disabled", inactiveselectbackground=sub_task_label.cget("selectbackground"))

            checked_state = tk.BooleanVar(value=True)
            if (i==tasks):
                checked_state = tk.BooleanVar(value=False)  
            checkbutton =  ctk.CTkCheckBox(sub_task_frame, width=40, text="", variable=checked_state)
            checkbutton.pack(side='right', padx=15, pady=1)
            i = i + 1   


        progress_var = tk.DoubleVar(value=0)
        if (i==1):
            progress_var.set(0)
        else:
            i=i-1
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


    def delete_card(card, card_data, cards_list):
        response = messagebox.askyesno("Delete Confirmation (CANNOT UNDO)", "Are you sure you want to delete this card?")
        if response:
            cards_list.remove(card_data)  
            card.destroy()

    
