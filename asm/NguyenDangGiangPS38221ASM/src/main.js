import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap";
import "./assets/fontawesome-free-6.6.0/css/all.min.css";

createApp(App).use(router).mount("#app");
