import React from 'react';
import './list.css'; 

const List = ({ title }) => {
    return (
        <div className="list">
            <header className="list-header">
                <h2>{title}</h2>
                <button className="list-action">...</button>
            </header>
            <button className="add-card-btn">
                <span className="plus-icon">+</span>
                <span className="add-card-btn-text">Add a card</span>
            </button>
        </div>
    );
};

export default List;