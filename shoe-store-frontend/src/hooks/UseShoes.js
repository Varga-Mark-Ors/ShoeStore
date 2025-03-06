import { useState, useEffect } from "react";
import api from "../api/AxiosConfig";

const UseShoes = () => {
    const[shoes, setShoes] = useState([]);

    const getShoes = async () => {
        try {
            const response = await api.get("/shoes");
            setShoes(response.data || []);
        }
        catch (err) {
            console.error("Error fetching teams:", err);
        }
    };

    useEffect(() => {
        getShoes();
    });

    return shoes;
};

export default UseShoes;