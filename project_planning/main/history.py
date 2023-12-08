"""
Module containing classes for managing actions and history in the application.
"""

class Action:
    """
    Class which represents an action that can be undone and redone and has methods to perform it.

    Attributes:
    - card: The card involved in the action.
    - from_list: The list from which the card is moved.
    - to_list: The list to which the card is moved.
    - action_type: The type of action, e.g., "movement" or "add".
    """

    def __init__(self, card, from_list, to_list, action_type="movement"):
        """
        Constructor which initializes the action type and where to move the card to.

        Parameters:
        - card: The card involved in the action.
        - from_list: The list from which the card is moved.
        - to_list: The list to which the card is moved.
        - action_type: The type of action, e.g., "movement" or "add".
        """
        self.card = card
        self.from_list = from_list
        self.to_list = to_list
        self.action_type = action_type

    def undo(self, context):
        """
        Method to undo actions.

        Parameters:
        - context: The context needed for performing undo operations.
        """
        # Had to import cards here to stop circular dependency
        from cards import Cards

        # Depending on action type, performs respective undo operation
        if self.action_type == "movement":
            Cards.move_card(self.card, self.to_list, self.from_list, context, is_undo_action=True)
        elif self.action_type == "add":
            self.from_list.remove(self.card)
            Cards.sync_ui(context)

    def redo(self, context):
        """
        Method to redo actions.

        Parameters:
        - context: The context needed for performing redo operations.
        """
        from cards import Cards

        # Depending on action type, performs respective redo operation
        if self.action_type == "movement":
            Cards.move_card(self.card, self.from_list, self.to_list, context, is_undo_action=True)
        elif self.action_type == "add":
            self.from_list.append(self.card)
            Cards.sync_ui(context)


class ActionHistory:
    """
    Class which manages all the history of actions for undo and redo.

    Attributes:
    - undo_history: List to store the actions for undo.
    - redo_history: List to store the actions for redo.
    """

    def __init__(self):
        """
        Constructor to initialize the ActionHistory class.
        """
        self.undo_history = []
        self.redo_history = []

    def record_action(self, Action):
        """
        Method to record action in undo list.

        Parameters:
        - action: The Action instance to be recorded.
        """
        self.undo_history.append(Action)
        self.redo_history.clear()

    def undo(self, context):
        """
        Undo the last action in the undo list.

        Parameters:
        - context: The context needed for performing undo operations.
        """
        # Checks if not empty and then removes last action
        if self.undo_history:
            Action = self.undo_history.pop()
            Action.undo(context)
            # Adds to redo list
            self.redo_history.append(Action)

    def redo(self, context):
        """
        Redo the last action in the redo list.

        Parameters:
        - context: The context needed for performing redo operations.
        """
        # Checks if not empty and then removes last action
        if self.redo_history:
            Action = self.redo_history.pop()
            Action.redo(context)
            # Adds to undo list
            self.undo_history.append(Action)
