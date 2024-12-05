import { reactive } from "vue";

const authState = reactive({
  isLogged: false,
  user: {},
});

export default authState;
