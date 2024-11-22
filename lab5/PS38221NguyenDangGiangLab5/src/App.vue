<template>
  <div class="container">
    <div class="row">
      <NavBar />
    </div>
    <div class="row">
      <RouterView />
    </div>
  </div>
</template>

<script setup>
import { RouterView } from "vue-router";
import NavBar from "./components/NavBar.vue";
</script>
