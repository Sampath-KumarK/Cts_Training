function IndianPlayers() {

  const t20Players = [
    "First Player",
    "Second Player",
    "Third Player"
  ];

  const ranjiPlayers = [
    "Fourth Player",
    "Fifth Player",
    "Sixth Player"
  ];

  const mergedPlayers = [...t20Players, ...ranjiPlayers];

  return (
    <ul>
      {mergedPlayers.map((player, index) => (
        <li key={index}>{player}</li>
      ))}
    </ul>
  );
}

export default IndianPlayers;