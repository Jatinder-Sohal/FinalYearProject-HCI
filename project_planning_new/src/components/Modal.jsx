import './Modal.css'
import Cancel from '../images/cancel-svgrepo-com.png';
import MoveLeft from '../images/left-arrow.png'
import MoveRight from '../images/right-arrow.png'
import Bin from '../images/bin-black.png'
import Share from '../images/share.png'
import Copy from '../images/copy.png'

const Modal = ({ card, onClose, listTitle }) => {
    return (
      <div className="modal-backdrop">
        <div className="modal-content">
          <div style={{ display: 'flex'}}>
            <h2 className='modal-title'>{card.title}</h2>
            <img src={Cancel} className="modal-close"onClick={onClose}  alt="Close Modal" />
          </div>
          <div style={{ display: 'flex'}}>
            <div>
              <h2 className='modal-listFrom'>In list: {listTitle}</h2>
              <h3 className='title-description'>Description</h3>
              <textarea className="modal-description"  placeholder="Enter a description for this card..."></textarea>
              
              <h3 className='title-description'>Checklist</h3>
              <input type="checkbox" checked />
              <label>Scales</label> <br />
              <input type="checkbox"  />
              <label>Scales</label>
            </div>
            <div style={{marginLeft:"22px", marginTop:"25px"}}>
                <h4 className='modal-subtitle'>Card actions</h4>
                <button className="modal-Button" >
                    <img src={MoveLeft} className="modal-icon" alt="Move to left list" />
                    <span className="modal-Button-Text">Move Left</span>
                </button>
                <button className="modal-Button" >
                    <img src={MoveRight} className="modal-icon" alt="Move to right list" />
                    <span className="modal-Button-Text">Move Right</span>
                </button>
                <button className="modal-Button" >
                    <img src={Copy} className="modal-icon" alt="Duplicate Card" />
                    <span className="modal-Button-Text">Copy</span>
                </button>
                <button className="modal-Button" >
                    <img src={Share} className="modal-icon" alt="Share card" />
                    <span className="modal-Button-Text">Share</span>
                </button>
                <button className="modal-Button" >
                    <img src={Bin} className="modal-icon" alt="Delete Card" />
                    <span className="modal-Button-Text">Delete</span>
                </button>
            </div>
          </div>
        </div>
      </div>
    );
  };
  
  export default Modal;