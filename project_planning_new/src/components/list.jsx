import React from 'react';
import { useState } from 'react';
import './List.css'; 
import CardList from './Cards';
import Cancel from '../images/cancel-svgrepo-com.png';

const List = ({ title, listTitle, cardList, onAddButton, cardClick }) => {
    const [isAddingCard, setIsAddingCard] = useState(false);
    const [newCardTitle, setNewCardTitle] = useState('');
  
    const handleAddCard = () => {
      if (newCardTitle) {
        onAddButton(newCardTitle, listTitle);
        setNewCardTitle('');
        setIsAddingCard(false);
      }
    };

    const [isDropdownOpen, setIsDropdownOpen] = useState(false);

    const toggleDropdown = () => {
        setIsDropdownOpen(!isDropdownOpen);
    };
    return (
        <div className="list">
            <header className="list-header">
                <h2>{title}</h2>
                <button className="list-action" onClick={toggleDropdown}>...</button>
                {isDropdownOpen && (
                    <div className="dropdown">
                        <div className='dropdown-header'>
                            <h3 className='dropdown-title'>List actions</h3>
                            <img src={Cancel} className="close-dropdown" onClick={toggleDropdown}  alt="Close dropdown" />
                        </div>
                        <ul>
                            <li>Duplicate List</li>
                            <li>Filter by...</li>
                            <li>Sort by...</li>
                            <li>Delete List</li>
                        </ul>
                    </div>
                )}
            </header>
            
            <CardList cards={cardList} title={title} listTitle={listTitle} cardClick={cardClick}/>
            {isAddingCard ? (
                <>
                <textarea className="new-card-input" onChange={(e) => setNewCardTitle(e.target.value)} placeholder="Enter a title for this card..."></textarea>
                <div style={{ display: 'flex', marginTop:'2px', alignItems: 'center'}}>
                    <button className="btn btn-primary confirm-card-button" onClick={handleAddCard}>Add Card</button>
                    <img src={Cancel} className="cancel-card-button" onClick={() => setIsAddingCard(false)}  alt="Cancel card" />
                </div>
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