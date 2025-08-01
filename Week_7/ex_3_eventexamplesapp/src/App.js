import React from 'react';
import Counter from './Components/Counter';
import WelcomeButton from './Components/WelcomeButton';
import ClickMessage from './Components/ClickMessage';
import CurrencyConvertor from './Components/CurrencyConvertor';

function App() {
  return (
    <div className="App">
      

      <Counter />
     

      <WelcomeButton />
      

      <ClickMessage />
      <br/>
      <br/>

      <CurrencyConvertor />
    </div>
  );
}

export default App;
