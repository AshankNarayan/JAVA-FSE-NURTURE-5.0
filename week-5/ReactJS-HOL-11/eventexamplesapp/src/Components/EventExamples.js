import React, { useState } from 'react';

function EventExamples() {
  const [counter, setCounter] = useState(0);
  const [message, setMessage] = useState('');
  const [welcomeMsg, setWelcomeMsg] = useState('');
  const [syntheticMsg, setSyntheticMsg] = useState('');

  // Method to increment the value
  const incrementValue = () => {
    setCounter((prev) => prev + 1);
  };

  // Method to say Hello followed by a static message
  const sayHello = () => {
    setMessage('Hello! The counter has been incremented successfully.');
  };

  // Increment button invokes multiple methods
  const handleIncrement = () => {
    incrementValue();
    sayHello();
  };

  // Method to decrement the value
  const handleDecrement = () => {
    setCounter((prev) => prev - 1);
    setMessage('');
  };

  // Function which takes "welcome" as an argument
  const sayWelcomeMessage = (msg) => {
    setWelcomeMsg(msg + '! Thank you for visiting our Event Examples App.');
  };

  // Synthetic event "OnPress" which displays "I was clicked"
  const onPress = (e) => {
    e.preventDefault();
    setSyntheticMsg('I was clicked! (Synthetic Event: ' + e.type + ')');
  };

  return (
    <div className="event-examples-container">
      {/* 1. Counter with Increment and Decrement */}
      <div className="event-card">
        <h3>🔢 Counter</h3>
        <p className="counter-display">{counter}</p>
        <div className="button-group">
          <button className="btn btn-increment" onClick={handleIncrement}>
            Increment
          </button>
          <button className="btn btn-decrement" onClick={handleDecrement}>
            Decrement
          </button>
        </div>
        {message && <p className="event-message success-msg">{message}</p>}
      </div>

      {/* 2. Say Welcome button with argument */}
      <div className="event-card">
        <h3>👋 Welcome Event</h3>
        <button className="btn btn-welcome" onClick={() => sayWelcomeMessage('Welcome')}>
          Say Welcome
        </button>
        {welcomeMsg && <p className="event-message welcome-msg">{welcomeMsg}</p>}
      </div>

      {/* 3. Synthetic Event OnPress */}
      <div className="event-card">
        <h3>🖱️ Synthetic Event</h3>
        <button className="btn btn-synthetic" onClick={(e) => onPress(e)}>
          Click Me (OnPress)
        </button>
        {syntheticMsg && <p className="event-message synthetic-msg">{syntheticMsg}</p>}
      </div>
    </div>
  );
}

export default EventExamples;
