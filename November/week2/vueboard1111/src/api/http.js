import axios from "axios";
export default axios.create({
  baseURL: "http://localhost:8080/board10/board",
  headers: {
    "Content-Type": "application/json",
  },
});
