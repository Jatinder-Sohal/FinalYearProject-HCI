import './Modal.css'

const Modal = ({ card, onClose }) => {
    return (
      <div className="modal-backdrop">
        <div className="modal-content">
          <h2>{card.title}</h2>
          <button onClick={onClose}>Close</button>
        </div>
      </div>
    );
  };
  
  export default Modal;