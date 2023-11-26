
class Action:
    def __init__(self, card, from_list, to_list, action_type="movement"):
        self.card = card
        self.from_list = from_list
        self.to_list = to_list
        self.action_type = action_type

    def undo(self, context):
        from cards import Cards
        if self.action_type == "movement":           
            Cards.move_card(self.card, self.to_list, self.from_list, context)
        elif self.action_type == "add":
            self.from_list.remove(self.card) 
            Cards.sync_ui(context)


class ActionHistory:
    def __init__(self):
        self.undo_history = []

    def record_action(self, Action):
        self.undo_history.append(Action)

    def undo(self, context):
        Action = self.undo_history.pop()
        Action.undo(context)


           
