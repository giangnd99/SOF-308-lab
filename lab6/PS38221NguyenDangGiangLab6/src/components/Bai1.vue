<template>
  <div class="contaier">
    <div class="row m-5 p-5">
      <div class="col-4 mb-3">
        <label for="" class="form-label fs-4 fw-bolder mb-3"
          >Nhập điểm của bạn:
        </label>
        <input v-model="grade" type="text" class="form-control mb-5" />
        <h3 id="helpId" :class="gradeClass">{{ result }}</h3>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, computed } from "vue";

const grade = ref(0);
const result = computed(() => {
  if (grade.value >= 9 && grade.value <= 10) {
    return "Xuất sắc";
  } else if (grade.value >= 8.0 && grade.value < 9) {
    return "Giỏi";
  } else if (grade.value >= 6.5 && grade.value < 8.0) {
    return "Khá";
  } else if (grade.value >= 5.0 && grade.value < 6.5) {
    return "Trung bình";
  } else if (grade.value < 5.0 && grade.value >= 0) {
    return "Yếu";
  } else {
    return "Số điểm không hợp lệ";
  }
});
const gradeClass = computed(() => {
  switch (result.value) {
    case "Xuất sắc":
      return "text-warning";
    case "Giỏi":
    case "Khá":
      return "text-success";
    case "Trung bình":
      return "text-primary";
    case "Yếu":
      return "text-danger";
    default:
      return "text-info";
  }
});
</script>
