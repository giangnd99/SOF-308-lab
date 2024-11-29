import axiosClient from "../utils/AxiosClient";

const UserService = {
  async getUserById(userId) {
    try {
      const response = await axiosClient.get(`/users/${userId}`);
      return response.data;
    } catch (error) {
      throw error;
    }
  },
  async getUserByEmail(email) {
    try {
      const response = await axiosClient.get(`/users/email/${email}`);
      return response.data;
    } catch (error) {
      throw error;
    }
  },
  async updateUser(userId, userData) {
    try {
      const response = await axiosClient.put(`/users/${userId}`, userData);
      return response.data;
    } catch (error) {
      throw error;
    }
  },

  async createAdminUser() {
    try {
      const response = await axiosClient.post("/users/create-admin");
      return response.data;
    } catch (error) {
      throw error;
    }
  },
};

export default UserService;
