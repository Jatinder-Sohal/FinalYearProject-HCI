import React from 'react';
import { useState } from 'react';
import './list.css'; 

const List = ({ title }) => {
    const [todoCards, setCards] = useState([
      { id: 1, title: 'Sample Card' }, 
      { id: 2, title: 'Testing a longer card and text to see if overflow works' }, 
    ]);
    
    
    return (
        <div className="list">
            <header className="list-header">
                <h2>{title}</h2>
                <button className="list-action">...</button>
            </header>
        
            {todoCards.map(card => (
                <div key={card.id} className="card">
                    {card.title}
                </div>
            ))}
            <button className="add-card-btn">
                <span className="plus-icon">+</span>
                <span className="add-card-btn-text">Add a card</span>
            </button>
        </div>
    );
};

export default List;