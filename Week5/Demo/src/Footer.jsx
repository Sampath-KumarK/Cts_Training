import React from "react";
import "./App.css";
import {useState} from 'react';
import {useContext} from 'react';
import { AppContext } from "./App.jsx";
function Footer({
  name = "Default Name",
  content = "Default Content",
  deleteTask
}) {
  const context = useContext(AppContext);
  const [count,setCount] = useState(0);
  function Inccount(){
    setCount(count+1)
  }
  return (
    <div className="footer-card">
      <h2>This is the Footer{context.name}</h2>
      <h3>{name}</h3>
      <p>{content}</p>
      <p>{count}</p>
      <button onClick={Inccount}>Count</button>
      <button onClick={() => deleteTask()}>Delete</button>
    </div>
  );
}

export default Footer;
