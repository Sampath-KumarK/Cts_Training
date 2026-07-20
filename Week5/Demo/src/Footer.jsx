import React from "react";
import "./App.css";
import {useState} from 'react';
function Footer({
  name = "Default Name",
  content = "Default Content",
  deleteTask
}) {
  const [count,setCount] = useState(0);
  function Inccount(){
    setCount(count+1)
  }
  return (
    <div className="footer-card">
      <h2>This is the Footer</h2>
      <h3>{name}</h3>
      <p>{content}</p>
      <p>{count}</p>
      <button onClick={Inccount}>Count</button>
      <button onClick={() => deleteTask()}>Delete</button>
    </div>
  );
}

export default Footer;
