<template>
  <div class="row">
    <div class="col-sm-4">
      <form @submit.prevent="submitForm">
        <h3>Thêm học sinh</h3>
        <div class="mb-3">
          <label for="name" class="form-label">Họ tên: </label>
          <input
            id="name"
            type="text"
            v-model="student.name"
            class="form-control"
            placeholder="Nhập họ và tên"
          />
        </div>
        <div class="mb-3">
          <label for="score" class="form-label">Điểm: </label>
          <input
            type="text"
            v-model="student.score"
            class="form-control"
            id="score"
            placeholder="Nhập điểm từ 0-10"
          />
        </div>
        <div class="mb-3">
          <label for="date" class="form-label">Ngày sinh</label>
          <input
            type="date"
            v-model="student.date"
            class="form-control"
            id="date"
            placeholder="Nhập ngày sinh"
          />
        </div>
        <button type="submit" class="btn btn-success">
          {{ isEditing ? "Cập nhật" : "Thêm" }}
        </button>
      </form>
    </div>
    <div class="col-sm-8">
      <div class="table-responsive-sm">
        <h1>
          Danh sách học sinh
        </h1>
        <table
          class="table table-striped-columns table-hover table-borderless table-primary align-middle"
        >
          <thead class="table-light">
            <tr>
              <th>Họ và tên</th>
              <th>Điểm</th>
              <th>Ngày sinh</th>
              <th></th>
              <th></th>
            </tr>
          </thead>
          <tbody class="table-group-divider">
            <tr
              v-for="(student, index) in students"
              :key="index"
              class="table-primary"
            >
              <td scope="row" v-html="student.name"></td>
              <td v-html="student.score"></td>
              <td v-html="student.date"></td>
              <td>
                <button
                  type="button"
                  @click="editStudent(index)"
                  class="btn btn-warning"
                >
                  Sửa
                </button>
              </td>
              <td>
                <button
                  type="button"
                  @click="deleteStudent(index)"
                  class="btn btn-danger"
                >
                  Xóa
                </button>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";

const indexStudent = ref(null);
const isEditing = ref(false);
const student = ref({
  name: "",
  score: "",
  date: "",
});
const students = ref([
  { name: "Nguyễn Đằng Giang", score: 8, date: "1999-09-09" },
  { name: "Nguyễn Trí Tài", score: 8, date: "2002-09-09" },
]);

function submitForm() {
  if (isEditing.value) {
    students.value[indexStudent.value] = { ...student.value };
    isEditing.value = false;
    indexStudent.value = null;
  } else {
    students.value.push({ ...student.value });
  }
  resetForm();
}
function editStudent(index) {
  student.value = { ...students.value[index] };
  isEditing.value = true;
  indexStudent.value = index;
}

function deleteStudent(index) {
  students.value.splice(index, 1);
}
function resetForm() {
  student.value = {
    name: "",
    score: 0,
    date: "",
  };
}
</script>
