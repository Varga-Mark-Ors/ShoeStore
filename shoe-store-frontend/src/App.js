import Navbar from "./components/Navbar";
import UpperBar from "./components/UpperBar";
import { Routes, Route } from "react-router-dom";
import Home from "./components/Home"
import Layout from "./components/Layout";
import Men from "./components/Men";
import useShoes from "./hooks/UseShoes";
import useAccessories from "./hooks/UseAccessories";

function App() {
  const shoes = useShoes();
  const accessories = useAccessories();

  return (
    <div className="App">
      <UpperBar />
      <Navbar />
      <Routes>
        <Route path="/*" element={<Layout />}>
          <Route index element={<Home/>} />
          <Route path="men" element={<Men shoes={shoes}/>} />
        </Route>
      </Routes>
    </div>
  );
}

export default App;
