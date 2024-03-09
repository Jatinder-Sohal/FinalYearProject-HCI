import React from 'react';
import { Droppable, Draggable } from 'react-beautiful-dnd';
import './list.css'; 

const CardList = ({ cards }) => {
  return (
    <Droppable droppableId="droppable">
      {(provided) => (
        <div {...provided.droppableProps} ref={provided.innerRef}>
          {cards.map((card, index) => (
            <Draggable key={card.id} draggableId={String(card.id)} index={index}>
              {(provided) => (
                <div ref={provided.innerRef} {...provided.draggableProps} {...provided.dragHandleProps} className="card">
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

export default CardList;