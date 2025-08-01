import React from 'react';

const IndianPlayers = () => {
  // Destructuring
  const team = ["First:Sachin1", "Second:Dhoni2", "Third:Virat3", "Fourth:Rohit4", "Fifth:Yuvaraj5", "Sixth:Raina6"];
  const [p1, p2, p3, p4, p5, p6] = team;

  const oddTeam = [p1, p3, p5];
  const evenTeam = [p2, p4, p6];

  // Merge T20 and Ranji Trophy players
  const T20players = ["Mr.First Player", "Mr.Second Player","Mr.Third Player"];
  const RanjiPlayers = ["Mr.Fourth Player", "Mr.Fifth Player","Mr.Sixth Player"];
  const allPlayers = [...T20players, ...RanjiPlayers]; 

  return (
    <div>
      <h2>Odd  Players</h2>
      <ul>{oddTeam.map((p, i) => <li key={i}>{p}</li>)}</ul>
<hr />
      <h2>Even  Players</h2>
      <ul>{evenTeam.map((p, i) => <li key={i}>{p}</li>)}</ul>
<hr />
      <h2>List of Indian Playeres Merged</h2>
      <ul>{allPlayers.map((p, i) => <li key={i}>{p}</li>)}</ul>
    </div>
  );
};

export default IndianPlayers;
