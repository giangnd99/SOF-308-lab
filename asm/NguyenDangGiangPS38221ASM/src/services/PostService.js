import axiosClient from "../utils/AxiosClient";

const PostService = {
  async getAllPosts() {
    try {
      return await axiosClient.get("/posts/");
    } catch (error) {
      throw error;
    }
  },

  async getPostById(postId) {
    try {
      const response = await axiosClient.get(`/posts/${postId}`);
      console.log(response.data);
      return response.data;
    } catch (error) {
      throw error;
    }
  },

  async createPost(postData) {
    try {
      const response = await axiosClient.post("/posts/", postData);
      return response.data;
    } catch (error) {
      throw error;
    }
  },

  async updatePost(postId, postData) {
    try {
      const response = await axiosClient.put(`/posts/${postId}`, postData);
      return response.data;
    } catch (error) {
      throw error;
    }
  },

  async deletePost(postId) {
    try {
      await axiosClient.delete(`/posts/${postId}`);
    } catch (error) {
      throw error;
    }
  },
};

export default PostService;
