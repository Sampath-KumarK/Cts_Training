import Todotask from "./Todotask";
import {useState} from 'react';
import style from "./Navbar.module.css";
import {useContext} from 'react';
import { AppContext } from "../App.jsx";
function Box(props){
    const [purchased,setpurchased] = useState(true);
    const context = useContext(AppContext);
    function Buynow(){
        console.log(props.userid,"Parcased sucessfully")
        setpurchased(false);
    }
    return(
        <div className={style.Tasks}>
            <p>{context.name}</p>
            <p>{props.id}</p>
            <p>{props.todo}</p>
            <p>{props.userid}</p>
            <p>{props.completed}</p>
            <button onClick={Buynow}>Buynow</button>
            <button onClick={() => props.deletett(props.id)}>Delete</button>
            <p>{purchased ?"Get it now ":"Alreaday purchased"}</p>
        </div>
    )
}
export default Box;