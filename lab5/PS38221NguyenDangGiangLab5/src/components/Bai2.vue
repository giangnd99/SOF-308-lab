<template>
  <div>
    <div class="mb-3">
      <input
        type="text"
        v-model="inputString"
        class="form-control"
        placeholder="Nhập dữ liệu vào đây"
      />
      <small
        id="helpId"
        class="form-text text-muted"
        v-html="inputString"
      ></small>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";

const inputString = ref("FPL");
</script>
