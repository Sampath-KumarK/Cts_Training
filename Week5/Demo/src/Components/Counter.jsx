import React from 'react'
import {useState,useEffect,useRef} from 'react'
function Counter() {
  const [count, setCount] = useState(0);
  let countRef = useRef(0);
  let variable = 0;
  function InncrefCount(){
    console.log(countRef.current + 1);
    countRef.current += 1;
    variable += 1;
    console.log("This is normal",variable);
  }
  return (
    <div>
      <h2>Counter Value : {count}</h2>
      <h2>This is ref count Vlue: {countRef.current}</h2>
      <h2>This is normal variable count Vlue: {variable}</h2>
      <button onClick={() => setCount(count + 1)}>Increment</button>
      <button onClick={() => setCount(count - 1)}>Decrement</button>
      <button onClick={InncrefCount}>IncRef</button>
    </div>
  )
}

export default Counter
