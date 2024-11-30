<template>
    <div class="login-container d-flex justify-content-center align-item-center">
        <div class="login-content bg-light rounded-3 border border-light border-5 p-3 mt-5 shadow-lg">
            <div class="text-center mb-4">
                <h1 class="fs-4">Login</h1>
            </div>
            <form @submit.prevent="handleLogin">
                <div class="row mb-3">
                    <label for="inputEmail" class="col-sm-3 col-form-label">Email </label>
                    <div class="col-sm-8">
                        <input type="email" v-model="email" class="form-control" id="inputEmail"
                            placeholder="Enter your email" />
                    </div>
                    <p v-if="emailError" style="color: red">{{ emailError }}</p>
                </div>
                <div class="row mb-3">
                    <label for="inputPassword" class="col-sm-3 col-form-label">Mật khẩu
                    </label>
                    <div class="col-sm-8">
                        <input type="password" v-model="password" class="form-control" id="inputPassword"
                            placeholder="Enter your password" />
                    </div>
                    <p v-if="passwordError" style="color: red">{{ passwordError }}</p>
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

const email = ref("");
const password = ref("");
const emailError = ref("");
const passwordError = ref("");
const isLoading = ref(false);
const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

const emit = defineEmits(["loggedIn"]);

function handleLogin() {
  emailError.value = "";
  passwordError.value = "";

  if (!email.value) {
    emailError.value = "Email bắt buộc";
  } else if (!emailRegex.test(email.value)) {
    emailError.value = "Email không hợp lệ";
  }
  if (!password.value) {
    passwordError.value = "Mật khẩu là bắt buộc.";
  }

  if (!emailError.value && !passwordError.value) {
    emit('loggedIn', email.value);
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
  