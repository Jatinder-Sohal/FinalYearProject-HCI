import { useState } from 'react';
import '../css/List.css'
import '../css/NewList.css'
import Cancel from '../images/cancel-svgrepo-com.png';

/**
 * Component for creating new lists on the UI, allowing the user to enter a list title and add it to the board.
 *
 * @param {Object} props - The properties passed to the component.
 * @param {Function} props.addList - Function to be called to add the new list to the board.
 * @returns {JSX.Element} The NewList component with either a button to initiate adding a list or an input form to enter the list name.
 */
function NewList({addList}){
    const [isAddingList, setIsAddingList] = useState(false);
    const [newListTitle, setNewListTitle] = useState('');

    /**
     * Handles the click event on Add List button, triggers the addList function,
     * and resets the state for new list title and input visibility.
     */
    function addClick(){
        addList(newListTitle)
        setNewListTitle('')
        setIsAddingList(false)
    }
    /**
     * Handles the cancellation of new list procress, resetting the state related to new list creation.
     */
    function cancelClick(){
        setNewListTitle('')
        setIsAddingList(false)
    }
    return(
        <div>
            {isAddingList ? (
                <div className="NewList">
                    <textarea className="new-list-input" onChange={(e) => setNewListTitle(e.target.value)} placeholder="Enter list title..."></textarea>
                    <div style={{ display: 'flex', marginTop:'2px', alignItems: 'center'}}>
                        <button className="btn btn-primary confirm-card-button" onClick={() => addClick()}>Add List</button>
                        <img src={Cancel} className="cancel-card-button" alt="Cancel card" onClick={() => cancelClick()}/>
                    </div>
                </div>
            ) : (
                <button className="NewList-add" onClick={() => setIsAddingList(true)}>
                    <span className="plus-icon">+</span>
                    <span className="add-card-btn-text">Add new list</span>
                </button>
            )}
        </div>
    );
}

export default NewList;