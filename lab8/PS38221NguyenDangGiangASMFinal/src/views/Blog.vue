<template>
  <div v-for="(post, index) in posts" :key="index" class="mb-5 border rounded-3 p-3 container-sm w-50">
    <div id="blog1" class="mb-4">
      <div class="d-flex align-items-center">
        <img :src="post.user.avatar" class="image-thumbnail rounded-circle" style="width: 80px; height: 80px;" alt="User avatar" />
        <div>
          <h6 class="mb-0"></h6>
          <small class="text-muted fs-4 ms-3">{{post.user.name}}</small>
        </div>
      </div>
      <p class="mt-3" v-html="post.content"></p>
      <div class="border rounded">
        <div class="row d-flex justify-content-center  align-item-center">
          <img :src="post.image" class="img-thumbnail w-50"  alt="Post content" />
        </div>
        <div class="p-3">
          <div class="row">
            <div class="col-6">
              <button class="btn btn-outline-primary me-2">
                Comment <span class="badge bg-primary">{{post.comments.length}}</span>
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div>
      <Comments :comments="post.comments" :post="post" :user="user" @new-comment="addNewComment($event, index)" />
    </div>
  </div>
</template>

<script setup>
import Comments from "./Comments.vue";
import PostService from "../services/PostService";
import AuthService from "../services/AuthService";
import UserService from "../services/UserService";
import { onMounted, ref } from "vue";
const posts = ref([]);
const user = ref({});

onMounted(async () => {
  const response = await PostService.getAllPosts();
  const currentToken = AuthService.getCurrentToken();
  const emailUser = currentToken.sub;
  console.log(emailUser);

  user.value = await UserService.getUserByEmail(emailUser);
  console.log(user.value);
  posts.value = response.data;
  console.log(posts.value);
});

const addNewComment = (newComment, postIndex) => {
  const post = posts.value[postIndex];
  post.comments.push(newComment);
};
</script>
