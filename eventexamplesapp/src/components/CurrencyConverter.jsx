import { useState } from "react";

function CurrencyConverter() {

  const [amount, setAmount] = useState("");
  const [currency, setCurrency] = useState("Euro");

  const handleSubmit = (e) => {
    e.preventDefault();

    const euro = amount / 90;

    alert(
      `${amount} INR = ${euro.toFixed(2)} ${currency}`
    );
  };

  return (
    <div>

      <h1>Currency Converter!!!</h1>

      <form onSubmit={handleSubmit}>

        <label>Amount</label>

        <input
          type="number"
          value={amount}
          onChange={(e) => setAmount(e.target.value)}
        />

        <br /><br />

        <label>Currency</label>

        <input
          type="text"
          value={currency}
          onChange={(e) => setCurrency(e.target.value)}
        />

        <br /><br />

        <button type="submit">
          Submit
        </button>

      </form>

    </div>
  );
}

export default CurrencyConverter;