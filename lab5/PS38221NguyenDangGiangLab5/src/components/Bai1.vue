<template>
  <div class="container">
    <span class="badge bg-dark" v-html="message"></span>
    <button
      type="button"
      class="btn btn-black btn-outline-dark"
      @click="updateMessage"
    >
      Button
    </button>
  </div>
</template>

<script setup>
import { ref } from "vue";
const message = ref("Thông điệp ban đầu");
const updateMessage = () => {
  message.value =
    message.value === "Thông điệp ban đầu"
      ? "Thông điệp đã được cập nhật"
      : "Thông điệp ban đầu";
};
</script>
