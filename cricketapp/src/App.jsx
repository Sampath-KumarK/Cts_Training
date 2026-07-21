import ListOfPlayers from "./components/ListOfPlayers";
import ScoreBelow70 from "./components/ScoreBelow70";
import OddPlayers from "./components/OddPlayers";
import EvenPlayers from "./components/EvenPlayers";
import IndianPlayers from "./components/IndianPlayers";

function App() {

  const flag = true;

  const players = [
    { name: "Jack", score: 50 },
    { name: "Michael", score: 70 },
    { name: "John", score: 40 },
    { name: "Arn", score: 61 },
    { name: "Elizabeth", score: 61 },
    { name: "Sachin", score: 95 },
    { name: "Dhoni", score: 100 },
    { name: "Virat", score: 84 },
    { name: "Jadeja", score: 64 },
    { name: "Raina", score: 75 },
    { name: "Rohit", score: 80 }
  ];

  const indianTeam = [
    "Sachin",
    "Dhoni",
    "Virat",
    "Rohit",
    "Yuvraj",
    "Raina"
  ];

  if (flag) {
    return (
      <>
        <h1>List of Players</h1>
        <ListOfPlayers players={players} />

        <hr />

        <h1>Players having Score Less than 70</h1>
        <ScoreBelow70 players={players} />
        <h1>Odd Players</h1>
      <OddPlayers players={indianTeam} />

      <hr />

      <h1>Even Players</h1>
      <EvenPlayers players={indianTeam} />

      <hr />

      <h1>Indian Players Merged</h1>
      <IndianPlayers />
      </>
    );
  }

 
}

export default App;