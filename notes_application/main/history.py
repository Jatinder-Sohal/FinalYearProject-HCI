
class Action:
    def __init__(self, card, from_list, to_list, action_type="movement"):
        self.card = card
        self.from_list = from_list
        self.to_list = to_list
        self.action_type = action_type

    def undo(self, context):
        from cards import Cards
        if self.action_type == "movement":           
            Cards.move_card(self.card, self.to_list, self.from_list, context, is_undo_action=True)
        elif self.action_type == "add":
            self.from_list.remove(self.card) 
            Cards.sync_ui(context)

    def redo(self, context):
        from cards import Cards
        if self.action_type == "movement":           
            Cards.move_card(self.card, self.from_list, self.to_list, context, is_undo_action=True)
        elif self.action_type == "add":
            self.from_list.append(self.card) 
            Cards.sync_ui(context)        


class ActionHistory:
    def __init__(self):
        self.undo_history = []
        self.redo_history = []

    def record_action(self, Action):
        self.undo_history.append(Action)
        self.redo_history.clear()

    def undo(self, context):
        Action = self.undo_history.pop()
        Action.undo(context)
        self.redo_history.append(Action)

    def redo(self, context):
        Action = self.redo_history.pop()
        Action.redo(context)
        self.undo_history.append(Action)
           
