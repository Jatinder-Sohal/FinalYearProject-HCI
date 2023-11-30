import React from 'react';
import SettingImage from '../images/settings-svgrepo-com.png';
import './SettingsMenu.css';

function SettingsMenu() {
  return (
    <div className="settings-container">
      <img src={SettingImage} className="setting-size" alt="Settings" />      
        <div className="settings-dropdown">
            <h4>Visual Impairment</h4>              
        </div>      
    </div>
  );
}

export default SettingsMenu;