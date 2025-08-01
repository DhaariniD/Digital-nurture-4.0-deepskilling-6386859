import React from 'react';
import ListofPlayers from './components/ListofPlayers';
import IndianPlayers from './components/IndianPlayers';

function App() {
  let flag = false;

  return (
    <div className="App">
      
      {flag ? <ListofPlayers /> : <IndianPlayers />}
    </div>
  );
}

export default App;
