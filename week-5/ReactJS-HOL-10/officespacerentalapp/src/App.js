import React from 'react';
import './App.css';
import OfficeSpace from './OfficeSpace';

function App() {
  return (
    <div className="App">
      <header className="app-header">
        <span className="app-logo">🏢</span>
        <h1>Office Space Rental</h1>
        <p className="app-subtitle">Find the perfect workspace for your team</p>
      </header>

      <main className="app-content">
        <OfficeSpace />
      </main>

      <footer className="app-footer">
        <p>&copy; 2026 Office Space Rental App. Built with React JSX.</p>
      </footer>
    </div>
  );
}

export default App;

