function UserPage() {
  return (
    <div>

      <h2>Welcome Back</h2>

      <h3>Book Your Flight</h3>

      <table border="1" cellPadding="10">

        <thead>
          <tr>
            <th>Flight</th>
            <th>Price</th>
          </tr>
        </thead>

        <tbody>
          <tr>
            <td>Chennai ➜ Bangalore</td>
            <td>₹3500</td>
          </tr>

          <tr>
            <td>Hyderabad ➜ Delhi</td>
            <td>₹5000</td>
          </tr>

          <tr>
            <td>Mumbai ➜ Kolkata</td>
            <td>₹4200</td>
          </tr>
        </tbody>

      </table>

    </div>
  );
}

export default UserPage;