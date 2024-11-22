<template>
  <div class="bg-light border border-1 border-dark rounded-4" id="app ">
    <h1
      class="text-center my-3 text-secondary bg-body fw-bolder border rounded-5"
    >
      Ứng dụng Blog nhỏ với Vue.js
    </h1>
    <CreatePost @add-post="addPost" />
    <PostList :posts="posts" />
  </div>
</template>

<script setup>
import { ref } from "vue";
import CreatePost from "./CreatePost.vue";
import PostList from "./PostList.vue";

const posts = ref([]);

function addPost(post) {
  posts.value.push(post);
}
</script>
<style>
#app {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}
</style>
