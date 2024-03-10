import React from 'react';
import { useState } from 'react';
import './list.css'; 
import CardList from './cardList';

const List = ({ title, listTitle, cardList, onAddButton }) => {const [isAddingCard, setIsAddingCard] = useState(false);
    const [newCardTitle, setNewCardTitle] = useState('');
  
    const handleAddCard = () => {
      if (newCardTitle) {
        onAddButton(newCardTitle, listTitle);
        setNewCardTitle('');
        setIsAddingCard(false);
      }
    };

    return (
        <div className="list">
            <header className="list-header">
                <h2>{title}</h2>
                <button className="list-action">...</button>
            </header>
            <CardList cards={cardList} title={listTitle}/>
            {isAddingCard ? (
                <>
                <input
                    className="new-card-input"
                    value={newCardTitle}
                    onChange={(e) => setNewCardTitle(e.target.value)}
                    placeholder="Enter a title for this card..."
                    autoFocus
                />
                <button onClick={handleAddCard}>Add</button>
                <button onClick={() => setIsAddingCard(false)}>Cancel</button>
                </>
            ) : (
                <button className="add-card-btn" onClick={() => setIsAddingCard(true)}>
                    <span className="plus-icon">+</span>
                    <span className="add-card-btn-text">Add a card</span>
                </button>
            )}
        </div>
    );
};

export default List;