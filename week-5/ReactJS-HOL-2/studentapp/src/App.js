import React, { useState } from 'react';
import './App.css';
import Home from './Components/Home';
import About from './Components/About';
import Contact from './Components/Contact';

function App() {
  const [activeTab, setActiveTab] = useState('home');

  return (
    <div className="portal-container">
      <header className="portal-header">
        <div className="logo-section">
          <span className="portal-logo">🎓</span>
          <h1>Student Management Portal</h1>
        </div>
        <nav className="portal-nav">
          <button 
            className={`nav-btn ${activeTab === 'home' ? 'active' : ''}`}
            onClick={() => setActiveTab('home')}
          >
            Home
          </button>
          <button 
            className={`nav-btn ${activeTab === 'about' ? 'active' : ''}`}
            onClick={() => setActiveTab('about')}
          >
            About
          </button>
          <button 
            className={`nav-btn ${activeTab === 'contact' ? 'active' : ''}`}
            onClick={() => setActiveTab('contact')}
          >
            Contact
          </button>
        </nav>
      </header>

      <main className="portal-content">
        {activeTab === 'home' && <Home />}
        {activeTab === 'about' && <About />}
        {activeTab === 'contact' && <Contact />}
      </main>

      <footer className="portal-footer">
        <p>&copy; 2026 Student Management Portal. All rights reserved.</p>
      </footer>
    </div>
  );
}

export default App;

