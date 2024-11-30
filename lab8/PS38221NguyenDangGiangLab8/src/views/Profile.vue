<template>
  <div v-if="authState.isLogged" class="row container-sm">
    <!-- Profile Card -->
    <div class="col-md-4">
      <div class="card shadow-sm border-0 mt-4">
        <div class="card-body text-center">
          <img :src="currentUser?currentUser.avatar:'../assets/images/ava.png'" alt="Profile Picture"
            class="rounded-circle border border-2 shadow mb-3" style="width: 120px; height: 120px" />
          <h5 class="card-title fw-bold mb-0">{{ currentUser.name }}</h5>
          <p class="text-muted mb-1">{{ currentUser.email }}</p>
        </div>
      </div>
    </div>
  
    <!-- Edit Profile -->
    <div class="col-md-8">
      <div class="card shadow-sm border-0 mt-4">
        <div class="card-header bg-secondary text-white fw-bold">
          Edit Profile
        </div>
        <div class="card-body">
          <form @submit.prevent="updateProfile">
            <div class="row g-3">
              <div class="col-md-6">
                <label for="id" class="form-label">ID</label>
                <input v-model="currentUser.id" type="text" id="id" class="form-control" readonly />
              </div>
              <div class="col-md-6">
                <label for="fullname" class="form-label">Full Name</label>
                <input v-model="currentUser.name" type="text" id="fullname" class="form-control"
                  placeholder="Enter your full name" />
              </div>
  
              <div class="col-md-6">
                <label for="email" class="form-label">Email Address</label>
                <input v-model="currentUser.email" type="email" id="email" class="form-control"
                  placeholder="Enter your email" />
              </div>
              <div class="col-md-6">
                <label for="password" class="form-label">Password</label>
                <input v-model="currentUser.password" type="password" id="password" class="form-control"
                  placeholder="Enter new password" />
              </div>
  
              <div class="col-md-6">
                <label for="avatar" class="form-label">Upload Avatar</label>
                <input v-model="currentUser.avatar" type="text" id="avatar" class="form-control" />
              </div>
            </div>
  
            <div class="text-end mt-4">
              <button type="submit" class="btn btn-success px-4">
                Save
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
  <div v-else>
    {{ submitLogout()}}
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import UserService from '../services/UserService';
import AuthService from '../services/AuthService';
import { useRouter } from 'vue-router';
import authState from '../state/authState';


const router = useRouter();
function submitLogout() {
  AuthService.logout()
  router.push({ name: 'Login' });
}
const currentUser = ref({});

const loadUser = async () => {
  try {
    const currentTokent = AuthService.getCurrentToken();
    if (!currentTokent) {
      alert('Your token is null, please login again!');
    }
    const email = currentTokent.sub;
    const user = await UserService.getUserByEmail(email);
    currentUser.value = user;
  } catch (err) {
    alert(err.message);
  }
};

const updateProfile = async () => {
  try {
    const currentTokent = AuthService.getCurrentToken();
    if (!currentTokent) {
      alert('Your token is null, please login again!');
      router.push('/login');
    }
    const id = currentUser.value.id;
    console.log('profile');
    console.log(currentUser.value);
    const response = await UserService.updateUser(id, currentUser.value);
    if (response) {
      alert('Profile updated successfully!');
    }
  } catch (err) {
    alert(err.message);
  }
};

onMounted(() => {
  loadUser();
});
</script>

<style scoped>
.card {
  border-radius: 12px;
}

.card-header {
  border-top-left-radius: 12px;
  border-top-right-radius: 12px;
}

.card-body img {
  transition: transform 0.3s ease;
}

.card-body img:hover {
  transform: scale(1.1);
}

.btn-primary {
  border-radius: 20px;
}

.text-muted i {
  color: #6c757d;
}

.form-control {
  border-radius: 10px;
}
</style>
