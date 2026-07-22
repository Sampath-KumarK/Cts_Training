import React from 'react'
import { useState, useEffect } from 'react'
function DisplayCustomer() {
    const [customers, setCustomers] = useState([]);
    useEffect(() => {
        fetch("http://localhost:8081/farmer/getall")
        .then((res) => res.json())
        .then((data) => {
            setCustomers(data);
        })
    }, [])
  return (
    <div>

        <h1>Customers List</h1>
        <ul>
            {customers.map((customer) => (
                <li key={customer.id}>
                    <p>Name: {customer.name}</p>
                    <p>Email: {customer.email}</p>
                    <p>Phone: {customer.phoneNumber}</p>
                    <p>Farm Name: {customer.farmName}</p>
                    <p>Place: {customer.place}</p>
                    <p>Address: {customer.address}
                    </p>
                    <p>Active: {customer.active ? "Yes" : "No"}</p>
                    <p>Created At: {customer.createdAt}</p>
                </li>
            ))}
        </ul>
    </div>
  )
}

export default DisplayCustomer
