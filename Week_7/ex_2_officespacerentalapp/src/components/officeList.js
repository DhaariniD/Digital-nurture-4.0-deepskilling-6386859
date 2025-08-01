import React from 'react';

const OfficeList = () => {
  const element = 'Office Space';
  const src = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSydU_-DkyKESoBuZ-1xHr0MwR-X-lFosWrxQ&s"; 
  const jsxatt = <img src={src} width="25%" height="25%" alt="Office Space" />;
  const itemName = {
    Name: "DBSM",
    Rent: 6000,
    Address: "Coimbatore"
  };

  return (
    <div>
      <h1>{element}, at Affordable Range</h1>
      {jsxatt}
      <h2>Name: {itemName.Name}</h2>
      <h3 style={{ color: itemName.Rent < 60000 ? 'red' : 'green' }}>
        Rent: Rs.{itemName.Rent}
      </h3>
      <h3>Address: {itemName.Address}</h3>
    </div>
  );
};

export default OfficeList;
