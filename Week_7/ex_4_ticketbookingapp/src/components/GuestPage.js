import React from 'react';

function GuestPage({ onLogin }) {
  return (
    <div className="page">
      <h2>Welcome Guest!</h2>
      <p>You can browse the available flight details:</p>
      <ul>
        <li>Flight A: 10:00 AM - New York</li>
        <li>Flight B: 1:30 PM - London</li>
      </ul>
      <button onClick={onLogin}>Login to Book Tickets</button>
    </div>
  );
}

export default GuestPage;
