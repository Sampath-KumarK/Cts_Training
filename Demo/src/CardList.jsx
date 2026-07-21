import Footer from "./Footer.jsx";
import React, { useState } from "react";
import "./App.css";
function CardList() {
  const [cards,setCards] = useState([
    {
      name: "Card 1",
      content: "This is the content of Card 1."
    },
    {
      name: "Card 2",
      content: "This is the content of Card 2."
    },
    {
      name: "Card 3",
      content: "This is the content of Card 3."
    }
  ]);
  function RemoveCard(id){
    const newCards = cards.filter((course) => course.id !== id);
    setCards(newCards);
  }
  const cardele = cards.map((car, index) => (
    <Footer
      key={index}
      name={car.name}
      content={car.content}
      deleteTask={RemoveCard}
      id={car.id}
    />
  ));

  return (
    <div className="card-container">
      {cardele}
    </div>
  );
}

export default CardList;