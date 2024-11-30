import { createRouter, createWebHistory } from "vue-router";
import Bai1 from "../components/Bai1.vue";
import Bai2 from "../components/Bai2.vue";
import Bai3 from "../components/Bai3.vue";
import Bai4 from "../Bai4/Home.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "home",
      component: Bai1,
    },
    {
      path: "/bai2",
      name: "2",
      component: Bai2,
    },
    {
      path: "/bai3",
      name: "3",
      component: Bai3,
    },
    {
      path: "/bai4",
      name: "4",
      component: Bai4,
    },
  ],
});

export default router;
