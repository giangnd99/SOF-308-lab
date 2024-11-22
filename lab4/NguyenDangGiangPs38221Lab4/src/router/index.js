import { createRouter, createWebHistory } from "vue-router";
import App from "../App.vue";
import Hello from "../views/bai2.vue";
import Bai3 from "../views/bai3.vue";
import Bai4 from "../views/bai4.vue";

const routes = [
  { path: "/", component: App },
  { path: "/bai2", component: Hello },
  { path: "/bai3", component: Bai3 },
  { path: "/bai4", component: Bai4 },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
