import React from "react";
import List from "./components/list"; 

function App() {
  return (
    <div style={{ display: 'flex'}}>
      <List title="To Do" />
      <List title="In Progress" />
      <List title="Done" />
    </div>
  );
}

export default App;