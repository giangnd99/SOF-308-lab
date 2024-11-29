import { createRouter, createWebHistory } from "vue-router";
import Login from "../views/Login.vue";
import Register from "../views/Register.vue";
import Profile from "../views/Profile.vue";
import Blog from "../views/Blog.vue";
import ManageBlog from "../views/ManageBlog.vue";
import Home from "../views/Home.vue";
import Logout from "../views/Logout.vue";
Logout;

const routes = [
  { path: "/", component: Home },
  { path: "/login", component: Login, name: "Login" },
  { path: "/register", component: Register, name: "Register" },
  { path: "/blogs", component: Blog, name: "Blog" },
  { path: "/profile", component: Profile, name: "Profile" },
  { path: "/manage-blog", component: ManageBlog, name: "ManageBlog" },
  { path: "/logout", component: Logout, name: "Logout" },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});
router.beforeEach((to, from, next) => {
  const isAuthenticated = localStorage.getItem("token") != null;
  if (
    to.matched.some((record) => record.meta.requiresAuth) &&
    !isAuthenticated
  ) {
    next({ name: "Login" });
  } else {
    next();
  }
});

export default router;
