import React from "react";
import Logo from "../assets/alternateLogo.png";
import { Link } from "react-scroll";

export const UpperBar = () => {
  return (
    <div className="w-full h-[45px] justify-between items-center px-8 bg-slate-400 text-black hidden md:flex">
      {/* Logo */}
      <div>
        <img src={Logo} alt="Logo Image" style={{ width: "40px" }} />
      </div>

      {/* Menu */}
      <ul className="hidden md:flex space-x-4">
        <li className="cursor-pointer hover:text-gray-700 transition duration-300">
          <Link>Help</Link>
        </li>
        <li className="text-gray-600">|</li>
        <li className="cursor-pointer hover:text-gray-700 transition duration-300">
          <Link>Sign In</Link>
        </li>
      </ul>
    </div>
  );
};

export default UpperBar;
