import React from 'react';
import './list.css'; 
import CardList from './cardList';
import { Droppable } from 'react-beautiful-dnd';

const List = ({ title, listTitle, cardList, onAddCard }) => {
    return (
        <div className="list">
            <header className="list-header">
                <h2>{title}</h2>
                <button className="list-action">...</button>
            </header>
            <CardList cards={cardList} title={listTitle}/>
            <button className="add-card-btn" onClick= {() => onAddCard("New Card Title")}>
                <span className="plus-icon">+</span>
                <span className="add-card-btn-text">Add a card</span>
            </button>
        </div>
    );
};

export default List;