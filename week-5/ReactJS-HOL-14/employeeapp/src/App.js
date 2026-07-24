import React, { useState } from 'react';
import './App.css';
import EmployeeList from './Components/EmployeeList';
import ThemeContext from './ThemeContext';

function App() {
  const [theme, setTheme] = useState('light');

  const employees = [
    { id: 101, name: 'John Doe', designation: 'Software Engineer' },
    { id: 102, name: 'Jane Smith', designation: 'UI/UX Designer' },
    { id: 103, name: 'Mike Johnson', designation: 'Project Manager' }
  ];

  const toggleTheme = () => {
    setTheme(prevTheme => prevTheme === 'light' ? 'dark' : 'light');
  };

  return (
    // 6. Open App component present in App.js file.
    // a. Import the ThemeContext in App component.
    // b. Define the theme context provider to be the entire JSX of the App component.
    // c. Assign the value for the theme provider from the state of the component.
    <ThemeContext.Provider value={theme}>
      <div className={`App ${theme === 'dark' ? 'app-dark' : 'app-light'}`}>
        <header className="app-header">
          <h1>Apps Centric Solutions</h1>
          <p>Employee Management Portal</p>
          <button className={`toggle-btn ${theme === 'dark' ? 'btn-dark' : 'btn-light'}`} onClick={toggleTheme}>
            Toggle Theme ({theme})
          </button>
        </header>

        <main className="app-content">
          {/* d. Modify the call to EmployeeList component so that theme name is no longer passed as props. */}
          <EmployeeList employees={employees} />
        </main>

        <footer className="app-footer">
          <p>&copy; 2026 Apps Centric Solutions</p>
        </footer>
      </div>
    </ThemeContext.Provider>
  );
}

export default App;

