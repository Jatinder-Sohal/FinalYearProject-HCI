import React from "react";
import List from "./components/list"; 
import { useState } from 'react';
import { DragDropContext } from 'react-beautiful-dnd';

var todoID = 7;
function App() {
  const [todoCards, setTodo] = useState([
    { id: 1, title: 'Sample Card' }, 
    { id: 2, title: 'Testing a longer card and text to see if overflow works' }, 
  ]);

  function addTodoCard(title) {
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
    
      if (source.droppableId === "todoCards") {
        setTodo(items);
      } else if (source.droppableId === "progressCards") {
        setProgress(items);
      } else if (source.droppableId === "doneCards") {
        setDone(items);
      }
    }else{
      const result = move(
        getList(source.droppableId),
        getList(destination.droppableId),
        source,
        destination
      );
  
      if (result.todoCards) {
        setTodo(result.todoCards);
      }
      if (result.progressCards) {
        setProgress(result.progressCards);
      }
      if (result.doneCards) {
        setDone(result.doneCards);
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