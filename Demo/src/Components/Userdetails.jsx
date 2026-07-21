import { useEffect, useState } from "react";
import Style from "./Navbar.module.css";

function Userdetails() {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    fetch("http://localhost:3001/users")
      .then((res) => res.json())
      .then((data) => setUsers(data))
      .catch((err) => console.error(err));
  }, []);

  return (
    <div className={Style.userbox}>
      {users.map((user) => (
        <div className={Style.userdetails} key={user.id}>
          <h2>User Details</h2>
          <p><strong>ID:</strong> {user.id}</p>
          <p><strong>Name:</strong> {user.name}</p>
          <p><strong>Email:</strong> {user.email}</p>
        </div>
      ))}
    </div>
  );
}

export default Userdetails;