import React from 'react';
import { useState, useEffect } from 'react';
import SettingImage from '../images/settings-svgrepo-com.png';
import SettingImageBlue from '../images/settings-svgrepo-com-Blue.png';
import './SettingsMenu.css';
import { useLocation } from "react-router-dom";

function SettingsMenu() {
  const location = useLocation();
  const [currentSettingImage, setCurrentSettingImage] = useState(SettingImage);

  useEffect(() => {
    if (location.pathname == '/') {
      setCurrentSettingImage(SettingImageBlue);
    } else {
      setCurrentSettingImage(SettingImage);
    }
  }, [location.pathname]);

  const [isTextEnlarged, setTextEnlarged] = useState(false);
  const toggleTextSize = () => {
    setTextEnlarged(!isTextEnlarged);
    document.body.classList.toggle('enlarge-text');
  };
  const [isContrastOn, setContrastOn] = useState(false);
  const toggleConstrast = () => {
    setContrastOn(!isContrastOn);
    document.body.classList.toggle('contrast');
  };
  const [isTritanopiaOn, setTritanopiaOn] = useState(false);
  const toggleTritanopia = () => {
    setTritanopiaOn(!isTritanopiaOn);
    document.body.classList.toggle('tritanopia');
  };

  return (
    <div className="settings-container">
      <img src={currentSettingImage} className="setting-size" alt="Settings" />    
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
                    <input type="checkbox" className='checkbox' checked={isTritanopiaOn} onChange={toggleTritanopia} /> Tritanopia (Blue-Blind)
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