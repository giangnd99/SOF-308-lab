<template>
  <div class="container">
    <nav>
      <div class="nav nav-tabs" id="nav-tab" role="tablist">
        <button class="nav-link active" id="nav-home-tab" data-bs-toggle="tab" data-bs-target="#nav-home" type="button"
          role="tab" aria-controls="nav-home" aria-selected="true">Write/Edit</button>
        <button class="nav-link" id="nav-contact-tab" data-bs-toggle="tab" data-bs-target="#nav-contact" type="button"
          role="tab" aria-controls="nav-contact" aria-selected="false">List blogs</button>
      </div>
    </nav>
  
    <div class="tab-content" id="nav-tabContent">
      <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab" tabindex="0">
        <form @submit.prevent="handleSubmit" class="mt-3">
          <div class="card">
            <div class="card-header">
              <label for="blogImage" class="form-label">Blog's image</label>
            </div>
            <img :src="newBlog.image || placeholderImage" class="card-img-top rounded mx-auto img-thumbnail" alt=""
              style="width: 300px; height: 300px" />
            <div class="card-body">
              <input type="text" class="form-control" v-model="newBlog.image" id="blogImage" placeholder="Image URL" />
              <small id="helpId" class="form-text text-muted">Load URL image for the blog</small>
            </div>
          </div>
  
          <div class="mb-3">
            <label for="blogTitle" class="form-label">Title</label>
            <input type="text" class="form-control" v-model="newBlog.title" id="blogTitle" />
          </div>
  
          <div class="mb-3">
            <label for="content" class="form-label">Content</label>
            <textarea class="form-control" v-model="newBlog.content" id="content" rows="20"></textarea>
          </div>
  
          <div class="mb-3 d-flex">
            <button v-if="!editMode" type="submit" class="btn btn-primary me-3">Write</button>
            <button v-if="editMode" type="button" class="btn btn-success me-3" @click="handleUpdate">Update</button>
            <button v-if="editMode" type="button" class="btn btn-danger me-3" @click="handleDelete">Delete</button>
            <button type="button" class="btn btn-secondary" @click="closeForm">Cancel</button>
          </div>
        </form>
      </div>
  
      <!-- List Blogs -->
      <div class="tab-pane fade" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab" tabindex="0">
        <table class="table table-hover">
          <thead class="table-dark">
            <tr>
              <th scope="col">#</th>
              <th scope="col">Title</th>
              <th scope="col">Summary</th>
              <th scope="col">Blogger</th>
              <th scope="col">Action</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(blog, index) in blogs" :key="index">
              <th scope="row">{{ index + 1 }}</th>
              <td>{{ blog.title }}</td>
              <td>{{ blog.content.slice(0, 100) }}...</td>
              <td>{{ blog.user?.name || 'Anonymous' }}</td>
              <td>
                <button class="btn btn-sm btn-info me-2" @click="editBlog(blog)">Edit</button>
                <button class="btn btn-sm btn-danger" @click="deleteBlog(blog)">Delete</button>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import PostService from '../services/PostService';
import AuthService from '../services/AuthService';
import UserService from '../services/UserService';
import { useRouter } from 'vue-router';

const router = useRouter();
const blogs = ref([]);
const newBlog = ref({ title: '', image: '', content: '', user: {} });
const editMode = ref(false);
const placeholderImage = 'https://via.placeholder.com/300';
const editingBlog = ref(null);

const loadBlogs = async () => {
  try {
    const response = await PostService.getAllPosts();
    blogs.value = response.data;

  } catch (error) {
    console.error('Error fetching blogs:', error);
  }
};

const handleSubmit = async () => {
  const currentToken = AuthService.getCurrentToken();
  if (!currentToken) {
    alert('Please login to create a blog');
    router.push("/login");
  }
  const emailUser = currentToken.sub;
  newBlog.value.user = await UserService.getUserByEmail(emailUser);
  console.log(newBlog.value);
  const blogData = { ...newBlog.value };

  if (!editMode.value) {
    try {
      const response = await PostService.createPost(blogData);
      blogs.value.push(response);
      resetForm();
    } catch (error) {
      console.error('Error creating blog:', error);
    }
  }
};

const editBlog = (blog) => {
  editingBlog.value = blog;
  newBlog.value = { ...blog };
  editMode.value = true;
};

const handleUpdate = async () => {
  try {
    const updatedBlog = await PostService.updatePost(editingBlog.value.id, newBlog.value);
    const index = blogs.value.findIndex((b) => b.id === editingBlog.value.id);
    blogs.value[index] = updatedBlog;
    resetForm();
  } catch (error) {
    console.error('Error updating blog:', error);
  }
};

const deleteBlog = async (blog) => {
  try {
    await PostService.deletePost(blog.id);
    blogs.value = blogs.value.filter((b) => b.id !== blog.id);
  } catch (error) {
    console.error('Error deleting blog:', error);
  }
};

const closeForm = () => {
  resetForm();
};

const resetForm = () => {
  newBlog.value = { title: '', image: '', content: '' };
  editMode.value = false;
  editingBlog.value = null;
};

onMounted(() => {
  loadBlogs();
});
</script>

