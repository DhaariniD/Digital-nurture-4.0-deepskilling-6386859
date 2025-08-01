import React from 'react';

const WelcomeButton = () => {
  const sayMessage = (msg) => {
    alert(msg);
  };

  return (
    <div>
      <button onClick={() => sayMessage("Welcome!")}>Say Welcome</button>
    </div>
  );
};

export default WelcomeButton;
