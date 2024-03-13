import './Toolbar.css'
import Delete from '../images/bin.png';
import Undo from '../images/undo.png';
import Redo from '../images/redo.png';
import Sort from '../images/sort.png';
import Filter from '../images/filter.png';

function Toolbar(){
    return(
        <div className='Toolbar'>
            <div className='Main-Toolbar'>
                <img src={Undo} className="Item-Toolbar" alt="Undo last actions" />
                <img src={Redo} className="Item-Toolbar" alt="Redo last actions" />
                <img src={Sort} className="Item-Toolbar" alt="Sort cards" />
                <img src={Filter} className="Item-Toolbar" alt="Filter cards" />
                </div>
            <div className='Single-Toolbar'>
                <img src={Delete} className="Item-Toolbar" alt="Delete all cards" />
            </div>
        </div>
    );
}

export default Toolbar;