import { createRouter, createWebHistory } from "vue-router";
import Login from "../views/Login.vue";
import Register from "../views/Register.vue";
import Profile from "../views/Profile.vue";
import Blog from "../views/Blog.vue";
import DaskBoard from "../views/ManageBlog.vue";
import Home from "../views/Home.vue";
import Logout from "../views/Logout.vue";
import authState from "../state/authState";

const routes = [
  { path: "/", component: Home, meta: { requiresAuth: true } },
  { path: "/login", component: Login, name: "Login" },
  { path: "/register", component: Register, name: "Register" },
  {
    path: "/blogs",
    component: Blog,
    name: "Blog",
    meta: { requiresAuth: true },
  },
  {
    path: "/profile",
    component: Profile,
    name: "Profile",
    alias: "/account",
    meta: { requiresAuth: true },
    children: [
      { path: "login", component: Login, name: "UserLogin" },
      { path: "register", component: Register, name: "UserRegister" },
    ],
  },
  {
    path: "/manage-blog",
    component: DaskBoard,
    name: "DaskBoard",
    meta: { requiresAuth: true },
  },
  { path: "/logout", component: Logout, name: "Logout" },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});
router.beforeEach((to, from, next) => {
  const isAuthenticated = authState.isLogged;
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
