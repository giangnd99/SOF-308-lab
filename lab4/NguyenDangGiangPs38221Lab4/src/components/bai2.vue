<template>
  <h1 v-bind:class="className" v-bind:style="style" v-html="content"></h1>
</template>
<script>
export default {
  data() {
    return {
      content: "Chào mừng đến với VuJS",
      className: "text-red",
      style: "font-size: 5 rem",
    };
  },
};
</script>
<style scoped>
.text-red {
  color: red;
}
</style>
