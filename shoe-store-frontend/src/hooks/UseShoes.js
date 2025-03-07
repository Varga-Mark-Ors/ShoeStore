import { useState, useEffect } from "react";
import api from "../api/AxiosConfig";

const UseShoes = () => {
    const [shoes, setShoes] = useState([]);

    const getShoes = async () => {
        try {
            console.log("Fetching shoes..."); 
            const response = await api.get("/shoes");
            console.log("Shoes data received:", response.data); 
            setShoes(response.data || []);
        } catch (err) {
            console.error("Error fetching shoes:", err);
        }
    };

    useEffect(() => {
        getShoes();
    }, []);

    return shoes;
};

export default UseShoes;
