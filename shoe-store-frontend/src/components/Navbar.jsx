import React, { useState } from "react";
import Logo from "../assets/mainLogo.png";
import { FaBars, FaTimes } from "react-icons/fa";
import { Link } from "react-scroll";
import { CiShoppingCart, CiHeart } from "react-icons/ci";
import { RiAccountCircleLine } from "react-icons/ri";


export const Navbar = () => {
  const [nav, setNav] = useState(false);
  const handleClick = () => setNav(!nav);

  return (
    <div className="w-full h-[80px] flex justify-between items-center px-4 bg-white text-black">
      {/* Logo */}
      <div>
        <img src={Logo} alt="Logo Image" style={{ width: "40px" }} />
      </div>

      {/* Menu */}
      <ul className="hidden md:flex space-x-6">
        {["Men", "Women", "Kids", "Accessories"].map((item, index) => (
          <li key={index} className="relative group cursor-pointer">
            <Link>{item}</Link>
            {/* Fekete csík hover esetén */}
            <span className="absolute left-0 bottom-[-3px] w-full h-[2px] bg-black scale-x-0 group-hover:scale-x-100 transition-transform duration-300"></span>
          </li>
        ))}
      </ul>

      {/* Icons */}
      <ul className="hidden md:flex space-x-4">
        <li>
          <Link>
            <div className="p-2 rounded-md hover:bg-gray-200 transition duration-300">
              <CiHeart className="text-2xl" />
            </div>
          </Link>
        </li>
        <li>
          <Link>
            <div className="p-2 rounded-md hover:bg-gray-200 transition duration-300">
              <CiShoppingCart className="text-2xl" />
            </div>
          </Link>
        </li>
      </ul>

      {/* Mobil menu icon */}
      <div onClick={handleClick} className="md:hidden z-10 flex items-center space-x-4 cursor-pointer ">
        <RiAccountCircleLine className="text-3xl" />
        <CiShoppingCart className="text-3xl" />
        {!nav ? <FaBars className="text-3xl" /> : <FaTimes className="text-3xl" />}
      </div>

      {/* Mobil menu */}
      <ul
        className={`${
          !nav ? "hidden" : "absolute"
        } top-0 left-0 w-full h-screen bg-slate-500 flex flex-col justify-center items-center`}
      >
        {["Men", "Women", "Kids", "Accessories"].map((item, index) => (
          <li key={index} className="py-6 text-4xl">
            <Link>{item}</Link>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Navbar;
