import React from 'react';
import { Droppable, Draggable } from 'react-beautiful-dnd';
import './List.css'; 

const Cards = ({ cards, title, cardClick }) => {
  return (
    <Droppable droppableId={`${title}`}>
      {(provided) => (
        <div {...provided.droppableProps} ref={provided.innerRef}>
          {cards.map((card, index) => (
            <Draggable key={card.id} draggableId={String(card.id)} index={index}>
              {(provided) => (
                <div ref={provided.innerRef} {...provided.draggableProps} {...provided.dragHandleProps} onClick={cardClick} className="card">
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