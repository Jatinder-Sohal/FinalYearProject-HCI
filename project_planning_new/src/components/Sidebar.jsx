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
        <div style={{marginTop: "70px"}}>
            <div className="fav-section">
                <div className="fav-section-header" onClick={toggleFavSection}>
                    {"Favorite Boards"}
                </div>
                {isFavoriteOpen &&
                    <ul>
                        {favoriteBoards.map(board => (
                            <li key={board}>{board}</li>
                        ))}
                    </ul>
                }                    
            </div>   
            
        </div>
    </div>
  );
};

export default Sidebar;