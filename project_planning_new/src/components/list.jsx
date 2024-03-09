import React from 'react';
import './list.css'; 
import CardList from './cardList';

const List = ({ title, cardList }) => {
    return (
        <div className="list">
            <header className="list-header">
                <h2>{title}</h2>
                <button className="list-action">...</button>
            </header>
            <CardList cards={cardList} />
            <button className="add-card-btn">
                <span className="plus-icon">+</span>
                <span className="add-card-btn-text">Add a card</span>
            </button>
        </div>
    );
};

export default List;