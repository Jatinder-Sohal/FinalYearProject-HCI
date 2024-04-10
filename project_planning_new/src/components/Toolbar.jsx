import '../css/Toolbar.css'
import { useState } from 'react';
import Delete from '../images/bin.png';
import Undo from '../images/undo.png';
import Redo from '../images/redo.png';
import Sort from '../images/sort.png';
import Filter from '../images/filter.png';
import StarFilled from '../images/star.png';
import StarBorder from '../images/filled-star.png';
import Cancel from '../images/cancel-svgrepo-com.png';

function Toolbar({starBoard, deleteCards, sortLists}){
    const [star, setStar] = useState(StarBorder);
    function starClick(){
        if (star == StarFilled){
            starBoard("unstar")
            setStar(StarBorder)
        }else{
            starBoard("star")
            setStar(StarFilled)
        }
    }
    function handleDelete(){
        if (window.confirm("WARNING - all cards will be removed") == true) {
            deleteCards()
        } else {}  
    }

    const [isFilterOpen, setIsFilterOpen] = useState(false);
    const toggleFilter = () => {
        setIsFilterOpen(!isFilterOpen);
    };
    const [isSortOpen, setIsSortOpen] = useState(false);
    const toggleSort = () => {
        setIsSortOpen(!isSortOpen);
    };
    return(
        <div className='Toolbar'>
            {isSortOpen && (
                <div className="sort-dropdown">
                <div>
                    <h3 className='toolbar-dropdown-title'>Sort By:</h3>
                    <img src={Cancel} className="close-dropdown close-toolbar-dropdown" onClick={toggleSort}  alt="Close dropdown" />
                </div>
                <ul className='toolbar-dropdown-list'>
                    <h3 className='toolbar-dropdown-item' onClick={() => sortLists("All", "ID")}>First added</h3>
                    <h3 className='toolbar-dropdown-item'  onClick={() => sortLists("All", "AZ")}>A - Z</h3>
                    <h3 className='toolbar-dropdown-item'  onClick={() => sortLists("All", "ZA")}>Z - A</h3>
                </ul>
                </div>
            )}
            {isFilterOpen && (
                <div className="filter-dropdown">
                <img src={Cancel} className="close-dropdown close-toolbar-dropdown" onClick={toggleFilter}  alt="Close dropdown" />
                <ul className='toolbar-dropdown-list'>
                    <h3 className='toolbar-dropdown-item'></h3>
                    <h3 className='toolbar-dropdown-item'>test</h3>
                    <h3 className='toolbar-dropdown-item'>test</h3>
                </ul>
                </div>
            )}
            <div className='Main-Toolbar'>
                <img src={star} className="toolbar-star Item-Toolbar" onClick={starClick} alt="Favourite Board" />
                <img src={Undo} className="Item-Toolbar" alt="Undo last actions" />
                <img src={Redo} className="Item-Toolbar" alt="Redo last actions" />
                <img src={Sort} onClick={toggleSort} className="Item-Toolbar" alt="Sort cards" />
                <img src={Filter} onClick={toggleFilter} className="Item-Toolbar" alt="Filter cards" />
                </div>
            <div className='Single-Toolbar'>
                <img src={Delete} onClick={()=>handleDelete()} className="Item-Toolbar" alt="Delete all cards" />
            </div>
        </div>
    );
}

export default Toolbar;