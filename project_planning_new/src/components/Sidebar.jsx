import React, { useState } from 'react';
import './Sidebar.css';
import DropdownUp from '../images/dropdown-up.png';
import DropdownDown from '../images/dropdown-down.png';
import StarFilled from '../images/star.png'
import Star from '../images/filled-star.png'
import StarBorder from '../images/star-border.png'
import BinBlack from '../images/bin-black.png'

function Sidebar({favoriteBoards, allBoards, setFavoriteBoards, setAllBoards}){
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
    function removeFavorite(clickedBoard){
        setFavoriteBoards(prevBoards => prevBoards.filter(board => board !== clickedBoard));
    }
    function removeAll(clickedBoard){
        setAllBoards(prevBoards => prevBoards.filter(board => board !== clickedBoard));
    }

    return (
        <div className="sidebar">
            <div>
                <div className="fav-section">
                    <div className="fav-section-header" onClick={toggleFavSection}>
                        <img className="dropdown-images" src={favImage}/>
                        {"Favorite Boards"}
                    </div>
                    {isFavoriteOpen &&
                        <ul className='lists'>
                            {favoriteBoards.map(board => (
                                <div className="section-item" key={board}>
                                    {board}
                                    <img className="sidebar-star dropdown-item-images" onClick={()=> removeFavorite(board)} src={StarFilled}/>
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
                                <div className="section-item" key={board}>
                                    {board}
                                    <img className="checkbox-delete dropdown-item-images" onClick={()=> removeAll(board)} src={BinBlack}/>
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