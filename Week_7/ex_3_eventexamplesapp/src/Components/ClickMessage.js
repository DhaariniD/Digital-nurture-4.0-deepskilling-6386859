import React from 'react';

const ClickMessage = () => {
  const handleClick = (event) => {
    alert("I was clicked");
    console.log(event); // synthetic event
  };

  return (
    <div>
      <button onClick={handleClick}>Click on me</button>
    </div>
  );
};

export default ClickMessage;
