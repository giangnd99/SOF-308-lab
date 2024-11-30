<template>
  <div class="col-sm-1">
    <nav class="navbar">
      <div class="container-fluid">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
          data-bs-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false"
          aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
      </div>
    </nav>
    <div class="collapse text-dark" id="navbarToggleExternalContent" data-bs-theme="dark">
      <ul class="nav nav-pills w-25 justify-content-center flex-column align-items-center m-0">
        <li class="nav-item">
          <router-link class="nav-link link-dark" to="/blogs">
            <i class="fa-solid fa-house fa-2x"></i>
          </router-link>
        </li>
        <li v-if="isLogged" class="nav-item">
          <router-link to="/profile" class="nav-link link-dark">
            <img :src="user.avatar" class="image-thumbnail rounded-circle" style="width: 50px; height: 50px;" alt="">
          </router-link>
        </li>
        <li v-else class="nav-item">
          <router-link to="/profile" class="nav-link link-dark">
            <i class="fa-solid fa-user fa-2x"></i>
          </router-link>
        </li>
        <li class="nav-item">
          <router-link to="/manage-blog" class="nav-link link-dark">
            <i class="fa-solid fa-pen-nib fa-2x"></i>
          </router-link>
        </li>
  
        <li v-if="!isLogged" class="nav-item dropdown">
          <a class="nav-link link-dark dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
            aria-expanded="false">
            <i class="fa-solid fa-user-circle fa-2x"></i>
          </a>
          <ul class="dropdown-menu bg-dark text-light z-3">
            <li>
              <router-link class="dropdown-item text-light" to="/login">
                Login
              </router-link>
            </li>
            <li>
              <router-link class="dropdown-item text-light" to="/register">
                Register
              </router-link>
            </li>
            <li>
              <hr class="dropdown-divider bg-light" />
            </li>
            <li>
              <router-link class="dropdown-item text-light" to="/logout">Logout</router-link>
            </li>
          </ul>
        </li>
        <li v-else class="nav-item">
          <router-link to="/logout" class="nav-link link-dark">
            <i class="fa-solid fa-right-from-bracket fa-2x"></i>
          </router-link>
  
        </li>
      </ul>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import UserService from '../services/UserService';
import AuthService from '../services/AuthService';
import authState from '../state/authState';

const user = ref({});
const isLogged = ref(false);
const loadUserCur = async () => {
  const token = AuthService.getCurrentToken();
  if (token) {
    const email = token.sub;
    isLogged.value = authState.isLogged;
    const user = await UserService.getUserByEmail(email);
    return user;

  }
  return null;
}

onMounted(async () => {
  const response = await loadUserCur();
  if (response) {
    user.value = response;
  }
})
</script>

<style scoped>
.nav-pills .nav-link {
  border-radius: 50%;
}

.nav-pills .nav-link:hover {
  background-color: #f0f0f0;
}

.nav-pills .nav-link i {
  color: #333;
}

.nav-pills .nav-link.active i {
  color: #007bff;
}

.dropdown-menu {
  min-width: 10rem;
}

.dropdown-menu a:hover {
  background-color: gray;
  color: #fff !important;
}
</style>
