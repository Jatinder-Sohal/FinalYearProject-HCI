import React from "react";
import List from "./components/List"; 
import { useState } from 'react';
import { DragDropContext } from 'react-beautiful-dnd';
import Modal from './components/Modal';
import Topbar from './components/Topbar'
import Sidebar from "./components/Sidebar";
import Toolbar from "./components/Toolbar";
import NewList from "./components/NewList"
import './App.css'


var todoID = 7;
var listShown = 3;
var newBoard = 0;
/**
 * The main component for my application which connects components
 * Allows users to manage tasks accross lists with drag and drop
 * Multiple features including sorting, new lists, boards and cards and customisation
 */
function App() {
  //Various state hooks that are used in a multitue of methods
  const [contentColour, setContentColour] = useState('#97f0ff');
  const [boardTitle, setBoardTitle] = useState('Kanban Board')
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [selectedCard, setSelectedCard] = useState(null);
  const [listWithCard, setCurrentList] = useState(null);
  const [favoriteBoards, setFavoriteBoards] = useState(['Board 2']);
  const [allBoards, setAllBoards] = useState([boardTitle, 'Board 2', 'Board 3']);
  
  /**
   * Updates the  board's title and the respective title in sidebar.
   * @param {string} newTitle - The new title to set.
   */
  function updateSidebar(newTitle){
    setBoardTitle(newTitle)
    setFavoriteBoards(boards =>
      boards.map((board, i) => (i === 1 ? newTitle : board))
    );
    setAllBoards(boards =>
      boards.map((board, i) => (i === 0 ? newTitle : board))
    );
  }

  /**
   * Handles card click.
   * Opens a modal and sets the current list and card.
   * @param {Object} card - The card object that was clicked.
   * @param {string} currentList - The list containing the card.
   */
  function handleCardClick(card, currentList){
    setSelectedCard(card);
    setCurrentList(currentList)
    setIsModalOpen(true);
  };

  /**
   * Closes the modal and clears variable for selected card.
   */
  function closeModal() {
    setIsModalOpen(false);
    setSelectedCard(null);
  };

  //The list with card items stored with IDs from 1
  const [listOne, setListOne] = useState([
    { id: 1, title: 'Add tasks to git' }, 
    { id: 2, title: 'Create teams meeting' },
    { id: 3, title: 'Link menu class to order' },
  ]);
  const [listTwo, setListTwo] = useState([
    { id: 5, title: 'Accept different forms of payment' }, 
  ]);
  const [listThree, setListThree] = useState([ 
    { id: 4, title: 'Set up Project' },
    { id: 6, title: 'Creating menu class using TDD and uploaded files to git' },  
  ]);
  const [listFour, setListFour] = useState([
  ]);
  const [listFive, setListFive] = useState([
  ]);
  //Names kept seperatly as they can be changed with double click
  const [listOneName, setListOneName] = useState("To Do");
  const [listTwoName, setListTwoName] = useState("In Progress")
  const [listThreeName, setListThreeName] = useState("Done")
  const [listFourName, setListFourName] = useState("")
  const [listFiveName, setListFiveName] = useState("")

  /**
   * Adds a new card to the specified list.
   * @param {string} title - The title of the new card.
   * @param {string} listTitle - The list to which the card should be added.
   */
  function addCard(title, listTitle) {
    const newCard = { id: todoID, title }; 
    todoID++
    if (listTitle === "listOne") {
      setListOne([...listOne, newCard]);
    } else if (listTitle === "listTwo") {
      setListTwo([...listTwo, newCard]);
    } else if (listTitle === "listThree") {
      setListThree([...listThree, newCard]);
    } else if (listTitle === "listFour") {
      setListFour([...listFour, newCard]);
    } else if (listTitle === "listFive") {
      setListFive([...listFive, newCard]);
    } 
  };
  /**
   * Retrieves list based on the given  ID.
   * @param {string} listId - The identifier for the list.
   * @returns {Array} - The list corresponding to the listId.
 */
  function getList(listId) {
    if (listId === "listOne") {
      return listOne;
    } else if (listId === "listTwo") {
      return listTwo;
    } else if (listId === "listThree") {
      return listThree;
    } else if (listId === "listFour") {
      return listFour;
    } else if (listId === "listFive") {
      return listFive;
    } 
  }
  /**
   * Reorders the items within a single list based on their start and end positions.
   * @param {Array} list - The list in which items are to be reordered.
   * @param {number} startIndex - The starting index of the item to be moved.
   * @param {number} endIndex - The new index for the item.
   * @returns {Array} - The list rearranged with the item moved.
  */
  function reorder(list, startIndex, endIndex) {
    const result = Array.from(list);
    const [removed] = result.splice(startIndex, 1);
    result.splice(endIndex, 0, removed);
  
    return result;
  }
  /**
   * Moves an item from one list to another based on provided source and destination information.
   * @param {Array} sourceList - The list item is moving from.
   * @param {Array} destinationList - The list item is moving to.
   * @param {Object} droppableSource - The source droppable information containing the source index and list identifier.
   * @param {Object} droppableDestination - The destination droppable information containing the destination index and list identifier.
   * @returns {Object} - Object containing the updated source and destination lists.
  */
  function move(sourceList, destinationList, droppableSource, droppableDestination) {
    const source = Array.from(sourceList);
    const dest = Array.from(destinationList);

    const [removed] = source.splice(droppableSource.index, 1);
    dest.splice(droppableDestination.index, 0, removed);
  
    const result = {};
    result[droppableSource.droppableId] = source;
    result[droppableDestination.droppableId] = dest;
  
    return result;
  }

  /**
   * Handles the end of a drag by checking to reorder within the same list or move to a different list.
   * @param {Object} result - The result object containing source and destination droppable information.
  */
  function onDragEnd(result) {
    const { source, destination } = result;
    if (!destination) return;
    
    if (source.droppableId === destination.droppableId) {
      const items = reorder(
        getList(source.droppableId), 
        source.index, 
        destination.index 
      );
    
      if (source.droppableId === "listOne") {
        setListOne(items);
      } else if (source.droppableId === "listTwo") {
        setListTwo(items);
      } else if (source.droppableId === "listThree") {
        setListThree(items);
      } else if (source.droppableId === "listFour") {
        setListFour(items);
      } else if (source.droppableId === "listFive") {
        setListFive(items);
      }
    } else{
      const result = move(
        getList(source.droppableId),
        getList(destination.droppableId),
        source,
        destination
      );
      if (result.listOne) {
        setListOne(result.listOne);
      }
      if (result.listTwo) {
        setListTwo(result.listTwo);
      }
      if (result.listThree) {
        setListThree(result.listThree);
      }
      if (result.listFour) {
        setListFour(result.listFour);
      }
      if (result.listFive) {
        setListFive(result.listFive);
      }
    }
  }

  const [isFourOpen, setIsFourOpen] = useState(false);
  const [isFiveOpen, setIsFiveOpen] = useState(false);

  /**
   * Toggles the visibility of additional lists based on how many currently showing.
   * @param {string} listName - The name of the new list to potentially add.
  */
  function toggle(listName) {
    listShown++;
    if (listShown === 4){
      setListFourName(listName)
      setIsFourOpen((isFourOpen) => !isFourOpen);
    }else if (listShown === 5) {
      setListFiveName(listName)
      setIsFiveOpen((isFiveOpen) => !isFiveOpen);
    }else{
      listShown = 5;
      alert("You cannot add any more lists!")
    }
  }

  /**
   * Adds a new board to sidebar list of boards
  */
  function addNewBoard(){
    setAllBoards(prevBoards => [...prevBoards, "New Board "+newBoard])
    newBoard++
  }
  /**
   * Handles the selection of a sidebar item, updating the board title and resetting lists.
   * @param {string} itemName - The name of the item clicked in the sidebar.
  */
  function sidebarItemClick(itemName){
    setBoardTitle(itemName)
    setListOne([
      { id: todoID, title: 'Add setting pages' },  
    ])
    setListTwo([
      { id: todoID+1, title: 'Set up navigation bar on all pages' }, 
      { id: todoID+2, title: 'Remove boilerplate code from documentation' },  
      { id: todoID+3, title: 'Add carousel from Bootstrap library' },
      { id: todoID+4, title: 'Write 5 unit tests' },
      { id: todoID+5, title: 'Refactor bottom sheet to include more categories' },
    ])
    setListThree([
      { id: todoID+6, title: 'Set up Jetpack compose' }, 
      { id: todoID+7, title: 'Install needed libararies and GIT repo' },  
    ])
    todoID = todoID + 8;
  }

  /**
   * Stars/unstars a board based on user action.
   * @param {string} action - Either star to favourite the board or any other value to unstar it.
  */
  function starBoard(action){
    if (action === "star"){
      setFavoriteBoards(['Board 2', boardTitle]);
    }else{
      setFavoriteBoards(['Board 2']);
    }
  }
  /**
  * Clears all cards from all lists.
  */
  function deleteCards(){
    setListOne([])
    setListTwo([])
    setListThree([])
  }
  /**
   * Sorts the lists based on the option select.
   * @param {string} sortBy - Selection by which to sort the lists.
  */
  function sortLists(sortBy){
    var sortedListOne = []
    var sortedListTwo = []
    var sortedListThree =[]
    if (sortBy === "ID"){
      sortedListOne = [...listOne].sort((a, b) => a.id - b.id);
      sortedListTwo= [...listTwo].sort((a, b) => a.id - b.id);
      sortedListThree = [...listThree].sort((a, b) => a.id - b.id);
    }else if (sortBy === "AZ"){
      sortedListOne = [...listOne].sort((a, b) => a.title.localeCompare(b.title));
      sortedListTwo = [...listTwo].sort((a, b) => a.title.localeCompare(b.title));
      sortedListThree = [...listThree].sort((a, b) => a.title.localeCompare(b.title));
    }else{
      sortedListOne = [...listOne].sort((a, b) => b.title.localeCompare(a.title));
      sortedListTwo = [...listTwo].sort((a, b) => b.title.localeCompare(a.title));
      sortedListThree = [...listThree].sort((a, b) => b.title.localeCompare(a.title));
    }   
    setListOne(sortedListOne);
    setListTwo(sortedListTwo)
    setListThree(sortedListThree)
  }
  /**
   * Deletes a specific card from a specified list.
   * @param {number} cardId - The ID of the card to delete.
   * @param {string} listTitle - The title of the list from which the card is to be deleted.
   */
  function deleteCard(cardId, listTitle) {
    console.log(`Deleting card ${cardId} from ${listTitle}`);
    if (listTitle === "To Do") {
      setListOne(prevList => prevList.filter(card => card.id !== cardId));
    } else if (listTitle === "In Progress") {
      setListTwo(prevList => prevList.filter(card => card.id !== cardId));
    } else if (listTitle === "Done") {
      setListThree(prevList => prevList.filter(card => card.id !== cardId));
    }
    closeModal();
  }
  return (
    <div className="Root">
      <Topbar title={boardTitle} updateTitle={updateSidebar} contentColour={contentColour} setContentColour={setContentColour}/>
      <div className="Content">
        <Sidebar favoriteBoards={favoriteBoards} setFavoriteBoards={setFavoriteBoards} allBoards={allBoards} setAllBoards={setAllBoards} sidebarItemClick={sidebarItemClick} addNewBoard={addNewBoard} boardTitle={boardTitle}/>
        <div style={{ display: 'flex'}}>
          <Toolbar starBoard={starBoard} deleteCards={deleteCards} sortLists={sortLists}/>
          <DragDropContext onDragEnd={onDragEnd}>
            <div style={{ display: 'flex', alignItems: "flex-start"}}>
              <List contentColour={contentColour} title={listOneName} listTitle="listOne" cardList={listOne} onAddButton={addCard} cardClick ={handleCardClick} updateTitle={setListOneName}/>
              <List contentColour={contentColour} title={listTwoName} listTitle="listTwo" cardList={listTwo} onAddButton={addCard} cardClick ={handleCardClick} updateTitle={setListTwoName}/>
              <List contentColour={contentColour} title={listThreeName} listTitle="listThree" cardList={listThree} onAddButton={addCard} cardClick ={handleCardClick} updateTitle={setListThreeName}/>
              {isFourOpen && 
              <List contentColour={contentColour} title={listFourName} listTitle="listFour" cardList={listFour} onAddButton={addCard} cardClick ={handleCardClick} updateTitle={setListFourName}/>
              }
              {isFiveOpen && 
              <List contentColour={contentColour} title={listFiveName} listTitle="listFive" cardList={listFive} onAddButton={addCard} cardClick ={handleCardClick} updateTitle={setListFiveName}/>
              }
            </div>
          </DragDropContext>
          <NewList addList={toggle} />
        </div>
        {isModalOpen && (
          <Modal card={selectedCard} onClose={closeModal} listTitle={listWithCard} listName deleteCard={deleteCard}/>
        )}
      </div>
    </div>
  );
}

export default App;