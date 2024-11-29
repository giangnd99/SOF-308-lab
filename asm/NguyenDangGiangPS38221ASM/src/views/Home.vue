<template>
  <!-- nav-bar-start-->
  <NavBar />
  <div class="mb-5">
    <div class="container-fluid">
      <div class="row">
        <NavSide />
        <div class="col border border-4 border-bottom-0 border-top-0">
          <!-- content-start -->
          <div class="content">
            <RouterView />
          </div>
          <!-- content-end -->
        </div>
      </div>
    </div>
  </div>
  <!-- nav-side end -->
  <Footer/>
</template>

<script setup>
import NavBar from "../components/NavBar.vue";
import Footer from "../components/Footer.vue";
import NavSide from "../components/NavSide.vue";
import { RouterView } from "vue-router";

</script>
