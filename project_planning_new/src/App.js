import React from "react";
import List from "./components/list"; 
import { useState } from 'react';
import { DragDropContext } from 'react-beautiful-dnd';


function App() {
  const [todoCards, setTodo] = useState([
    { id: 1, title: 'Sample Card' }, 
    { id: 2, title: 'Testing a longer card and text to see if overflow works' }, 
  ]);

  function addTodoCard(title) {
    var todoID = 7;
    const newCard = { id: todoID, title }; 
    todoID++
    setTodo([...todoCards, newCard]);
  };
  const [progressCards, setProgress] = useState([
    { id: 3, title: 'Testing a longer card and text to see if overflow works' }, 
    { id: 5, title: 'Testing a longer card and text to see if overflow works' }, 
  ]);
  const [doneCards, setDone] = useState([
    { id: 4, title: 'Sample Card' }, 
    { id: 6, title: 'Testing a longer card and text to see if overflow works' }, 
  ]);

  function getList(listId) {
    if (listId === "todoCards") {
      return todoCards;
    } else if (listId === "progressCards") {
      return progressCards;
    } else if (listId === "doneCards") {
      return doneCards;
    } 
  }
  function reorder(list, startIndex, endIndex) {
    const result = Array.from(list);
    const [removed] = result.splice(startIndex, 1);
    result.splice(endIndex, 0, removed);
  
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
    
      if (source.droppableId === "todoCards") {
        setTodo(items);
      } else if (source.droppableId === "progressCards") {
        setProgress(items);
      } else if (source.droppableId === "doneCards") {
        setDone(items);
      }
    }
  }
  return (
    <DragDropContext onDragEnd={onDragEnd}>
      <div style={{ display: 'flex', alignItems: "flex-start"}}>
        <List title="To Do" listTitle="todoCards" cardList={todoCards} onAddCard={addTodoCard}/>
        <List title="In Progress" listTitle="progressCards" cardList={progressCards} onAddCard={addTodoCard}/>
        <List title="Done" listTitle="doneCards" cardList={doneCards} onAddCard={addTodoCard}/>
      </div>
    </DragDropContext>
  );
}

export default App;