import React, { useState } from 'react';

function CurrencyConvertor() {
  const [rupees, setRupees] = useState('');
  const [euro, setEuro] = useState(null);

  // Handle the input change event
  const handleChange = (e) => {
    setRupees(e.target.value);
    setEuro(null);
  };

  // Handle the Click event of the button to invoke the handleSubmit event
  const handleSubmit = (e) => {
    e.preventDefault();
    const rupeeValue = parseFloat(rupees);
    if (!isNaN(rupeeValue) && rupeeValue > 0) {
      // Conversion rate: 1 Euro = approximately 89 Indian Rupees
      const euroValue = (rupeeValue / 89).toFixed(2);
      setEuro(euroValue);
    } else {
      setEuro('Invalid');
    }
  };

  return (
    <div className="currency-container">
      <h3>💱 Currency Convertor</h3>
      <p className="currency-subtitle">Convert Indian Rupees (₹) to Euro (€)</p>

      <form onSubmit={handleSubmit} className="currency-form">
        <div className="input-group">
          <label htmlFor="rupees">Enter Amount in Rupees (₹)</label>
          <input
            type="number"
            id="rupees"
            value={rupees}
            onChange={handleChange}
            placeholder="e.g. 5000"
            className="currency-input"
          />
        </div>
        <button type="submit" className="btn btn-convert">
          Convert
        </button>
      </form>

      {euro !== null && euro !== 'Invalid' && (
        <div className="result-box">
          <p className="result-label">Converted Amount</p>
          <p className="result-value">₹ {parseFloat(rupees).toLocaleString()} = <span className="euro-value">€ {euro}</span></p>
        </div>
      )}

      {euro === 'Invalid' && (
        <p className="event-message error-msg">Please enter a valid positive number.</p>
      )}
    </div>
  );
}

export default CurrencyConvertor;
