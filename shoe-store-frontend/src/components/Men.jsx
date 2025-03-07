import React, { useState } from "react";

const colors = ["Black", "White", "Blue", "Red", "Green", "Purple", "Cream", "Pink"];

const Men = ({ shoes }) => {
  console.log("Men component rendering with shoes:", shoes);

  const [minPrice, setMinPrice] = useState(0);
  const [maxPrice, setMaxPrice] = useState(0);
  const [selectedSizes, setSelectedSizes] = useState([]);
  const [selectedColor, setSelectedColor] = useState("");
  const [filtersOpen, setFiltersOpen] = useState({ price: true, size: true, color: true });

  if (!shoes || shoes.length === 0) {
    return <p>Loading shoes...</p>;
  }

  const sortedSizes = Array.from(new Set(shoes.flatMap((shoe) => shoe.size))).sort((a, b) => a - b);

  const toggleSize = (size) => {
    setSelectedSizes((prevSizes) =>
      prevSizes.includes(size) ? prevSizes.filter((s) => s !== size) : [...prevSizes, size]
    );
  };

  const filteredShoes = shoes.filter((shoe) => {
    if (!(shoe.gender === true && shoe.adults === true)) return false;
    if (minPrice > 0 && shoe.price < minPrice) return false;
    if (maxPrice > 0 && shoe.price > maxPrice) return false;
    if (selectedColor && shoe.color !== selectedColor) return false;
    if (
      selectedSizes.length > 0 &&
      !selectedSizes.some((size) => shoe.size.includes(size) && shoe.pieces[shoe.size.indexOf(size)] > 0)
    ) {
      return false;
    }
    return true;
  });

  return (
    <div className="flex p-6">
      <div className="w-1/4 p-4 border-r">
        <div className="mb-4">
          <button
            className="mb-2 p-2 bg-gray-300 rounded w-full text-left"
            onClick={() => setFiltersOpen({ ...filtersOpen, price: !filtersOpen.price })}
          >
            Price Range {filtersOpen.price ? "▼" : "▶"}
          </button>
          {filtersOpen.price && (
            <div>
              <input
                type="number"
                placeholder="Min Price"
                value={minPrice || ""}
                onChange={(e) => setMinPrice(Number(e.target.value))}
                className="border p-2 rounded w-full"
              />
              <input
                type="number"
                placeholder="Max Price"
                value={maxPrice || ""}
                onChange={(e) => setMaxPrice(Number(e.target.value))}
                className="border p-2 rounded w-full mt-2"
              />
            </div>
          )}
        </div>

        <div className="mb-4">
          <button
            className="mb-2 p-2 bg-gray-300 rounded w-full text-left"
            onClick={() => setFiltersOpen({ ...filtersOpen, size: !filtersOpen.size })}
          >
            Size {filtersOpen.size ? "▼" : "▶"}
          </button>
          {filtersOpen.size && (
            <div className="flex gap-2 flex-wrap">
              {sortedSizes.map((size) => (
                <button
                  key={size}
                  onClick={() => toggleSize(size)}
                  className={`px-3 py-1 border rounded ${selectedSizes.includes(size) ? "bg-blue-500 text-white" : "bg-gray-200"}`}
                >
                  {size}
                </button>
              ))}
            </div>
          )}
        </div>

        <div className="mb-4">
          <button
            className="mb-2 p-2 bg-gray-300 rounded w-full text-left"
            onClick={() => setFiltersOpen({ ...filtersOpen, color: !filtersOpen.color })}
          >
            Color {filtersOpen.color ? "▼" : "▶"}
          </button>
          {filtersOpen.color && (
            <div className="flex gap-2 flex-wrap">
              {colors.map((color) => (
                <button
                  key={color}
                  onClick={() => setSelectedColor(color === selectedColor ? "" : color)}
                  className={`w-8 h-8 border rounded ${selectedColor === color ? "ring-2 ring-black" : ""}`}
                  style={{ backgroundColor: color.toLowerCase() }}
                />
              ))}
            </div>
          )}
        </div>
      </div>

      <div className="w-3/4 p-4">
        {filteredShoes.length === 0 ? (
          <p>No men's shoes found.</p>
        ) : (
          <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
            {filteredShoes.map((shoe) => (
              <div
                key={shoe.shoeId}
                className="border p-4 rounded shadow-lg"
              >
                <h3 className="text-lg font-semibold">Model: {shoe.model}</h3>
                <p className="text-sm">Price: {shoe.price} USD</p>
                <p className="text-sm">Color: {shoe.color}</p>
                <img
                  src={shoe.image}
                  alt={shoe.model}
                  className="w-24 h-24 object-cover mt-2"
                />
              </div>
            ))}
          </div>
        )}
      </div>
    </div>
  );
};

export default Men;