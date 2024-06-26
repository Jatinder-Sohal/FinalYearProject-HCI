import '../css/Modal.css'
import { useState, useEffect } from 'react';
import Cancel from '../images/cancel-svgrepo-com.png';
import MoveLeft from '../images/left-arrow.png'
import MoveRight from '../images/right-arrow.png'
import Bin from '../images/bin-black.png'
import Share from '../images/share.png'
import Copy from '../images/copy.png'

/**
 * Modal component to display and manage details of a specific card.
 * Allows editing of card details such as description and checklist, and provides card management actions like move, copy, share, and delete.
 *
 * @param {Object} props - Props passed to the component.
 * @param {Object} props.card - The card object containing details like title and id.
 * @param {Function} props.onClose - Function to close the modal.
 * @param {string} props.listTitle - Title of the list containing the card.
 * @param {Function} props.deleteCard - Function to delete the card from its list.
 * @returns {JSX.Element} Rendered component
 */
const Modal = ({ card, onClose, listTitle, deleteCard }) => {
  const [checklistItems, setChecklistItems] = useState([
    { id: 1, label: 'Task 1', checked: true },
    { id: 2, label: 'Task 2', checked: false },
    { id: 3, label: 'Task 3', checked: false },
  ]);
  const [checkedItems, updateCheckedItem] = useState(33.3)
  /**
   * Updates the progress bar based on completed tasks in the checklist.
   */
  function updateProgressBar(){
    const totalItems = checklistItems.length;
    const completedItems = checklistItems.filter(item => item.checked).length;
    updateCheckedItem((completedItems / totalItems) * 100);
  }
  useEffect(() => {
    updateProgressBar(); 
  }, [checklistItems]);

  var id = 4;
  const [isAddItemOpen, setIsAddItemOpen] = useState(false);
  const [newItem, setNewItem] = useState('');
  
  /**
   * Toggles the visibility of the add item input box.
   */
  const toggleAdd = () => {
    setIsAddItemOpen(!isAddItemOpen);
  };
  /**
   * Handles adding a new item to the checklist.
   * Adds the item only if the input is not empty.
   */
  function handleAddItem(){
    if (newItem.trim() !== '') {
      setChecklistItems([...checklistItems, { id: id, label: newItem, checked: false }]);
      setNewItem(''); 
      setIsAddItemOpen(false);
      id++;
    }else{
      alert("Please enter a checkbox value")
    }
  };
  /**
   * Removes an item from the checklist based on its ID.
   * @param {number} id - The ID of the item to be removed.
   */
  function handleDeleteItem(id){
    setChecklistItems(checklistItems.filter(item => item.id !== id));
  }
  /**
   * Toggles the checked state of a checklist item.
   * @param {number} id - The ID of the item whose checked state will be toggled.
   */
  function handleCheckboxClick(id){
    setChecklistItems(checklistItems.map(item => {
      if (item.id === id) {
        return {...item,checked: !item.checked };
      }
      return item;
    }));
  }

  return (
    <div className="modal-backdrop">
      <div className="modal-content">
        <div style={{ display: 'flex'}}>
          <h2 className='modal-title'>{card.title}</h2>
          <img src={Cancel} className="modal-close"onClick={onClose}  alt="Close Modal" />
        </div>
        <div style={{ display: 'flex'}}>
          <div>
            <h2 className='modal-listFrom'>In list: {listTitle}</h2>
            <h3 className='title-description'>Description</h3>
            <textarea className="modal-description"  placeholder="Enter a description for this card..." ></textarea>
            
            <h3 className='title-description'>Checklist</h3>
            <div className="progress-bar-container">
              <div className="progress-bar" style={{ width: `${checkedItems}%` }}></div>
            </div>
            <div className='checkbox-container'>
              {checklistItems.map(item => (
                <div className="checkbox-row" key={item.id}>
                  <label className="checkbox-label">
                    <input type="checkbox" className='checkbox' checked={item.checked} onClick={() => handleCheckboxClick(item.id)} />
                    {item.label}
                  </label>
                  <img src={Bin} className="checkbox-delete" alt="Delete checkbox row" onClick={() => handleDeleteItem(item.id)} />
                </div>
              ))}
              {isAddItemOpen ? (
                <div>
                  <input className='checkbox-add-input' placeholder='Add an item' value={newItem} onChange={(e) => setNewItem(e.target.value)}/>
                  <div style={{ display: 'flex', marginTop:'7px', alignItems: 'center'}}>
                      <button className="checkbox-add-confirm" onClick={handleAddItem}>Add</button>
                      <img src={Cancel} className="cancel-card-button" alt="Cancel card" onClick={() => setIsAddItemOpen(false)} />
                  </div>
                </div>
              ) : (
                <button className='checkbox-add-button' onClick={toggleAdd}>Add an item</button>
              )}
            </div>
            
          </div>
          <div style={{marginLeft:"22px", marginTop:"25px"}}>
              <h4 className='modal-subtitle'>Card actions</h4>
              <button className="modal-Button" >
                  <img src={MoveLeft} className="modal-icon" alt="Move to left list" />
                  <span className="modal-Button-Text">Move Left</span>
              </button>
              <button className="modal-Button" >
                  <img src={MoveRight} className="modal-icon" alt="Move to right list" />
                  <span className="modal-Button-Text">Move Right</span>
              </button>
              <button className="modal-Button" >
                  <img src={Copy} className="modal-icon" alt="Duplicate Card" />
                  <span className="modal-Button-Text">Copy</span>
              </button>
              <button className="modal-Button" >
                  <img src={Share} className="modal-icon" alt="Share card" />
                  <span className="modal-Button-Text">Share</span>
              </button>
              <button className="modal-Button" onClick={() => deleteCard(card.id, listTitle)} >
                  <img src={Bin} className="modal-icon" alt="Delete Card" />
                  <span className="modal-Button-Text">Delete</span>
              </button>
          </div>
        </div>
      </div>
    </div>
  );
};

  export default Modal;