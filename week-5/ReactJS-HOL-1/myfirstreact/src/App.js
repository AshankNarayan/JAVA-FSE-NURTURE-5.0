import React from 'react';
import './App.css';

function App() {
  return (
    <div className="App-container">
      <div className="card">
        <div className="react-icon-wrapper">
          <svg className="react-icon" viewBox="-11.5 -10.23 23 20.47" width="100%" height="100%">
            <circle cx="0" cy="0" r="2.05" fill="#61dafb"/>
            <g stroke="#61dafb" strokeWidth="1" fill="none">
              <ellipse rx="11" ry="4.2"/>
              <ellipse rx="11" ry="4.2" transform="rotate(60)"/>
              <ellipse rx="11" ry="4.2" transform="rotate(120)"/>
            </g>
          </svg>
        </div>
        <h1 className="main-heading">welcome to the first session of React</h1>
        <p className="subtext">Building modern web user interfaces with components, props, and state.</p>
        <div className="badge">Week 5 - Hands-on Lab 1</div>
      </div>
    </div>
  );
}

export default App;

