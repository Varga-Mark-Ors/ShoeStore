import useShoes from "./hooks/UseShoes";
import UseAccessories from "./hooks/UseAccessories";

function App() {
  const shoes = useShoes();
  const accessories = UseAccessories();
  return (
    <div className="App">
      {shoes.map((shoe) => (
        <p key={shoe.id}><strong>{shoe.model}</strong></p>
      ))}
      {accessories.map((accessory) => (
        <p key={accessory.id}><strong>{accessory.accessoryType}</strong></p>
      ))}
    </div>
  );
}

export default App;
