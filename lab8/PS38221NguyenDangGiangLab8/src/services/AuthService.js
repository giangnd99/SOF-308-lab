import { useRouter } from "vue-router";
import authState from "../state/authState";
import axiosClient from "../utils/AxiosClient";
import { jwtDecode } from "jwt-decode";
const router = useRouter();

const AuthService = {
  register(user) {
    return axiosClient.post("/auth/register", user);
  },

  async login(credentials) {
    return axiosClient.post("/auth/login", credentials).then((response) => {
      localStorage.setItem("token", response.data.token);
      authState.isLogged = true;
      return response.data;
    });
  },

  logout() {
    localStorage.removeItem("token");
    authState.isLogged = false;
  },
  getCurrentToken() {
    const token = localStorage.getItem("token");
    if (token) {
      try {
        const decodedToken = jwtDecode(token);
        return decodedToken;
      } catch (error) {
        console.error("Invalid token", error);
        return null;
      }
    }
    return null;
  },
  submitLogout() {
    AuthService.logout();
    router.push({ name: "Login" });
  },
};

export default AuthService;
