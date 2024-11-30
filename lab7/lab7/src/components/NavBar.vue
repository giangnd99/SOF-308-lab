<template>
  <ul class="nav justify-content-center">
    <li class="nav-item">
      <RouterLink class="nav-link" to="/">Bài 1</RouterLink>
    </li>
    <li class="nav-item">
      <RouterLink class="nav-link" to="/bai2"> Bài 2</RouterLink>
    </li>
    <li class="nav-item">
      <RouterLink class="nav-link" to="/bai3"> Bài 3</RouterLink>
    </li>
    <li class="nav-item">
      <RouterLink class="nav-link" to="/bai4"> Bài 4</RouterLink>
    </li>
  </ul>
</template>
<script setup>
import { RouterLink } from 'vue-router';
</script>