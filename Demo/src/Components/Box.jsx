import Todotask from "./Todotask";
import {useState} from 'react';
import style from "./Navbar.module.css";
function Box(props){
    const [purchased,setpurchased] = useState(true);
    function Buynow(){
        console.log(props.userid,"Parcased sucessfully")
        setpurchased(false);
    }
    return(
        <div className={style.Tasks}>
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