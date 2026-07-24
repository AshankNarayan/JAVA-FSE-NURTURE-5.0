import React from 'react';
import './App.css';
import Posts from './Posts';

function App() {
  return (
    <div className="blog-app-container">
      <header className="blog-header">
        <span className="blog-logo">✍️</span>
        <h1>Dynamic Blog Reader</h1>
        <p className="blog-subtitle">Real-time posts fetched from JSONPlaceholder API</p>
      </header>

      <main className="blog-content">
        <Posts />
      </main>

      <footer className="blog-footer">
        <p>&copy; 2026 Blog App. All rights reserved.</p>
      </footer>
    </div>
  );
}

export default App;

