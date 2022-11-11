import axios from "axios";
export default axios.create({
  baseURL: "http://localhost:8080/board1104/user",
  headers: {
    "Content-Type": "application/json",
  },
});
