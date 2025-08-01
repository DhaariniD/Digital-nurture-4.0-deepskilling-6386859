import React from 'react';

const ListofPlayers = () => {
  // Using let and const to declare players
  const players = [
    { name: "Mr.Jack", score: 50 },
    { name: "Mr.Michael", score: 70 },
    { name: "Mr.John", score: 40 },
    { name: "Mr.Ann", score: 61 },
    { name: "Mr.Elisabeth", score: 61 },
    { name: "Mr.Sachin", score: 95 },
    { name: "Mr.Dhoni", score: 100 },
    { name: "Mr.Virat", score: 84 },
    { name: "Mr.Jadeja", score: 60 },
    { name: "Mr.Raina", score: 75 },
    { name: "Mr.Rohit", score: 80 },
  ];

  // Use map() to list players
  const playerList = players.map((player, index) => (
    <li key={index}>{player.name} - {player.score}</li>
  ));

  // Use arrow function + filter
  const filteredPlayers = players.filter(p => p.score < 70);

  return (
    <div>
      <h2>List of Players</h2>
      <ul>{playerList}</ul>
<hr />
      <h3>List of Players having Scores Less than 70</h3>
      <ul>
        {filteredPlayers.map((p, index) => (
          <li key={index}>{p.name} - {p.score}</li>
        ))}
      </ul>
    </div>
  );
};

export default ListofPlayers;
