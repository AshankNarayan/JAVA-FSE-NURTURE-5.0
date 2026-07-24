import React, { useState } from 'react';
import './App.css';
import BookDetails from './Components/BookDetails';
import BlogDetails from './Components/BlogDetails';
import CourseDetails from './Components/CourseDetails';

function App() {
  const [activeTab, setActiveTab] = useState('book');

  // Method 1: If-Else Statement
  let ifElseComponent;
  if (activeTab === 'book') {
    ifElseComponent = <BookDetails />;
  } else if (activeTab === 'blog') {
    ifElseComponent = <BlogDetails />;
  } else if (activeTab === 'course') {
    ifElseComponent = <CourseDetails />;
  }

  // Method 4: Switch Statement
  const renderSwitch = (tab) => {
    switch(tab) {
      case 'book': return <BookDetails />;
      case 'blog': return <BlogDetails />;
      case 'course': return <CourseDetails />;
      default: return null;
    }
  };

  return (
    <div className="App">
      <header className="app-header">
        <h1>Blogger App</h1>
        <p>Demonstrating Conditional Rendering in React</p>
      </header>

      <div className="tab-buttons">
        <button className={activeTab === 'book' ? 'active' : ''} onClick={() => setActiveTab('book')}>Book Details</button>
        <button className={activeTab === 'blog' ? 'active' : ''} onClick={() => setActiveTab('blog')}>Blog Details</button>
        <button className={activeTab === 'course' ? 'active' : ''} onClick={() => setActiveTab('course')}>Course Details</button>
      </div>

      <div className="content-area">
        <div className="section">
          <h2>1. If-Else Statement Rendering</h2>
          {ifElseComponent}
        </div>

        <div className="section">
          <h2>2. Logical && (Short-Circuit) Rendering</h2>
          {activeTab === 'book' && <BookDetails />}
          {activeTab === 'blog' && <BlogDetails />}
          {activeTab === 'course' && <CourseDetails />}
        </div>

        <div className="section">
          <h2>3. Ternary Operator Rendering</h2>
          {activeTab === 'book' ? <BookDetails /> : (activeTab === 'blog' ? <BlogDetails /> : <CourseDetails />)}
        </div>

        <div className="section">
          <h2>4. Switch Statement Rendering</h2>
          {renderSwitch(activeTab)}
        </div>
      </div>
    </div>
  );
}

export default App;

