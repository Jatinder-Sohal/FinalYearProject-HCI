import React from 'react';
import { Droppable, Draggable } from 'react-beautiful-dnd';
import '../css/List.css'; 

/**
 * List of draggable cards.
 * @param {Object} props - The properties passed to the component.
 * @param {Array} props.cards - Array of card objects to be displayed.
 * @param {string} props.title - The title of the list containing the cards.
 * @param {string} props.listTitle - The unique ID for the list.
 * @param {Function} props.cardClick - Handler for when a card is clicked.
 * @returns {JSX.Element} A Droppable container with Draggable items.
 */
const Cards = ({ cards, title, listTitle, cardClick }) => {
  return (
    <Droppable droppableId={`${listTitle}`}>
      {(provided) => (
        <div {...provided.droppableProps} ref={provided.innerRef}>
          {cards.map((card, index) => (
            <Draggable key={card.id} draggableId={String(card.id)} index={index}>
              {(provided) => (
                <div ref={provided.innerRef} {...provided.draggableProps} {...provided.dragHandleProps} onClick={() => cardClick(card, title)} className="card">
                  {card.title}
                </div>
              )}
            </Draggable>
          ))}
          {provided.placeholder}
        </div>
      )}
    </Droppable>
  );
};

export default Cards;