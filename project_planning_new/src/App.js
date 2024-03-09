import React from "react";
import List from "./components/list"; 
import { useState } from 'react';

function App() {
  const [todoCards, setCards] = useState([
    { id: 1, title: 'Sample Card' }, 
    { id: 2, title: 'Testing a longer card and text to see if overflow works' }, 
  ]);

  return (
    <div style={{ display: 'flex'}}>
      <List title="To Do" cardList={todoCards}/>
      <List title="In Progress" cardList={todoCards}/>
      <List title="Done" cardList={todoCards}/>
    </div>
  );
}

export default App;