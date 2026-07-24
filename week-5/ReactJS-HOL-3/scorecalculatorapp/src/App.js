import React, { useState } from 'react';
import CalculateScore from './Components/CalculateScore';
import './Stylesheets/mystyle.css';

function App() {
  const [student, setStudent] = useState({
    Name: 'Alice Smith',
    School: 'Vanguard Academy',
    Total: 462,
    goal: 5
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setStudent(prev => ({
      ...prev,
      [name]: name === 'Total' || name === 'goal' ? Number(value) : value
    }));
  };

  return (
    <div className="app-container">
      <h1 className="dashboard-title">Student Performance Dashboard</h1>
      <p className="dashboard-subtitle">Calculate and track average marks dynamically</p>
      
      <div className="dashboard-layout">
        <div className="input-panel">
          <h3>Enter Details</h3>
          
          <div className="form-group">
            <label htmlFor="studentName">Student Name</label>
            <input 
              type="text" 
              id="studentName" 
              name="Name" 
              value={student.Name} 
              onChange={handleChange} 
            />
          </div>

          <div className="form-group">
            <label htmlFor="schoolName">School / Academy</label>
            <input 
              type="text" 
              id="schoolName" 
              name="School" 
              value={student.School} 
              onChange={handleChange} 
            />
          </div>

          <div className="form-group">
            <label htmlFor="totalScore">Total Score (Cumulative)</label>
            <input 
              type="number" 
              id="totalScore" 
              name="Total" 
              value={student.Total} 
              onChange={handleChange} 
              min="0"
            />
          </div>

          <div className="form-group">
            <label htmlFor="goalSubjects">Goal (Number of Subjects)</label>
            <input 
              type="number" 
              id="goalSubjects" 
              name="goal" 
              value={student.goal} 
              onChange={handleChange} 
              min="1"
            />
          </div>
        </div>

        <CalculateScore 
          Name={student.Name}
          School={student.School}
          Total={student.Total}
          goal={student.goal}
        />
      </div>
    </div>
  );
}

export default App;

