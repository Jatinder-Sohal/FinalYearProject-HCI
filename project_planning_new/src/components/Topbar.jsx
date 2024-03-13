import './Topbar.css'
import Star from '../images/star.png';

function Topbar(){
    return(
        <div className='Topbar'>
            <div className='left-Topbar'>
                <div className='Board-Information'>
                    <h2 className='date'>First Created: 5/03/2024</h2>
                    <h2 className='date' style={{marginBottom: "30px"}}>Last Accessed: 5/03/2024</h2>
                </div>
                <img src={Star} className="Star" alt="Favourite Board" />
            </div>
            <div className='middle-Topbar'>
                <h1 className='Topbar-Title'>Kanban Board</h1>
            </div>
            <div className='right-Topbar'>
                <h1 className='Topbar-Title'>Kanban Board</h1>
            </div>
        </div>
    );
}

export default Topbar;