function OddPlayers({ players }) {

  const [first, , third, , fifth] = players;

  return (
    <>
      <p>First : {first}</p>
      <p>Third : {third}</p>
      <p>Fifth : {fifth}</p>
    </>
  );
}

export default OddPlayers;