import "./App.css";

function CohortDetails({
  title,
  color,
  startDate,
  status,
  coach,
  trainer,
}) {
  return (
    <div className="card">
      <h3 style={{ color }}>{title}</h3>

      <p>
        <strong>Started On</strong>
      </p>
      <p className="value">{startDate}</p>

      <p>
        <strong>Current Status</strong>
      </p>
      <p className="value">{status}</p>

      <p>
        <strong>Coach</strong>
      </p>
      <p className="value">{coach}</p>

      <p>
        <strong>Trainer</strong>
      </p>
      <p className="value">{trainer}</p>
    </div>
  );
}

export default CohortDetails;