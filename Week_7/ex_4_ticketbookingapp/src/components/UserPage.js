import React from 'react';

function UserPage({ onLogout }) {
  return (
    <div className="page">
      <h2>Welcome User!</h2>
      <p>Book your flight tickets below:</p>
      <button>Book Flight A</button>
      <button>Book Flight B</button>
      <br /><br />
      <button onClick={onLogout}>Logout</button>
    </div>
  );
}

export default UserPage;
