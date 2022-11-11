import axios from "axios";
export default axios.create({
  baseURL: "http://localhost:8080/board1104/board",
  headers: {
    "Content-Type": "application/json",
  },
});
