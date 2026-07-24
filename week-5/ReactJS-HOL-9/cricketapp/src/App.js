import React, { useState } from 'react';
import './App.css';
import ListofPlayers from './Components/ListofPlayers';
import IndianPlayers from './Components/IndianPlayers';

function App() {
  const [flag, setFlag] = useState(true);

  let component;
  if (flag === true) {
    component = <ListofPlayers />;
  } else {
    component = <IndianPlayers />;
  }

  return (
    <div className="App">
      <header className="app-header">
        <span className="app-logo">🏏</span>
        <h1>Cricket App</h1>
        <p className="app-subtitle">ES6 Features — Map, Filter, Destructuring & Merge</p>
      </header>

      <div className="toggle-bar">
        <button
          className={flag ? 'toggle-btn active' : 'toggle-btn'}
          onClick={() => setFlag(true)}
        >
          List of Players
        </button>
        <button
          className={!flag ? 'toggle-btn active' : 'toggle-btn'}
          onClick={() => setFlag(false)}
        >
          Indian Players
        </button>
        <span className="flag-label">Flag = {flag.toString()}</span>
      </div>

      <main className="app-content">
        {component}
      </main>

      <footer className="app-footer">
        <p>&copy; 2026 CricketApp. Built with React &amp; ES6.</p>
      </footer>
    </div>
  );
}

export default App;

