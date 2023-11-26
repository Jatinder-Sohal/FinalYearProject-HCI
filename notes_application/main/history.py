
class Action:
    def __init__(self, card, from_list, to_list):
        self.card = card
        self.from_list = from_list
        self.to_list = to_list

    def undo(self, context):
        from cards import Cards
        Cards.move_card(self.card, self.to_list, self.from_list, context)


class ActionHistory:
    def __init__(self):
        self.undo_history = []

    def record_action(self, Action):
        self.undo_history.append(Action)

    def undo(self, context):
        Action = self.undo_history.pop()
        Action.undo(context)


           
