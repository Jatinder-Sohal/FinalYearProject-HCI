import React, { useState } from 'react';
import '../css/Sidebar.css';
import DropdownUp from '../images/dropdown-up.png';
import DropdownDown from '../images/dropdown-down.png';
import StarFilled from '../images/star.png'
import Star from '../images/filled-star.png'
import StarBorder from '../images/star-border.png'
import BinBlack from '../images/bin-black.png'

function Sidebar({favoriteBoards, allBoards, setFavoriteBoards, setAllBoards, sidebarItemClick, addNewBoard, boardTitle}){
    function handleSidebarClick(name){
        if (window.confirm(name + " will be loaded") == true) {
            sidebarItemClick(name)
        } else {}
    }

    const [isAllOpen, setIsAllOpen] = useState(true);
    const [isFavoriteOpen, setIsFavOpen] = useState(true);
    const [favImage, setFavImage] = useState(DropdownUp);
    const [allImage, setAllImage] = useState(DropdownUp);

    const toggleAllSection = () => {
        setIsAllOpen(!isAllOpen);
        if (allImage == DropdownDown){
            setAllImage(DropdownUp)
        }else{
            setAllImage(DropdownDown)
        }
    };
    const toggleFavSection = () => {
        setIsFavOpen(!isFavoriteOpen);
        if (favImage == DropdownDown){
            setFavImage(DropdownUp)
        }else{
            setFavImage(DropdownDown)
        }
    };
    function removeFavorite(event, clickedBoard){
        event.stopPropagation();
        setFavoriteBoards(prevBoards => prevBoards.filter(board => board !== clickedBoard));
    }
    function removeAll(event, clickedBoard){
        event.stopPropagation();
        if (window.confirm("This will DELETE " + clickedBoard) == true) {
            if(boardTitle == clickedBoard){
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
                        <img className="dropdown-images" src={favImage}/>
                        {"Favorite Boards"}
                    </div>
                    {isFavoriteOpen &&
                        <ul className='lists'>
                            {favoriteBoards.map(board => (
                                <div onClick={()=>handleSidebarClick(board)} className="section-item" key={board}>
                                    {board}
                                    <img className="sidebar-star dropdown-item-images" onClick={(event)=> removeFavorite(event, board)} src={StarFilled}/>
                                </div>
                            ))}
                        </ul>
                    }                    
                </div>   
                <div className="all-section">
                    <div className="all-section-header" onClick={toggleAllSection}>
                        <img className="dropdown-images" src={allImage}/>
                        {"All Boards"}
                    </div>
                    {isAllOpen &&
                        <ul className='lists'>
                            {allBoards.map(board => (
                                <div onClick={()=>handleSidebarClick(board)} className="section-item" key={board}>
                                    {board}
                                    <img className="checkbox-delete dropdown-item-images" onClick={(event)=> removeAll(event, board)} src={BinBlack}/>
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