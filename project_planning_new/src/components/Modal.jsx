import './Modal.css'
import Cancel from '../images/cancel-svgrepo-com.png';

const Modal = ({ card, onClose, listTitle }) => {
    return (
      <div className="modal-backdrop">
        <div className="modal-content">
          <div style={{ display: 'flex'}}>
            <h2 className='modal-title'>{card.title}</h2>
            <img src={Cancel} className="modal-close"onClick={onClose}  alt="Close Modal" />
          </div>
          <h2 className='modal-listFrom'>In list: {listTitle}</h2>
          <h3 className='title-description'>Description</h3>
          <textarea className="modal-description"  placeholder="Enter a description for this card..."></textarea>
          <h3 className='title-description'>Checklist</h3>
          <textarea className="modal-description"  placeholder="Enter a description for this card..."></textarea>
        </div>
      </div>
    );
  };
  
  export default Modal;