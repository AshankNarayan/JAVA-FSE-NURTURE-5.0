import React from 'react';
import EmployeeCard from './EmployeeCard';

// 7. Go to EmployeeList component present in EmployeeList.js file 
// and modify it so that theme name is not passed explicitly to its child component.
function EmployeeList({ employees }) {
  return (
    <div className="employee-list">
      {employees.map((emp) => (
        <EmployeeCard key={emp.id} employee={emp} />
      ))}
    </div>
  );
}

export default EmployeeList;
