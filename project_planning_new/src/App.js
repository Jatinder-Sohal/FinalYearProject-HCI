import React from "react";
import List from "./components/list"; 
import { useState } from 'react';

function App() {
  const [todoCards, setTodo] = useState([
    { id: 1, title: 'Sample Card' }, 
    { id: 2, title: 'Testing a longer card and text to see if overflow works' }, 
  ]);

  const addTodoCard = (title) => {
    var todoID = 2;
    const newCard = { id: todoID, title }; 
    todoID++
    setTodo([...todoCards, newCard]);
  };
  const [progressCards, setProgress] = useState([
    { id: 2, title: 'Testing a longer card and text to see if overflow works' }, 
  ]);
  const [doneCards, setDone] = useState([
    { id: 1, title: 'Sample Card' }, 
  ]);

  return (
    <div style={{ display: 'flex', alignItems: "flex-start"}}>
      <List title="To Do" cardList={todoCards} onAddCard={addTodoCard}/>
      <List title="In Progress" cardList={progressCards} onAddCard={addTodoCard}/>
      <List title="Done" cardList={doneCards} onAddCard={addTodoCard}/>
    </div>
  );
}

export default App;