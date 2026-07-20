import Box from './Box'
import {useState} from 'react'
import Style from './Navbar.module.css'
import { useEffect } from 'react'
function Todotask(){
    // useEffect(()=>{
    //     fetch("https://dummyjson.com/todos")
    //     .then((res)=>res.json())
    //     .then((data)=>{
    //         settodos(data.todos)    
    //     })
    // },[])
    const [todos,settodos]=useState([
        {"id":1,"todo":"Complete the test","userid":345,"completed":true},
        {"id":2,"todo":"Complete the test","userid":1000,"completed":true},
        {"id":3,"todo":"Complete the test","userid":3452,"completed":true},
        {"id":4,"todo":"Complete the test","userid":445,"completed":true},
        {"id":5,"todo":"Complete the test","userid":145,"completed":true}
    ]);
    function handleDelete(id){
        const newtodo = todos.filter((to) => to.id != id)
        settodos(newtodo)
    }
    todos.sort((x,y) => y.userid - x.userid)
    const ttodos = todos.filter((f) => f.userid >300)
    const Finaltodo = ttodos.map((td) => (
    <Box 
    key={td.id}
    id={td.id}
    todo={td.todo}
    userid={td.userid}
    completed={td.completed}
    deletett={handleDelete}
    />));
    return(
        <div className={Style.last}>
            {Finaltodo}
        </div>
    )
}
export default Todotask;