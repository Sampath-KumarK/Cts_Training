import CohortDetails from "./CohortDetails";
import "./App.css";

function App() {
  return (
    <div className="container">
      <h1>Cohorts Details</h1>

      <div className="cards">
        <CohortDetails
          title="INTADMDF10 -.NET FSD"
          color="blue"
          startDate="22-Feb-2022"
          status="Scheduled"
          coach="Aathma"
          trainer="Jojo Jose"
        />

        <CohortDetails
          title="ADM21JF014 -Java FSD"
          color="green"
          startDate="10-Sep-2021"
          status="Ongoing"
          coach="Apoorv"
          trainer="Elsa Smith"
        />

        <CohortDetails
          title="CDBJF21025 -Java FSD"
          color="green"
          startDate="24-Dec-2021"
          status="Ongoing"
          coach="Aathma"
          trainer="John Doe"
        />
      </div>
    </div>
  );
}

export default App;