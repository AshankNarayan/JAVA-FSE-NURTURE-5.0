import React from 'react';
import './App.css';
import CohortDetails from './CohortDetails';

function App() {
  const cohorts = [
    { id: 1, name: 'JAVA FSE - Cohort 1', status: 'ongoing', startDate: '2026-06-01', endDate: '2026-09-01', strength: 25 },
    { id: 2, name: 'ReactJS - Cohort 2', status: 'completed', startDate: '2026-03-01', endDate: '2026-05-30', strength: 30 },
    { id: 3, name: 'SQL Basics - Cohort 3', status: 'completed', startDate: '2026-01-15', endDate: '2026-02-28', strength: 18 },
    { id: 4, name: 'AWS Cloud - Cohort 4', status: 'ongoing', startDate: '2026-07-01', endDate: '2026-10-01', strength: 22 }
  ];

  return (
    <div className="cohort-app-container">
      <header className="cohort-header">
        <span className="cohort-logo">🎓</span>
        <h1>Academy Cohort Dashboard</h1>
        <p className="cohort-subtitle">Cognizant Upskilling & Technical Training Programs</p>
      </header>

      <main className="cohort-content">
        <div className="cohorts-grid">
          {cohorts.map(item => (
            <CohortDetails key={item.id} cohort={item} />
          ))}
        </div>
      </main>

      <footer className="cohort-footer">
        <p>&copy; 2026 Cognizant Academy. All rights reserved.</p>
      </footer>
    </div>
  );
}

export default App;

