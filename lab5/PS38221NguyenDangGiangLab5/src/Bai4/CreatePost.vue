<template>
  <div class="container">
    <div class="row">
      <h3>Tạo bài viết mới</h3>
      <div class="col-8">
        <div class="mb-3">
          <label for="" class="form-label">Tiêu đề bài viết</label>
          <input
            type="text"
            v-model="title"
            class="form-control"
            placeholder="Nhập tiêu đề bài viết"
          />
        </div>
      </div>
      <div class="col-4">
        <div class="mb-3">
          <label for="" class="form-label">Tên tác giả</label>
          <input
            type="text"
            v-model="author"
            class="form-control"
            placeholder="Nhập tên tác giả"
          />
        </div>
      </div>
    </div>
    <div class="row">
      <div class="mb-3">
        <label for="" class="form-label">Nội dung bài viết</label>
        <textarea class="form-control" v-model="content" rows="3"></textarea>
      </div>
    </div>
    <div class="row">
      <button
        type="button"
        @click="submitPost"
        class="btn btn-primary btn-outline-black"
      >
        Đăng bài
      </button>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";

const emit = defineEmits(["add-post"]);

const title = ref();
const author = ref();
const content = ref();

function submitPost() {
  var checkValue = title.value && content.value && author.value;
  if (checkValue) {
    const newPost = {
      title: title.value,
      author: author.value,
      content: content.value,
    };
    emit("add-post", newPost);
    resetValues();
  }
}

function resetValues() {
  title.value = "";
  author.value = "";
  content.value = "";
}
</script>
