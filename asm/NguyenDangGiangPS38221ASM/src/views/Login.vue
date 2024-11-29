<template>
  <div class="login-container d-flex justify-content-center align-item-center">
    <div class="login-content bg-light rounded-3 border border-light border-5 p-3 mt-5 shadow-lg">
      <div class="text-center mb-4">
        <h1 class="fs-4">Login</h1>
      </div>
      <form @submit.prevent="handleLogin">
        <div class="row mb-3">
          <label for="inputEmail" class="col-sm-1 col-form-label">
            <i class="fa-solid fa-id-card"></i>
          </label>
          <div class="col-sm-9">
            <input type="email" v-model="email" class="form-control" id="inputEmail" placeholder="Enter your email" />
          </div>
        </div>
        <div class="row mb-3">
          <label for="inputPassword" class="col-sm-1 col-form-label">
            <i class="fa-solid fa-key"></i>
          </label>
          <div class="col-sm-9">
            <input type="password" v-model="password" class="form-control" id="inputPassword"
              placeholder="Enter your password" />
          </div>
        </div>
        <div class="row mb-3">
          <div class="col-sm-10 offset-sm-1">
            <div class="form-check">
              <input class="form-check-input" type="checkbox" id="gridCheck1" />
              <label class="form-check-label" for="gridCheck1">
                Remember me
              </label>
            </div>
          </div>
        </div>
        <div class="row mb-3">
          <div class="col-6">
            <a href="#" class="text-decoration-none link-success">Register new account</a>
          </div>
          <div class="col-6 text-end">
            <a href="#" class="text-decoration-none link-danger">Forgot password?</a>
          </div>
        </div>
        <div class="row">
          <div class="col-sm-6 text-start">
            <button type="submit" class="btn btn-primary" :disabled="isLoading">
              <span v-if="isLoading" class="spinner-border spinner-border-sm"></span>
              Sign in
            </button>
          </div>
          <div class="col-sm-6 text-end">
            <button type="reset" class="btn btn-secondary" @click="clearForm">
              Clear
            </button>
          </div>
        </div>
      </form>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import AuthService from "../services/AuthService";

const email = ref("");
const password = ref("");
const isLoading = ref(false);
const router = useRouter();

const handleLogin = async () => {
  try {
    isLoading.value = true;
    const credentials = { email: email.value, password: password.value };
    console.log(credentials);
    const response = await AuthService.login(credentials);
    console.log("Logged in successfully:", response);
    router.push("/blogs");
  } catch (error) {
    console.error("Login error:", error);
    alert("Login failed: " + error.message);
  } finally {
    isLoading.value = false;
  }
};

const clearForm = () => {
  email.value = "";
  password.value = "";
};
</script>

<style scoped>
.login-content {
  width: 100%;
  max-width: 500px;
}
</style>
