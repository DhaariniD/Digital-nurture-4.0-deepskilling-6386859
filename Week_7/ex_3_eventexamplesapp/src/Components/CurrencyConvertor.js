import React, { useState } from 'react';


const CurrencyConvertor = () => {
  const [rupees, setRupees] = useState('');
  const [euro, setEuro] = useState(null);
  const [currencyText, setCurrencyText] = useState('');

  const conversionRate = 0.011; 

  const handleSubmit = () => {
    const result = rupees * conversionRate;
    setEuro(result.toFixed(2));
    //setCurrencyText(`${rupees} INR = ${result.toFixed(2)} EUR`);
    alert(`Converting to Euro Amount is €${result.toFixed(2)}`);

  };

  return (
    <div>
      <h2 style={{ color: "green" }}>Currency Convertor!!!</h2>

      <label>Amount : </label>
      <input
        type="number"
        
        value={rupees}
        onChange={(e) => setRupees(e.target.value)}
      /><br /><br/>

      <label>Currency: </label>
      <textarea
        value={currencyText}
        onChange={(e) => setCurrencyText(e.target.value)}
        rows={3}
        cols={30}
      /><br /><br />

      <button onClick={handleSubmit} >Convert</button>

     
    </div>
  );
};

export default CurrencyConvertor;
