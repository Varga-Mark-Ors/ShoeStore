import { useState, useEffect } from "react";
import api from "../api/AxiosConfig";

const UseAccessories = () => {
    const[accessories, setAccessories] = useState([]);

    const getAccessories = async () => {
        try {
            const response = await api.get("/accessories");
            setAccessories(response.data || []);
        }
        catch (err) {
            console.error("Error fetching accessories:", err);
        }
    };

    useEffect(() => {
        getAccessories();
    });

    return accessories;
};

export default UseAccessories;