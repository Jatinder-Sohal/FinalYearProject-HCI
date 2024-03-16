import React, { useState } from 'react';
import './Sidebar.css';
import DropdownUp from '../images/dropdown-up.png';
import DropdownDown from '../images/dropdown-down.png';
import StarFilled from '../images/star.png'
import Star from '../images/filled-star.png'
import StarBorder from '../images/star-border.png'
import BinBlack from '../images/bin-black.png'

function Sidebar(){
  const favoriteBoards = ['Board 1', 'Board 2']; 
  const allBoards = ['Board 3', 'Board 4', 'Board 5'];
  
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
                                <img className="dropdown-item-images" src={StarFilled}/>
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
                                <img className="dropdown-item-images" src={BinBlack}/>
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