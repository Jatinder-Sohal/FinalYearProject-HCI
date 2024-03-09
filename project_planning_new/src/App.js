import React from "react";
import List from "./components/list"; 
import { useState } from 'react';
import { DragDropContext } from 'react-beautiful-dnd';


function App() {
  const [todoCards, setTodo] = useState([
    { id: 1, title: 'Sample Card' }, 
    { id: 2, title: 'Testing a longer card and text to see if overflow works' }, 
  ]);

  const addTodoCard = (title) => {
    var todoID = 5;
    const newCard = { id: todoID, title }; 
    todoID++
    setTodo([...todoCards, newCard]);
  };
  const [progressCards, setProgress] = useState([
    { id: 3, title: 'Testing a longer card and text to see if overflow works' }, 
  ]);
  const [doneCards, setDone] = useState([
    { id: 4, title: 'Sample Card' }, 
  ]);

  const onDragEnd = (result) => {
    
  };

  return (
    <DragDropContext onDragEnd={onDragEnd}>
      <div style={{ display: 'flex', alignItems: "flex-start"}}>
        <List title="To Do" cardList={todoCards} onAddCard={addTodoCard}/>
        <List title="In Progress" cardList={progressCards} onAddCard={addTodoCard}/>
        <List title="Done" cardList={doneCards} onAddCard={addTodoCard}/>
      </div>
    </DragDropContext>
  );
}

export default App;