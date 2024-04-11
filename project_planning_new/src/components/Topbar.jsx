import { useState } from 'react';
import '../css/Topbar.css'
import Help from '../images/help.png';
import Settings from '../images/settings.png';
import Share from '../images/share.png';
import Search from '../images/search.png'

function Topbar({title, updateTitle, contentColour, setContentColour}){
    const [isEditingTitle, setIsEditingTitle] = useState(false);
    const [currentTitle, setCurrentTitle] = useState(title);
    function titleClick(){
        setIsEditingTitle(true);
    };
    function handleInput(){
        setIsEditingTitle(false);
        updateTitle(currentTitle);
    };

    const handleContentColorChange = (event) => {
        setContentColour(event.target.value);
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
                    <div className="topbar-dropdown help-dropdown">
                        <h1>Contact Us</h1>
                        <h2 className=''>Email:</h2> 
                        <h3 className='topbar-dropdown-contact'>ProjectPlanning@gmail.com</h3>
                        <h2>Phone:</h2>
                        <h3 className='topbar-dropdown-contact'>+449848436078</h3>
                        <h2>Twitter:</h2>
                        <h3 className='topbar-dropdown-contact'>@ProjectPlanningUK</h3>
                        <h2>Facebook:</h2>
                        <h3 className='topbar-dropdown-contact'>@ProjectPlanningUK</h3>
                    </div>
                </div>
                
                <div className="settings-container">
                    <img src={Settings} className="settings-icon" alt="Settings Icon" />
                    <div className="topbar-dropdown settings-dropdown">
                        <h1 className='topbarDropdown-title'>Settings</h1>
                        <div className="dropdown-option">
                            <label>Background Color:</label>
                            <input
                                className="background-color-picker"
                                type="color"
                                value="#ffffff"
                            />
                        </div>
                        <div className="dropdown-option">
                            <label>Content Color:</label>
                            <input
                                className="background-color-picker"
                                type="color"
                                value={contentColour}
                                onChange={handleContentColorChange}
                            />
                        </div>
                        <div className="dropdown-option">
                        <label>Dark Mode:</label>
                        <input
                            type="checkbox"
                            className='dropdown-checkbox' />
                            
                        </div>
                        <div className="dropdown-option">
                            <label>Contrast Mode:</label>
                            <input
                            type="checkbox"
                            className='dropdown-checkbox' />
                        </div>   
                        <div className="dropdown-option">
                            <label>Color Blind Mode:</label>
                            <input
                            type="checkbox"
                            className='dropdown-checkbox' />
                        </div>       
                        <div style={{marginTop: "15px"}}>
                            <label >Text Size:  5px</label> <br/>
                            <input
                                className="text-size-slider"
                                type="range"
                                min="12"
                                max="24"
                            />
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Topbar;