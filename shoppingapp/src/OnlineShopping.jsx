import React from "react";
import "./App.css";

function OnlineShopping() {
  const products = [
    {
      id: 1,
      productName: "Laptop",
      productPrice: "₹80,000",
    },
    {
      id: 2,
      productName: "TV",
      productPrice: "₹1,20,000",
    },
    {
      id: 3,
      productName: "Washing Machine",
      productPrice: "₹50,000",
    },
    {
      id: 4,
      productName: "Mobile",
      productPrice: "₹30,000",
    },
    {
      id: 5,
      productName: "Fridge",
      productPrice: "₹70,000",
    },
  ];

  return (
    <div className="container">
      <h1>Items Ordered :</h1>

      <table>
        <thead>
          <tr>
            <th>Name</th>
            <th>Price</th>
          </tr>
        </thead>

        <tbody>
          {products.map((pro) => (
            <tr key={pro.id}>
              <td>{pro.productName}</td>
              <td>{pro.productPrice}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default OnlineShopping;