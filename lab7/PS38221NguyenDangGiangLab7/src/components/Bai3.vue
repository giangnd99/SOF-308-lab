<template>
    <div class="container">
        <div class="row justify-content-between align-item-center d-flex">
            <div class="col-sm-6 bg-light rounded-3 border border-light border-5 p-3 mt-5 shadow-lg">
                <div class="text-center mb-4">
                    <h1 class="fs-4">Register</h1>
                </div>
                <form @submit.prevent="submitForm" class="row g-3">
                    <div class="col-md-12">
                        <label for="inputEmail4" class="form-label">Họ tên</label>
                        <input v-model="formData.name" type="text" class="form-control" id="inputEmail4"
                            placeholder="Enter your email" required />
                    </div>
                    <div class="col-md-6">
                        <label for="inputEmail4" class="form-label">Email</label>
                        <input v-model="formData.email" type="email" class="form-control" id="inputEmail4"
                            placeholder="Enter your email" required />
                    </div>
                    <div class="col-md-6">
                        <label for="inputPassword4" class="form-label">Mật khẩu</label>
                        <input v-model="formData.password" type="password" class="form-control" id="inputPassword4"
                            placeholder="Enter your password" required />
                    </div>
                    <div class="col-md-6">
                        <label for="inputPassword4" class="form-label">Ngày sinh</label>
                        <input v-model="formData.date" type="date" class="form-control" id="inputPassword4" required />
                    </div>
                    <div class="col-md-6">
                        <label for="inputGender" class="form-label">Giới tính</label>
                        <div class="form-check form-check-inline">
                            <input v-model="formData.gender" class="form-check-input" type="radio" name="gender"
                                value="Nam" />
                            <label class="form-check-label" for="">Nam</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input v-model="formData.gender" class="form-check-input" type="radio" name="gender"
                                value="Nữ" />
                            <label class="form-check-label" for="">Nữ</label>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <label for="inputPassword4" class="form-label">Ngôn ngữ</label>
                        <div class="list-group">
                            <label class="list-group-item">
                                <input v-model="formData.language" class="form-check-input me-1" type="checkbox"
                                    value="Tiếng Việt" />
                                Tiếng Việt
                            </label>
                            <label class="list-group-item">
                                <input v-model="formData.language" class="form-check-input me-1" type="checkbox"
                                    value="Tiếng Anh" />
                                Tiếng Anh
                            </label>
                            <label class="list-group-item">
                                <input v-model="formData.language" class="form-check-input me-1" type="checkbox"
                                    value="Tiếng Nhật" />
                                Tiếng Nhật
                            </label>
                        </div>
                    </div>
                    <div class="col-12">
                        <div class="row d-flex justify-content-between mt-3">
                            <div class="col-sm-6 text-start">
                                <button type="reset" @click="resetForm" class="btn btn-secondary">Xóa</button>
                            </div>
                            <div class="col-sm-6 text-end">
                                <button type="submit" class="btn btn-primary">Đăng ký</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-sm-6 register-content bg-light rounded-3 border border-light border-5 p-3 mt-5 shadow-lg">
                <div class="text-center mb-4">
                    <h1 class="fs-4">Thông tin đăng ký</h1>
                </div>
                <!-- Some borders are removed -->
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">
                        <h3>Họ tên:</h3>
                        {{formData.name}}
                    </li>
                    <li class="list-group-item">
                        <h3>Email:</h3>
                        {{formData.email}}
                    </li>
                    <li class="list-group-item">
                        <h3>Ngày sinh:</h3>
                        {{formData.date}}
                    </li>
                    <li class="list-group-item">
                        <h3>Giới tính:</h3>
                        {{formData.gender}}
                    </li>
                    <li class="list-group-item">
                        <h3>Ngôn ngữ:</h3>
                        {{formData.language.join(', ')}}
                    </li>
                </ul>
            </div>
        </div>
    </div>
</template>

<script setup>
import { reactive } from "vue";
const formData = reactive({
  name: "",
  email: "",
  password: "",
  date: '',
  gender: "",
  language: [],
});
const submitForm = () => {
  if (!formData.name.trim()) {
    alert("Vui lòng nhập họ tên!");
    return;
  }

  if (!formData.email.trim() || !formData.email.includes("@")) {
    alert("Vui lòng nhập email hợp lệ!");
    return;
  }

  if (!formData.password.trim() || formData.password.length < 6) {
    alert("Mật khẩu phải có ít nhất 6 ký tự!");
    return;
  }

  if (!formData.date.trim()) {
    alert("Vui lòng chọn ngày sinh!");
    return;
  }

  if (!formData.gender.trim()) {
    alert("Vui lòng chọn giới tính!");
    return;
  }

  if (formData.language.length === 0) {
    alert("Vui lòng chọn ít nhất một ngôn ngữ!");
    return;
  }
  resetForm();
};

const resetForm = () => {
  formData.name = "";
  formData.email = "";
  formData.password = "";
  formData.date = "";
  formData.gender = "";
  formData.language = [];
};

</script>
