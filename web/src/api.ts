import axios from "axios";

const API_URL = 'https://felipe-sds2.herokuapp.com/products';

export function fetchProducts() {
    return axios(`${API_URL}`);
}