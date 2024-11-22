<template>
  <div class="container">
    <form action="" method="post" class="row">
      <div class="mb-3">
        <label for="" class="form-label">Họ và tên: </label>
        <input
          type="text"
          v-model="user.name"
          class="form-control"
          placeholder="Nhập họ và tên"
        />
      </div>
      <div class="mb-3">
        <label for="" class="form-label">Tuổi: </label>
        <input
          type="text"
          v-model="user.age"
          class="form-control"
          placeholder="Nhập tuổi"
        />
      </div>
      <div class="mb-3">
        <label for="" class="form-label">Email:</label>
        <input
          type="email"
          v-model="user.email"
          class="form-control"
          placeholder="Nhập email của bạn"
        />
      </div>
    </form>
    <div class="row bg-black text-light">
      <h1 class="display-4">Thông tin đã nhập</h1>
      <h5>Họ và tên:</h5>
      <p v-html="user.name"></p>
      <h5>Tuổi:</h5>
      <p v-html="user.age"></p>
      <h5>Email:</h5>
      <p v-html="user.email"></p>
    </div>
  </div>
</template>

<script setup>
import { reactive } from "vue";
const user = reactive({
  name: "",
  age: null,
  email: "",
});
</script>
