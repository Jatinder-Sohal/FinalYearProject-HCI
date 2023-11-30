import React from 'react';
import { useState } from 'react';
import SettingImage from '../images/settings-svgrepo-com.png';
import './SettingsMenu.css';

function SettingsMenu() {
const [isTextEnlarged, setTextEnlarged] = useState(false);

  const toggleTextSize = () => {
    setTextEnlarged(!isTextEnlarged);
    document.body.classList.toggle('enlarge-text');
  };
  return (
    <div className="settings-container">
      <img src={SettingImage} className="setting-size" alt="Settings" />      
        <div className="settings-dropdown">
            <h3 className="dropdown-title">Accessibility Settings</h3>
            <h4>Visual Impairment</h4>   
                <label>
                    <input type="checkbox" className='checkbox' /> High Contrast Mode
                </label>
                <label>
                    <input type="checkbox" className='checkbox' checked={isTextEnlarged} onChange={toggleTextSize} /> Enlarge Text
                </label>
                <h4>Color Blindness</h4>
                <label>
                    <input type="checkbox" className='checkbox' /> Deuteranopia (Green-Blind)
                </label>
                <label>
                    <input type="checkbox" className='checkbox' /> Protanopia (Red-Blind)
                </label>
                <h4>Audio Impairment</h4>
                <label>
                    <input type="checkbox" className='checkbox' /> Screen Reader
                </label>            
        </div>      
    </div>
  );
}

export default SettingsMenu;