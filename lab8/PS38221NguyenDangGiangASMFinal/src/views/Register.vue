<template>
  <div class="register-container d-flex justify-content-center align-item-center">
    <div class="register-content bg-light rounded-3 border border-light border-5 p-3 mt-5 shadow-lg">
      <div class="text-center mb-4">
        <h1 class="fs-4">Register</h1>
      </div>
      <form @submit.prevent="submitForm" class="row g-3">
        <div class="col-md-12">
          <label for="inputEmail4" class="form-label">Full name</label>
          <input v-model="formData.name" type="text" class="form-control" id="inputEmail4" placeholder="Enter your email"
            required />
        </div>
        <div class="col-md-6">
          <label for="inputEmail4" class="form-label">Email</label>
          <input v-model="formData.email" type="email" class="form-control" id="inputEmail4"
            placeholder="Enter your email" required />
        </div>
        <div class="col-md-6">
          <label for="inputPassword4" class="form-label">Password</label>
          <input v-model="formData.password" type="password" class="form-control" id="inputPassword4"
            placeholder="Enter your password" required />
        </div>
        <div class="col-12">
          <div class="row d-flex justify-content-between mt-3">
            <div class="col-sm-6 text-start">
              <button type="reset" class="btn btn-secondary">Clear</button>
            </div>
            <div class="col-sm-6 text-end">
              <button type="submit" class="btn btn-primary">Sign up</button>
            </div>
          </div>
        </div>
      </form>
    </div>
  </div>
</template>

<script setup>
import { reactive } from "vue";
import AuthService from "../services/AuthService";
import authState from "../state/authState";
import { useRouter } from "vue-router";

const formData = reactive({
  name: "",
  email: "",
  password: "",
  admin: false,
});
const router = useRouter();

const submitForm = async () => {
  try {
    const response = await AuthService.register(formData);
    alert("Registration successful:", response);
    const user = { email: formData.email, password: formData.password };
    await AuthService.login(user);
    authState.isLogged = true;
    router.push({ name: 'Profile' })
  } catch (error) {
    console.error("Registration failed:", error);
    alert("Register fail: " + error);
  }
};
</script>

<style scoped>
.register-content {
  width: 100%;
  max-width: 600px;
}
</style>
