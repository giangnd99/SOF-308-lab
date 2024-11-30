<template>
  <div class="container-sm">
    <h1>Bai bai</h1>
  </div>
</template>

<script setup>
import AuthService from '../services/AuthService';
import UserService from '../services/UserService';
import { useRouter } from 'vue-router';
import { ref, onMounted } from 'vue';

const router = useRouter();
const user = ref({});

function submitLogout() {
  AuthService.logout()
  router.push({ name: 'Login' });
}
const userCur = async () => {
  const response = AuthService.getCurrentToken();
  const email = response.sub;
  const userCur = await UserService.getUserByEmail(email);
  return userCur;
}
onMounted(async () => {
  const response = await userCur();
  if (response) {
    user.value = user;
    submitLogout();
  }
})
</script>