function EvenPlayers({ players }) {

  const [, second, , fourth, , sixth] = players;

  return (
    <>
      <p>Second : {second}</p>
      <p>Fourth : {fourth}</p>
      <p>Sixth : {sixth}</p>
    </>
  );
}

export default EvenPlayers;