function ScoreBelow70({ players }) {

  const lowScore = players.filter(player => player.score < 70);

  return (
    <ul>
      {lowScore.map((player, index) => (
        <li key={index}>
          Mr. {player.name} - {player.score}
        </li>
      ))}
    </ul>
  );
}

export default ScoreBelow70;