import React from "react";

const Men = ({ shoes }) => {
  console.log("Men component rendering with shoes:", shoes);

  if (!shoes || shoes.length === 0) {
    return <p>Loading shoes...</p>;
  }

  const filteredShoes = shoes.filter(shoe => shoe.gender === true && shoe.adults === true);

  return (
    <div>
      <h2>Men's Shoes</h2>
      {filteredShoes.length === 0 ? (
        <p>No men's shoes found.</p>
      ) : (
        filteredShoes.map((shoe) => (
          <div key={shoe.shoeId} style={{ border: "1px solid black", padding: "10px", margin: "10px" }}>
            <h3>Model: {shoe.model}</h3>
            <p>Price: {shoe.price} USD</p>
            <p>Color: {shoe.color}</p>
            <img src={shoe.image} alt={shoe.model} width="100" />
          </div>
        ))
      )}
    </div>
  );
};

export default Men;
