<template>
  <div class="container">
    <form @submit.prevent="addListJob">
      <div class="row">
        <div class="col-md-12">
          <div class="mb-3">
            <label for="" class="form-label">Tên công vệc</label>
            <input
              v-model="todo"
              type="text"
              class="form-control"
              placeholder="Nhập tên công việc"
            />
          </div>
        </div>
      </div>
    </form>
    <div class="row">
      <div class="col-md-12">
        <button type="submit" class="btn btn-outline-primary">
          Thêm công việc
        </button>
      </div>
    </div>
    <div>
      <ul class="list-group mt-4">
        <li
          class="list-group-item d-flex justify-content-between align-item-center"
          v-for="(job, index) in jobs"
          :key="index"
        >
          {{ job }}
          <button class="btn btn-danger btn-sm" @click="removeJob(index)">
            Xóa
          </button>
        </li>
      </ul>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";

const jobs = ref(["Ăn sáng", "Đi học", "Chơi bóng rổ"]);
const todo = ref("");

const addListJob = () => {
  jobs.value.push(todo.value.trim());
  todo.value = "";
};

const removeJob = (index) => {
  jobs.value.splice(index, 1);
};
</script>
