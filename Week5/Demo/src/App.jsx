import Navbar from "./Components/Navbar.jsx";
import "./App.css";
import Counter from "./Components/Counter.jsx";
import CardList from "./CardList.jsx";
import Todotask  from "./Components/Todotask.jsx";
import Userdetails from "./Components/Userdetails.jsx";
import {createContext} from "react";

export const AppContext = createContext();
function App() {
  return (
    
    <AppContext.Provider value={{name:"sampath"}}>
      {/* <CardList/>
      <Navbar />
      <CardList />
      <Todotask/>
      <Userdetails/> */}
      <Counter/>
    </AppContext.Provider>

  );
}

export default App;