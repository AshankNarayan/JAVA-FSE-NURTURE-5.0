import React from 'react';

function OfficeSpace() {
  // Create an object of office to display details like Name, Rent and Address
  const office = {
    name: 'Cognizant Tech Hub',
    rent: 75000,
    address: '1st Floor, Bund Garden Road, Pune, Maharashtra'
  };

  // Create a list of Objects and loop through office space items
  const officeSpaces = [
    { id: 1, name: 'Cognizant Tech Hub', rent: 75000, address: '1st Floor, Bund Garden Road, Pune, Maharashtra', image: '/office-space.png' },
    { id: 2, name: 'Startup Co-Work Arena', rent: 45000, address: '3rd Floor, MG Road, Bengaluru, Karnataka', image: '/office-space.png' },
    { id: 3, name: 'Innovation Tower', rent: 92000, address: '12th Floor, HITEC City, Hyderabad, Telangana', image: '/office-space.png' },
    { id: 4, name: 'Green Valley Office Park', rent: 55000, address: 'Block B, Sector 62, Noida, Uttar Pradesh', image: '/office-space.png' },
    { id: 5, name: 'Metro Business Center', rent: 68000, address: '5th Floor, Andheri East, Mumbai, Maharashtra', image: '/office-space.png' },
    { id: 6, name: 'Cloud9 Workspace', rent: 38000, address: '2nd Floor, Anna Salai, Chennai, Tamil Nadu', image: '/office-space.png' }
  ];

  // Function to determine rent color: Red if below 60000, Green if above 60000
  const getRentStyle = (rent) => {
    return {
      color: rent < 60000 ? '#ef4444' : '#22c55e',
      fontWeight: 700,
      fontSize: '1.15rem'
    };
  };

  return (
    <div className="office-space-container">
      {/* JSX Element: Heading of the page */}
      <h2>🏢 Featured Office Space</h2>

      {/* JSX Attribute: Display image of the office space */}
      <div className="featured-card">
        <img
          src="/office-space.png"
          alt="Office Space"
          className="featured-image"
          width="100%"
        />
        <div className="featured-details">
          <h3>{office.name}</h3>
          <p className="address">{office.address}</p>
          <p style={getRentStyle(office.rent)}>₹ {office.rent.toLocaleString()} / month</p>
        </div>
      </div>

      {/* JSX: Loop through the list of office space objects */}
      <h2>📋 All Available Office Spaces</h2>
      <div className="office-grid">
        {officeSpaces.map((item) => (
          <div className="office-card" key={item.id}>
            <img
              src={item.image}
              alt={item.name}
              className="office-card-image"
            />
            <div className="office-card-body">
              <h4>{item.name}</h4>
              <p className="address">{item.address}</p>
              <p style={getRentStyle(item.rent)}>₹ {item.rent.toLocaleString()} / month</p>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

export default OfficeSpace;
