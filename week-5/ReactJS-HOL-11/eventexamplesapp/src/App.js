import React from 'react';
import './App.css';
import EventExamples from './Components/EventExamples';
import CurrencyConvertor from './Components/CurrencyConvertor';

function App() {
  return (
    <div className="App">
      <header className="app-header">
        <span className="app-logo">⚡</span>
        <h1>Event Examples App</h1>
        <p className="app-subtitle">Handling various React Events &amp; Form Elements</p>
      </header>

      <main className="app-content">
        <section className="section-block">
          <h2 className="section-title">Event Handling</h2>
          <EventExamples />
        </section>

        <hr className="divider" />

        <section className="section-block">
          <h2 className="section-title">Currency Convertor</h2>
          <CurrencyConvertor />
        </section>
      </main>

      <footer className="app-footer">
        <p>&copy; 2026 Event Examples App. Built with React.</p>
      </footer>
    </div>
  );
}

export default App;

