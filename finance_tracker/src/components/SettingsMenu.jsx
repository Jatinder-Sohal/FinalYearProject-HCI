import React from 'react';
import { useState } from 'react';
import SettingImage from '../images/settings-svgrepo-com.png';
import SettingImageBlue from '../images/settings-svgrepo-com-Blue.png';
import './SettingsMenu.css';
import { useLocation } from "react-router-dom";

function SettingsMenu() {
  const location = useLocation();
  if (location.pathname === "/") {
    SettingImage = SettingImageBlue
  }

  const [isTextEnlarged, setTextEnlarged] = useState(false);
  const toggleTextSize = () => {
    setTextEnlarged(!isTextEnlarged);
    document.body.classList.toggle('enlarge-text');
  };
  const [isContrastOn, setContrastOn] = useState(false);
  const toggleConstrast = () => {
    setContrastOn(!isContrastOn);
    document.body.classList.toggle('text-contrast');
    document.body.classList.toggle('background-contrast');
    document.body.classList.toggle('background-contrast-enter');
    document.body.classList.toggle('background-contrast-help');
  };
  return (
    <div className="settings-container">
      <img src={SettingImage} className="setting-size" alt="Settings" />      
        <div className="settings-dropdown">
            <h3 className="dropdown-title">Accessibility Settings</h3>
            <h4>Visual Impairment</h4>   
                <label>
                    <input type="checkbox" className='checkbox' checked={isContrastOn} onChange={toggleConstrast}  /> High Contrast Mode
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