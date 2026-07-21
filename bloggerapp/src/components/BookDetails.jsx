function BookDetails() {

  const books = [
    {
      id: 1,
      name: "React in Action",
      author: "Mark Tielens",
      price: 650
    },
    {
      id: 2,
      name: "Java Programming",
      author: "Herbert Schildt",
      price: 850
    },
    {
      id: 3,
      name: "Python Basics",
      author: "John Zelle",
      price: 550
    }
  ];

  return (
    <div>

      <h2>Book Details</h2>

      <table border="1" cellPadding="10">

        <thead>
          <tr>
            <th>Book</th>
            <th>Author</th>
            <th>Price</th>
          </tr>
        </thead>

        <tbody>

          {books.map(book => (

            <tr key={book.id}>
              <td>{book.name}</td>
              <td>{book.author}</td>
              <td>₹{book.price}</td>
            </tr>

          ))}

        </tbody>

      </table>

    </div>
  );
}

export default BookDetails;