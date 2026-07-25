import React from 'react';
import './App.css';
import ComplaintRegister from './Components/ComplaintRegister';

function App() {
  return (
    <div className="App">
      <header className="app-header">
        <div className="logo-icon">🛡️</div>
        <h1>Support Portal</h1>
        <p>Ticket Raising & Management System</p>
      </header>

      <main className="app-main">
        <ComplaintRegister />
      </main>

      <footer className="app-footer">
        <p>&copy; 2026 Ticket Raising App</p>
      </footer>
    </div>
  );
}

export default App;

