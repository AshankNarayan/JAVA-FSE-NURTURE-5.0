import React from 'react';

function IndianPlayers() {
  // --- Destructuring Feature of ES6 ---
  // Odd Team Players and Even Team Players
  const teamPlayers = [
    'Rohit Sharma',
    'Virat Kohli',
    'Shubman Gill',
    'KL Rahul',
    'Shreyas Iyer',
    'Hardik Pandya',
    'Ravindra Jadeja',
    'Jasprit Bumrah',
    'Mohammed Shami',
    'Kuldeep Yadav',
    'Suryakumar Yadav'
  ];

  // Destructuring: separate into odd-indexed and even-indexed players
  const oddTeam = teamPlayers.filter((_, index) => index % 2 !== 0);
  const evenTeam = teamPlayers.filter((_, index) => index % 2 === 0);

  // Destructure individual players from each team
  const [odd1, odd2, odd3, odd4, odd5] = oddTeam;
  const [even1, even2, even3, even4, even5, even6] = evenTeam;

  // --- Merge Feature of ES6 ---
  // Declare two arrays: T20 players and Ranji Trophy players
  const T20players = ['Suryakumar Yadav', 'Hardik Pandya', 'Rinku Singh', 'Tilak Varma', 'Arshdeep Singh'];
  const RanjiTrophyPlayers = ['Cheteshwar Pujara', 'Ajinkya Rahane', 'Hanuma Vihari', 'Jaydev Unadkat', 'Sarfaraz Khan'];

  // Merge two arrays using ES6 spread operator
  const allPlayers = [...T20players, ...RanjiTrophyPlayers];

  return (
    <div className="component-container">
      <h2>🇮🇳 Indian Players</h2>

      <div className="section">
        <h3>Odd Team Players (ES6 Destructuring)</h3>
        <ul className="player-list odd-list">
          <li>{odd1}</li>
          <li>{odd2}</li>
          <li>{odd3}</li>
          <li>{odd4}</li>
          <li>{odd5}</li>
        </ul>
      </div>

      <div className="section">
        <h3>Even Team Players (ES6 Destructuring)</h3>
        <ul className="player-list even-list">
          <li>{even1}</li>
          <li>{even2}</li>
          <li>{even3}</li>
          <li>{even4}</li>
          <li>{even5}</li>
          <li>{even6}</li>
        </ul>
      </div>

      <div className="section">
        <h3>T20 Players</h3>
        <ul className="player-list t20-list">
          {T20players.map((player, index) => (
            <li key={index}>{player}</li>
          ))}
        </ul>
      </div>

      <div className="section">
        <h3>Ranji Trophy Players</h3>
        <ul className="player-list ranji-list">
          {RanjiTrophyPlayers.map((player, index) => (
            <li key={index}>{player}</li>
          ))}
        </ul>
      </div>

      <div className="section">
        <h3>Merged Players (ES6 Spread/Merge)</h3>
        <ul className="player-list merged-list">
          {allPlayers.map((player, index) => (
            <li key={index}>{player}</li>
          ))}
        </ul>
      </div>
    </div>
  );
}

export default IndianPlayers;
