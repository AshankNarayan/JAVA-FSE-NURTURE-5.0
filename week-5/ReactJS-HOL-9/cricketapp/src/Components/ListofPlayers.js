import React from 'react';

function ListofPlayers() {
  // Declare an array with 11 players with names and scores
  const players = [
    { name: 'Virat Kohli', score: 82 },
    { name: 'Rohit Sharma', score: 95 },
    { name: 'Shubman Gill', score: 65 },
    { name: 'KL Rahul', score: 45 },
    { name: 'Shreyas Iyer', score: 72 },
    { name: 'Hardik Pandya', score: 58 },
    { name: 'Ravindra Jadeja', score: 90 },
    { name: 'Jasprit Bumrah', score: 30 },
    { name: 'Mohammed Shami', score: 25 },
    { name: 'Kuldeep Yadav', score: 40 },
    { name: 'Suryakumar Yadav', score: 88 }
  ];

  // Filter players with scores below 70 using arrow functions of ES6
  const belowSeventy = players.filter((player) => player.score < 70);

  return (
    <div className="component-container">
      <h2>🏏 List of Players</h2>

      <div className="section">
        <h3>All Players (using ES6 map)</h3>
        <table className="players-table">
          <thead>
            <tr>
              <th>#</th>
              <th>Player Name</th>
              <th>Score</th>
            </tr>
          </thead>
          <tbody>
            {players.map((player, index) => (
              <tr key={index}>
                <td>{index + 1}</td>
                <td>{player.name}</td>
                <td>{player.score}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>

      <div className="section">
        <h3>Players with Score Below 70 (using ES6 arrow filter)</h3>
        <table className="players-table filter-table">
          <thead>
            <tr>
              <th>#</th>
              <th>Player Name</th>
              <th>Score</th>
            </tr>
          </thead>
          <tbody>
            {belowSeventy.map((player, index) => (
              <tr key={index}>
                <td>{index + 1}</td>
                <td>{player.name}</td>
                <td className="low-score">{player.score}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default ListofPlayers;
