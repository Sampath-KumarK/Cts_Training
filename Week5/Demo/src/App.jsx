import Navbar from "./Components/Navbar.jsx";
import "./App.css";
import CardList from "./CardList.jsx";
import Todotask  from "./Components/Todotask.jsx";
import Userdetails from "./Components/Userdetails.jsx";
function App() {
  return (
    <>
    <Navbar />
      <CardList />
      <Todotask/>
      <Userdetails/>
    </>
  );
}

export default App;