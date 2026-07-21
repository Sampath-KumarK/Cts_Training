import officeImg from "./assets/office.jpg";

function App() {

  const officeSpaces = [
    {
      id: 1,
      name: "DBS",
      rent: 50000,
      address: "Chennai",
      image: officeImg,
    },
    {
      id: 2,
      name: "WeWork",
      rent: 75000,
      address: "Bangalore",
      image: officeImg,
    },
    {
      id: 3,
      name: "SmartWorks",
      rent: 65000,
      address: "Hyderabad",
      image: officeImg,
    },
    {
      id: 4,
      name: "Regus",
      rent: 45000,
      address: "Mumbai",
      image: officeImg,
    },
  ];

  return (
    <div className="container">

      <h1>Office Space, at Affordable Range</h1>

      {officeSpaces.map((office) => (

        <div className="card" key={office.id}>

          <img
            src={office.image}
            alt={office.name}
          />

          <h2>Name: {office.name}</h2>

          <h3
            style={{
              color: office.rent <= 60000 ? "red" : "green",
            }}
          >
            Rent: Rs. {office.rent}
          </h3>

          <h3>Address: {office.address}</h3>

        </div>

      ))}

    </div>
  );
}

export default App;