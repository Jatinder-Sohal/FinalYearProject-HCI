#Class which represents an action that can be undone and redone and has methods to perform it
class Action:
    #Constructor which initalises the action type and where to move the card to
    def __init__(self, card, from_list, to_list, action_type="movement"):
        self.card = card
        self.from_list = from_list
        self.to_list = to_list
        self.action_type = action_type

    #Method to undo actions.
    def undo(self, context):
        #Had to import cards here to stop circular dependancy
        from cards import Cards
        #Depending on action type, performs respective undo operation
        if self.action_type == "movement":           
            Cards.move_card(self.card, self.to_list, self.from_list, context, is_undo_action=True)
        elif self.action_type == "add":
            self.from_list.remove(self.card) 
            Cards.sync_ui(context)

    def redo(self, context):
        from cards import Cards
        #Depending on action type, performs respective redo operation
        if self.action_type == "movement":           
            Cards.move_card(self.card, self.from_list, self.to_list, context, is_undo_action=True)
        elif self.action_type == "add":
            self.from_list.append(self.card) 
            Cards.sync_ui(context)        

#Class which manages all the history of actions for undo and redo
class ActionHistory:
    def __init__(self):
        #Lists to store the actions
        self.undo_history = []
        self.redo_history = []

    #Method to record action in undo list
    def record_action(self, Action):
        self.undo_history.append(Action)
        self.redo_history.clear()

    #Undo's the last action in undo list
    def undo(self, context):
        #Checks if not empty and then removes last action
        if self.undo_history:
            Action = self.undo_history.pop()
            Action.undo(context)
            #Adds to redo list
            self.redo_history.append(Action)

    #Redo's the last action in redo list
    def redo(self, context):
        #Checks if not empty and then removes last action
        if self.redo_history:
            Action = self.redo_history.pop()
            Action.redo(context)
            #Adds to undo list
            self.undo_history.append(Action)
           
