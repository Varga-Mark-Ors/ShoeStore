import { useState, useEffect } from "react";
import api from "../api/AxiosConfig";

const UseAccessories = () => {
    const [accessories, setAccessories] = useState([]);

    const getAccessories = async () => {
        try {
            console.log("Fetching accessories..."); 
            const response = await api.get("/accessories");
            console.log("Accessories data received:", response.data); 
            setAccessories(response.data || []);
        } catch (err) {
            console.error("Error fetching accessories:", err);
        }
    };

    useEffect(() => {
        getAccessories();
    }, []);

    return accessories;
};

export default UseAccessories;
