import React, { useState } from 'react';
import '../css/Sidebar.css';
import DropdownUp from '../images/dropdown-up.png';
import DropdownDown from '../images/dropdown-down.png';
import StarFilled from '../images/star.png'
import BinBlack from '../images/bin-black.png'

/**
 * Sidebar component for displaying and managing favorite and all boards.
 *
 * @param {Object} props - Component props.
 * @param {Array} props.favoriteBoards - List of favorite board names.
 * @param {Array} props.allBoards - List of all board names.
 * @param {Function} props.setFavoriteBoards - Function to update the list of favorite boards.
 * @param {Function} props.setAllBoards - Function to update the list of all boards.
 * @param {Function} props.sidebarItemClick - Function called when a board name is clicked.
 * @param {Function} props.addNewBoard - Function to add a new board.
 * @param {string} props.boardTitle - Currently active board title.
 * @returns {JSX.Element} Rendered Sidebar component.
 */
function Sidebar({favoriteBoards, allBoards, setFavoriteBoards, setAllBoards, sidebarItemClick, addNewBoard, boardTitle}){
    /**
     * Handles the action when a board name in the sidebar is clicked.
     * Confirms with the user before loading the board.
     * 
     * @param {string} name - The name of the board to be loaded.
     */
    function handleSidebarClick(name){
        if (window.confirm(name + " will be loaded") === true) {
            sidebarItemClick(name)
        } else {}
    }

    const [isAllOpen, setIsAllOpen] = useState(true);
    const [isFavoriteOpen, setIsFavOpen] = useState(true);
    const [favImage, setFavImage] = useState(DropdownUp);
    const [allImage, setAllImage] = useState(DropdownUp);

    /**
     * Toggles the visibility of the all boards section and updates the dropdown icon.
     */
    const toggleAllSection = () => {
        setIsAllOpen(!isAllOpen);
        if (allImage === DropdownDown){
            setAllImage(DropdownUp)
        }else{
            setAllImage(DropdownDown)
        }
    };
    /**
     * Toggles the visibility of the favorite boards section and updates the dropdown icon.
     */
    const toggleFavSection = () => {
        setIsFavOpen(!isFavoriteOpen);
        if (favImage === DropdownDown){
            setFavImage(DropdownUp)
        }else{
            setFavImage(DropdownDown)
        }
    };
    /**
     * Removes a board from the favorite boards list.
     *
     * @param {Object} event - The click event to prevent propagation.
     * @param {string} clickedBoard - The name of the board to remove from favorites.
     */
    function removeFavorite(event, clickedBoard){
        event.stopPropagation();
        setFavoriteBoards(prevBoards => prevBoards.filter(board => board !== clickedBoard));
    }
    /**
     * Removes a board from the all boards list after confirmation.
     *
     * @param {Object} event - The click event to prevent propagation.
     * @param {string} clickedBoard - The name of the board to be deleted.
     */
    function removeAll(event, clickedBoard){
        event.stopPropagation();
        if (window.confirm("This will DELETE " + clickedBoard) === true) {
            if(boardTitle === clickedBoard){
                alert("Error -  You cannot delete an open board!")
            }else{
                setAllBoards(prevBoards => prevBoards.filter(board => board !== clickedBoard));
            }
        }
    }
        

    return (
        <div className="sidebar">
            <div>
                <div className="add-board" onClick={() => addNewBoard()}> 
                    <h3 style={{fontWeight:"normal"}}>Add New Board</h3>
                </div>
                <div className="fav-section">
                    <div className="fav-section-header" onClick={toggleFavSection}>
                        <img className="dropdown-images" alt="Dropdown Icon" src={favImage}/>
                        {"Favorite Boards"}
                    </div>
                    {isFavoriteOpen &&
                        <ul className='lists'>
                            {favoriteBoards.map(board => (
                                <div onClick={()=>handleSidebarClick(board)} className="section-item" key={board}>
                                    {board}
                                    <img className="sidebar-star dropdown-item-images" alt="Star icon" onClick={(event)=> removeFavorite(event, board)} src={StarFilled}/>
                                </div>
                            ))}
                        </ul>
                    }                    
                </div>   
                <div className="all-section">
                    <div className="all-section-header" onClick={toggleAllSection}>
                        <img className="dropdown-images" alt="Dropdown Icon" src={allImage}/>
                        {"All Boards"}
                    </div>
                    {isAllOpen &&
                        <ul className='lists'>
                            {allBoards.map(board => (
                                <div onClick={()=>handleSidebarClick(board)} className="section-item" key={board}>
                                    {board}
                                    <img className="checkbox-delete dropdown-item-images" alt="Delete icon"onClick={(event)=> removeAll(event, board)} src={BinBlack}/>
                                </div>
                                
                            ))}
                        </ul>
                    }                    
                </div> 
            </div>
        </div>
    );
};

export default Sidebar;