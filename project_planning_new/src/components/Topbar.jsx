import { useState } from 'react';
import './Topbar.css'
import Help from '../images/help.png';
import Settings from '../images/settings.png';
import Share from '../images/share.png';
import Search from '../images/search.png'

function Topbar({title, updateTitle}){
    const [isEditingTitle, setIsEditingTitle] = useState(false);
    const [currentTitle, setCurrentTitle] = useState(title);
    function titleClick(){
        setIsEditingTitle(true);
    };
    function handleInput(){
        setIsEditingTitle(false);
        updateTitle(currentTitle);
    };

    return(
        <div className='Topbar'>
            <div className='left-Topbar'>
                <div className='Board-Information'>
                    <h2 className='date'>First Created: 5/03/2024</h2>
                    <h2 className='date' style={{marginBottom: "30px"}}>Last Accessed: 13/03/2024</h2>
                </div>
            </div>
            <div className='middle-Topbar'>
                {isEditingTitle ? (
                    <input 
                        className="topbar-title-input" 
                        type="text" 
                        value={currentTitle} 
                        onChange={(e) => setCurrentTitle(e.target.value)}
                        onBlur={handleInput}
                        onKeyDown={(e) => { if (e.key === 'Enter') { handleInput() } }}
                        autoFocus 
                    />
                ) : (
                    <h1 onClick={titleClick} className='Topbar-Title'>{title}</h1>
                )}
            </div>
            <div className='right-Topbar'>
                <div class="search-bar-container">
                    <img src={Search} className="search-icon" alt="Favourite Board" />
                    <input type="text" class="search-input" placeholder="Search" />
                </div>
                <div className="help-container">
                    <img src={Help} className="right-Icon help-icon" alt="Help icon" />
                    <div className="topbar-dropown help-dropdown">
                        <h1>test</h1>
                    </div>
                </div>
                
                <div className="settings-container">
                    <img src={Settings} className="settings-icon" alt="Settings Icon" />
                    <div className="topbar-dropown settings-dropdown">
                        <h1>test</h1>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Topbar;