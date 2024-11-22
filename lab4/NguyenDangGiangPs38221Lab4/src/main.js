import { createApp } from "vue";
import router from "./router";
import App from "./App.vue";
import "bootstrap/dist/css/bootstrap.css";
import "bootstrap-vue/dist/bootstrap-vue.css";
import "./assets/fontawesome-free-6.6.0/css/all.min.css";
createApp(App).use(router).mount("#app");
