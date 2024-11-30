import axiosClient from "../utils/AxiosClient";

const CommentService = {
  async getCommentsByPostId(postId) {
    try {
      const response = await axiosClient.get(`/comments/post/${postId}`);
      return response.data;
    } catch (error) {
      throw error;
    }
  },

  async createComment(commentData) {
    try {
      const response = await axiosClient.post("/comments/", commentData);
      return response.data;
    } catch (error) {
      throw error;
    }
  },
};

export default CommentService;
