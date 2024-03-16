import React, { useState } from 'react';
import './Sidebar.css';



function Sidebar(){
  const favoriteBoards = ['Board 1', 'Board 2']; 
  const allBoards = ['Board 3', 'Board 4', 'Board 5'];
  
  const [isAllOpen, setIsAllOpen] = useState(true);
  const [isFavoriteOpen, setIsFavOpen] = useState(true);

  const toggleAllSection = () => {
    setIsAllOpen(!isAllOpen);
  };
  const toggleFavSection = () => {
    setIsFavOpen(!isFavoriteOpen);
  };

  return (
    <div className="sidebar">
        <div>
            <div className="fav-section">
                <div className="fav-section-header" onClick={toggleFavSection}>
                    {"Favorite Boards"}
                </div>
                {isFavoriteOpen &&
                    <ul className='lists'>
                        {favoriteBoards.map(board => (
                            <div className="section-item" key={board}>{board}</div>
                        ))}
                    </ul>
                }                    
            </div>   
            <div className="all-section">
                <div className="all-section-header" onClick={toggleAllSection}>
                    {"All Boards"}
                </div>
                {isAllOpen &&
                    <ul className='lists'>
                        {allBoards.map(board => (
                            <div className="section-item" key={board}>{board}</div>
                        ))}
                    </ul>
                }                    
            </div> 
        </div>
    </div>
  );
};

export default Sidebar;