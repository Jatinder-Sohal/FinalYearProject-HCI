import React from 'react';
import { useState, useEffect } from 'react';
import SettingImage from '../images/settings-svgrepo-com.png';
import SettingImageBlue from '../images/settings-svgrepo-com-Blue.png';
import './SettingsMenu.css';
import { useLocation } from "react-router-dom";

/**
 * SettingsMenu component which contains all accessiblity settings and functionality when selected
 * Also changes colour of icon depending on screen
 * @returns Component as div
 */
function SettingsMenu() {
  const location = useLocation();
  /**
   * Hook to update colour of setting button - white on default
   */
  const [currentSettingImage, setCurrentSettingImage] = useState(SettingImage);
  /**
   * Updates icon depending on page location
   * If home screen change to blue
   * Has a cleanup, due to errors with testing
   */
  useEffect(() => {
    if (location.pathname == '/') {
      setCurrentSettingImage(SettingImageBlue);
    } else {
      setCurrentSettingImage(SettingImage);
    }
  }, [location.pathname]);

 {/* Accessiblity settings
     First sets hook to opposite
     Then toggles css sheets to make changes to pages */}
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
    setCurrentSettingImage(SettingImage);
  };

  return (
    <div className="settings-container">
      {/* Settings icon */}
      <img src={currentSettingImage} className="setting-size" alt="Settings" />  
        {/* Dropdown with checkbox */}  
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