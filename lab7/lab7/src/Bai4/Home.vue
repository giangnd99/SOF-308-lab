<template>
    <div>
        <LoginComponent v-if="!isLoggedIn" @LoggedIn="handleLoginSuccess" />
        <CommentComponent v-else :email="loggedInUser" />
    </div>
</template>
  
  <script setup>
import { ref } from 'vue';
import LoginComponent from './Login.vue';
import CommentComponent from './Comment.vue';

const isLoggedIn = ref(false);
const loggedInUser = ref('');

function handleLoginSuccess(username) {
  loggedInUser.value = username;
  isLoggedIn.value = true;
}
  </script>
  