import { useState } from 'react';
import '../css/List.css'
import '../css/NewList.css'
import Cancel from '../images/cancel-svgrepo-com.png';

function NewList({addList}){
    //refactor names and reused from last class
    const [isAddingCard, setIsAddingCard] = useState(false);
    const [newCardTitle, setNewCardTitle] = useState('');

    function addClick(){
        addList(newCardTitle)
        setNewCardTitle('')
        setIsAddingCard(false)
    }
    function cancelClick(){
        setNewCardTitle('')
        setIsAddingCard(false)
    }
    return(
        <div>
            {isAddingCard ? (
                <div className="NewList">
                    <textarea className="new-list-input" onChange={(e) => setNewCardTitle(e.target.value)} placeholder="Enter list title..."></textarea>
                    <div style={{ display: 'flex', marginTop:'2px', alignItems: 'center'}}>
                        <button className="btn btn-primary confirm-card-button" onClick={() => addClick()}>Add List</button>
                        <img src={Cancel} className="cancel-card-button" alt="Cancel card" onClick={() => cancelClick()}/>
                    </div>
                </div>
            ) : (
                <button className="NewList-add" onClick={() => setIsAddingCard(true)}>
                    <span className="plus-icon">+</span>
                    <span className="add-card-btn-text">Add new list</span>
                </button>
            )}
        </div>
    );
}

export default NewList;