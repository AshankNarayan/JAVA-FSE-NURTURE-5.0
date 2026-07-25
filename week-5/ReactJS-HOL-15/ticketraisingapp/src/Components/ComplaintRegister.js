import React, { useState } from 'react';

function ComplaintRegister() {
  const [employeeName, setEmployeeName] = useState('');
  const [complaintText, setComplaintText] = useState('');
  
  const handleSubmit = (e) => {
    e.preventDefault();
    
    if (!employeeName.trim() || !complaintText.trim()) {
      alert("Please fill in both your name and the complaint details.");
      return;
    }

    // Generate a random reference number (e.g., REF-10293)
    const refNum = 'REF-' + Math.floor(Math.random() * 90000 + 10000);
    
    alert(`Complaint submitted successfully!\n\nEmployee: ${employeeName}\nReference Number: ${refNum}\n\nPlease keep this reference number for further follow-ups.`);
    
    // Clear the form after submission
    setEmployeeName('');
    setComplaintText('');
  };

  return (
    <div className="complaint-card">
      <h2>Raise a Complaint</h2>
      <p className="subtitle">Please provide your details and the issue you are facing.</p>
      
      <form onSubmit={handleSubmit} className="complaint-form">
        <div className="form-group">
          <label htmlFor="employeeName">Employee Name</label>
          <input 
            type="text" 
            id="employeeName" 
            placeholder="Enter your full name" 
            value={employeeName}
            onChange={(e) => setEmployeeName(e.target.value)}
          />
        </div>
        
        <div className="form-group">
          <label htmlFor="complaintText">Complaint Details</label>
          <textarea 
            id="complaintText" 
            rows="5" 
            placeholder="Describe your issue here..."
            value={complaintText}
            onChange={(e) => setComplaintText(e.target.value)}
          ></textarea>
        </div>
        
        <button type="submit" className="submit-btn">Submit Ticket</button>
      </form>
    </div>
  );
}

export default ComplaintRegister;
