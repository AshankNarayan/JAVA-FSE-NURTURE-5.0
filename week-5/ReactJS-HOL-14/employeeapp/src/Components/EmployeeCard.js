import React, { useContext } from 'react';
import ThemeContext from '../ThemeContext';

function EmployeeCard({ employee }) {
  // 8. Go to EmployeeCard component inside EmployeeCard.js file
  // a. Import the ThemeContext into the component file
  // b. Retrieve the value of the context with the help of useContext() and store it in a variable
  const theme = useContext(ThemeContext);

  // c. Use the variable to pass the className for the buttons.
  const btnClass = theme === 'dark' ? 'btn btn-dark' : 'btn btn-light';

  return (
    <div className={`card ${theme === 'dark' ? 'card-dark' : 'card-light'}`}>
      <div className="card-body">
        <h4 className="card-title">{employee.name}</h4>
        <p className="card-text">ID: {employee.id}</p>
        <p className="card-text">Designation: {employee.designation}</p>
        <button className={btnClass}>View Profile</button>
      </div>
    </div>
  );
}

export default EmployeeCard;
