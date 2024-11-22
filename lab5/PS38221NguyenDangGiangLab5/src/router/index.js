import { createMemoryHistory, createRouter } from "vue-router";
import Bai4 from "../Bai4/HomePage.vue";
import Bai1 from "../components/Bai1.vue";
import Bai2 from "../components/Bai2.vue";
import Bai3 from "../components/Bai3.vue";

const routes = [
  { path: "/", component: Bai1 },
  { path: "/bai2", component: Bai2 },
  { path: "/bai3", component: Bai3 },
  { path: "/bai4", component: Bai4 },
];

const router = createRouter({
  history: createMemoryHistory(),
  routes,
});

export default router;
