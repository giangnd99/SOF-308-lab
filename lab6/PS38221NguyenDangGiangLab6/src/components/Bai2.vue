<template>
  <div class="container">
    <h1 class="display-3">Nhập tháng của bạn</h1>
    <div class="mb-3">
      <input
        type="text"
        v-model="month"
        class="form-control"
        placeholder="Nhập tháng từ 1-12"
      />
      <h4 v-if="month < 1 || month > 12" class="text-danger">
        Vui lòng nhập tháng từ 1 đến 12!!!
      </h4>
      <h4 v-else-if="month >= 1 && month <= 3" class="text-success">
        Mùa xuân
      </h4>
      <h4 v-else-if="month <= 6" class="text-warning">Mùa hè</h4>
      <h4 v-else-if="month <= 9" class="text-secondary">Mùa thu</h4>
      <h4 v-else class="text-info">Mùa Đông</h4>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
const month = ref("1");
</script>
