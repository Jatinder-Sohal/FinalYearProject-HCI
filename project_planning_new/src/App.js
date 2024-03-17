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
function App() {
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [selectedCard, setSelectedCard] = useState(null);
  const [listWithCard, setCurrentList] = useState(null);

  const handleCardClick = (card, currentList) => {
    setSelectedCard(card);
    setCurrentList(currentList)
    setIsModalOpen(true);
  };

  const closeModal = () => {
    setIsModalOpen(false);
    setSelectedCard(null);
  };


  const [listOne, setListOne] = useState([
    { id: 1, title: 'Sample Card' }, 
    { id: 2, title: 'Testing a longer card and text to see if overflow works' }, 
  ]);
  const [listTwo, setListTwo] = useState([
    { id: 3, title: 'Testing a longer card and text to see if overflow works' }, 
    { id: 5, title: 'Testing a longer card and text to see if overflow works' }, 
  ]);
  const [listThree, setListThree] = useState([
    { id: 4, title: 'Sample Card' }, 
    { id: 6, title: 'Testing a longer card and text to see if overflow works' }, 
  ]);
  const [listFour, setListFour] = useState([
  ]);
  const [listFive, setListFive] = useState([
  ]);
  const [listOneName, setListOneName] = useState("To Do");
  const [listTwoName, setListTwoName] = useState("In Progress")
  const [listThreeName, setListThreeName] = useState("Done")
  const [listFourName, setListFourName] = useState("")
  const [listFiveName, setListFiveName] = useState("")


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
  function reorder(list, startIndex, endIndex) {
    const result = Array.from(list);
    const [removed] = result.splice(startIndex, 1);
    result.splice(endIndex, 0, removed);
  
    return result;
  }
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

  function toggle(listName) {
    listShown++;
    if (listShown == 4){
      setListFourName(listName)
      setIsFourOpen((isFourOpen) => !isFourOpen);
    }else if (listShown == 5) {
      setListFiveName(listName)
      setIsFiveOpen((isFiveOpen) => !isFiveOpen);
    }else{
      listShown = 5;
      alert("You cannot add any more lists!")
    }
  }

  return (
    <div className="Root">
      <Topbar />
      <div className="Content">
        <Sidebar/>
        <div style={{ display: 'flex'}}>
          <Toolbar />
          <DragDropContext onDragEnd={onDragEnd}>
            <div style={{ display: 'flex', alignItems: "flex-start"}}>
              <List title={listOneName} listTitle="listOne" cardList={listOne} onAddButton={addCard} cardClick ={handleCardClick} updateTitle={setListOneName}/>
              <List title={listTwoName} listTitle="listTwo" cardList={listTwo} onAddButton={addCard} cardClick ={handleCardClick} updateTitle={setListTwoName}/>
              <List title={listThreeName} listTitle="listThree" cardList={listThree} onAddButton={addCard} cardClick ={handleCardClick} updateTitle={setListThreeName}/>
              {isFourOpen && 
              <List title={listFourName} listTitle="listFour" cardList={listFour} onAddButton={addCard} cardClick ={handleCardClick} updateTitle={setListFourName}/>
              }
              {isFiveOpen && 
              <List title={listFiveName} listTitle="listFive" cardList={listFive} onAddButton={addCard} cardClick ={handleCardClick} updateTitle={setListFiveName}/>
              }
            </div>
          </DragDropContext>
          <NewList addList={toggle} />
        </div>
        
        {isModalOpen && (
          <Modal card={selectedCard} onClose={closeModal} listTitle={listWithCard} />
        )}
      </div>
    </div>
  );
}

export default App;