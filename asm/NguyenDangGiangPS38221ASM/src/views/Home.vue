<template>
  <!-- nav-bar-start-->
  <NavBar />
  <div class="mb-5">
    <!-- nav-bar end -->
    <!-- login-start -->
    <!-- Modal -->
    <Login />
    <!-- login end -->
    <!-- Register start -->
    <!-- Modal -->
    <Register />
    <!-- register-end -->
    <!-- nav-side start -->

    <div class="container-fluid">
      <div class="row">
        <NavSide />
        <div class="col border border-4 ms-3">
          <!-- content-start -->
          <div class="tab-content" id="v-pills-tabContent">
            <div
              class="tab-pane fade"
              id="profile-tab-pane"
              role="tabpanel"
              aria-labelledby="v-pills-profile-tab"
              tabindex="0"
            >
              <!-- profile-start -->
              <Profile />
              <!-- profile end -->
            </div>
            <!-- blog-manage-start -->
            <ManageBlog />
            <!-- blog-manage-end -->
            <!-- blogs and comment -->
            <BlogsAndComment />
            <!-- blogs-and-comment-end -->
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
import Profile from "../components/Profile.vue";
import ManageBlog from "../components/ManageBlog.vue";
import BlogsAndComment from "../components/BlogsAndComment.vue";
import Login from "./Login.vue";
import Register from "./Register.vue";
</script>
