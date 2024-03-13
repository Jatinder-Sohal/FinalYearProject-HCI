import { useState } from 'react';
import './List.css'

function NewList(){
    const [isAddingCard, setIsAddingCard] = useState(false);

    return(
        <div className="NewList">
            <div>
            {isAddingCard ? (
                    <div />
            ) : (
                <button className="add-card-btn" onClick={() => setIsAddingCard(true)}>
                    <span className="plus-icon">+</span>
                    <span className="add-card-btn-text">Add a card</span>
                </button>
            )}
            </div>
        </div>
    );
}

export default NewList;