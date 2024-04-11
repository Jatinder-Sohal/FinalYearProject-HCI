import React from 'react';
import { useState } from 'react';
import '../css/List.css'; 
import CardList from './Cards';
import Cancel from '../images/cancel-svgrepo-com.png';
import Delete from '../images/bin-black.png'
import Sort from '../images/sort.png';
import Filter from '../images/filter.png';
import Copy from '../images/copy.png'

const List = ({ contentColour, title, listTitle, cardList, onAddButton, cardClick, updateTitle }) => {
    const [isEditingTitle, setIsEditingTitle] = useState(false);
    const [currentTitle, setCurrentTitle] = useState(title);
    function titleClick(){
        setIsEditingTitle(true);
    };
    function handleInput(){
        setIsEditingTitle(false);
        updateTitle(currentTitle);
    };

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
        <div>
        {isDropdownOpen && (
                <div className="dropdown">
                    <div className='dropdown-header'>
                        <h3 className='dropdown-title'>List actions</h3>
                        <img src={Cancel} className="close-dropdown" onClick={toggleDropdown}  alt="Close dropdown" />
                    </div>
                    <div style={{padding: '16px'}}>
                        <div className='dropdown-section'>
                            Duplicate List
                            <img className='dropdown-icon' src={Copy} />
                        </div>
                        <div className='dropdown-section'>
                            Filter by...
                            <img className='dropdown-icon' src={Filter} />
                        </div>
                        <div className='dropdown-section'>
                            Sort by...
                            <img className='dropdown-icon' src={Sort} />
                        </div>
                        <div className='dropdown-section'>
                            Delete List
                            <img className='dropdown-icon' src={Delete} />
                        </div>
                    </div>
                </div>
            )}
            <div className="list" style={{ backgroundColor: contentColour }}>
                <header className="list-header">
                    {isEditingTitle ? (
                    <input 
                        className="list-title-input" 
                        style={{ backgroundColor: contentColour }}
                        type="text" 
                        value={currentTitle} 
                        onChange={(e) => setCurrentTitle(e.target.value)}
                        onBlur={handleInput}
                        onKeyDown={(e) => { if (e.key === 'Enter') { handleInput() } }}
                        autoFocus 
                        />
                    ) : (
                        <h2 onClick={titleClick}>{currentTitle}</h2>
                    )}
                    <button className="list-action"  onClick={toggleDropdown}>...</button>
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
                    <button className="add-card-btn" style={{ backgroundColor: contentColour }} onClick={() => setIsAddingCard(true)}>
                        <span className="plus-icon">+</span>
                        <span className="add-card-btn-text">Add a card</span>
                    </button>
                )}
            </div>
            
        </div>
    );
};

export default List;