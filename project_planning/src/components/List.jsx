import React from 'react';
import { useState } from 'react';
import '../css/List.css'; 
import CardList from './Cards';
import Cancel from '../images/cancel-svgrepo-com.png';
import Delete from '../images/bin-black.png'
import Sort from '../images/sort.png';
import Filter from '../images/filter.png';
import Copy from '../images/copy.png'

/**
 * A component representing a single list in a Kanban-style board.
 * Allows for interactions such as adding new cards, editing the title, and accessing a dropdown menu with additional actions.
 *
 * @param {Object} props - Component props.
 * @param {string} props.contentColour - Background color for the list header and add card button.
 * @param {string} props.title - Current title of the list.
 * @param {string} props.listTitle - The unique identifier for the list, used as a droppableId for draggable elements.
 * @param {Array} props.cardList - Array of card objects to be rendered in this list.
 * @param {Function} props.onAddButton - Function to call when adding a new card to the list.
 * @param {Function} props.cardClick - Function to handle clicks on individual cards.
 * @param {Function} props.updateTitle - Function to update the list title.
 * @returns {JSX.Element} - Rendered list component for the Kanban board.
 */
const List = ({ contentColour, title, listTitle, cardList, onAddButton, cardClick, updateTitle }) => {
    const [isEditingTitle, setIsEditingTitle] = useState(false);
    const [currentTitle, setCurrentTitle] = useState(title);
    /**
     * Enables editing mode for the list title.
     */
    function titleClick(){
        setIsEditingTitle(true);
    };
    /**
     * Disables editing mode and updates the list title to the current input when input finished.
     */
    function handleInput(){
        setIsEditingTitle(false);
        updateTitle(currentTitle);
    };

    /**
     * Hook to control the visibility of the card addition input.
     */
    const [isAddingCard, setIsAddingCard] = useState(false);
    /**
     * Hook to store and update the title of a new card being added.
     */
    const [newCardTitle, setNewCardTitle] = useState('');
  
    /**
     * Handles adding a new card to the list after confirm new input is pressed.
     */
    const handleAddCard = () => {
      if (newCardTitle) {
        onAddButton(newCardTitle, listTitle);
        setNewCardTitle('');
        setIsAddingCard(false);
      }
    };

    const [isDropdownOpen, setIsDropdownOpen] = useState(false);

    /**
     * Toggles the visibility of the dropdown menu for additional list actions.
     */
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
                            <img className='dropdown-icon' alt="Copying icon" src={Copy} />
                        </div>
                        <div className='dropdown-section'>
                            Filter by...
                            <img className='dropdown-icon' alt="Filter icon" src={Filter} />
                        </div>
                        <div className='dropdown-section'>
                            Sort by...
                            <img className='dropdown-icon' alt="Sort icon" src={Sort} />
                        </div>
                        <div className='dropdown-section'>
                            Delete List
                            <img className='dropdown-icon' alt="Delete icon" src={Delete} />
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