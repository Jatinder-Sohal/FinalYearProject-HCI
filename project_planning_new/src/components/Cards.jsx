import React from 'react';
import { Droppable, Draggable } from 'react-beautiful-dnd';
import './List.css'; 

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