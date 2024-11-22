import { createRouter, createWebHistory } from "vue-router";
import Home from "../src/components/views/Home.vue";
// import Login from "../views/Login.vue";
// import Register from "../views/Register.vue";
// import Dashboard from "../views/Dashboard.vue";
// import Profile from "../views/Profile.vue";
// import AddPost from "../views/AddPost.vue";
// import Post from "../views/Post.vue";
// import EditPost from "../views/EditPost.vue";
// import EditProfile from "../views/EditProfile.vue";
// import AddComment from "../views/AddComment.vue";
// import AddLike from "../views/AddLike.vue";
// import AddDislike from "../views/AddDislike.vue";
// import AddReport from "../views/AddReport.vue";

const routes = [
  {path:'/' , compenent: Home},
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router
