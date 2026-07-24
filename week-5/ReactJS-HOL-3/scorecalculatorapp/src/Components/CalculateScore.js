import React from 'react';
import '../Stylesheets/mystyle.css';

function CalculateScore(props) {
  const Name = props.Name || props.name || "Unknown Student";
  const School = props.School || props.school || "Unknown School";
  const Total = Number(props.Total || props.total || 0);
  const goal = Number(props.goal || props.Goal || 1); // Avoid division by zero
  
  // Calculate average
  const average = (Total / goal).toFixed(2);

  // Performance rating based on average
  let rating = "Needs Improvement";
  let ratingClass = "low-score";
  if (average >= 90) {
    rating = "Outstanding";
    ratingClass = "excellent-score";
  } else if (average >= 75) {
    rating = "Very Good";
    ratingClass = "good-score";
  } else if (average >= 50) {
    rating = "Satisfactory";
    ratingClass = "average-score";
  }

  return (
    <div className="report-card">
      <div className="card-header">
        <h3>Academic Report</h3>
        <span className={`status-badge ${ratingClass}`}>{rating}</span>
      </div>
      
      <div className="student-profile">
        <div className="profile-item">
          <label>Student Name</label>
          <span className="profile-val">{Name}</span>
        </div>
        <div className="profile-item">
          <label>Institution</label>
          <span className="profile-val">{School}</span>
        </div>
      </div>

      <div className="metrics-grid">
        <div className="metric-box">
          <span className="label">Total Score</span>
          <span className="value">{Total}</span>
        </div>
        <div className="metric-box">
          <span className="label">Goal (Subjects)</span>
          <span className="value">{goal}</span>
        </div>
        <div className="metric-box highlight">
          <span className="label">Average Score</span>
          <span className="value">{average}</span>
        </div>
      </div>
    </div>
  );
}

export default CalculateScore;
