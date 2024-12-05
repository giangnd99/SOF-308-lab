<template>
  <div class="card-footer border border-1">
    <div class="card" v-for="comment in comments" :key="comment.id">
      <div class="card-body">
        <blockquote class="blockquote mb-0">
          <p>{{ comment.user.name }}</p>
          <footer class="blockquote-footer">
            {{ comment.content }}
            <cite title="Source title">
              <span class="text-muted float-right text-lowercase fs-6 mx-2">
                >{{ comment.createdDate }}
              </span>
            </cite>
          </footer>
        </blockquote>
      </div>
    </div>
    <div class="row g-0">
      <form @submit.prevent="SubmitComment">
        <div class="mb-3">
          <label for="commentBox" class="form-label text-dark fw-bolder">
            Write your comments:
          </label>
          <textarea id="commentBox" class="form-control mb-3" rows="3" v-model="commentText"></textarea>
          <button class="btn btn-outline-secondary">Send</button>
        </div>
      </form>
    </div>
  </div>
</template>
  
  <script setup>
import CommentService from "../services/CommentService";
import { ref, onMounted, watch } from "vue";

const comments = ref([]);
const commentText = ref("");
const error = ref("");
const emit = defineEmits(["new-comment"]);

const props = defineProps({
  comments: Array,
  post: Object,
  user: Object
});

const loadCommentByBlogId = async () => {
  try {
    console.log(props.post);
    const response = await CommentService.getCommentsByPostId(props.post.id);
    comments.value = response;
    console.log(comments.value);
  } catch (err) {
    error.value = "Failed to load comments: " + err.message;
  }
};

const SubmitComment = async () => {
  if (commentText.value.trim()) {
    const newComment = {
      user: props.user,
      content: commentText.value,
      createdDate: new Date().toLocaleString(),
      post: props.post,
    };
    try {
      console.log(newComment);
      comments.value.push(newComment);
      const savedComment = await CommentService.createComment(newComment);
      emit("new-comment", savedComment);
      commentText.value = "";
    } catch (err) {
      error.value = "Fail to create comment: " + err.message;
    }
  }
};

onMounted(loadCommentByBlogId);
watch(() => props.post.id, loadCommentByBlogId);
  </script>
  