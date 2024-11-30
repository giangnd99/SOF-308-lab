<template>
    <div class="container d-flex justify-content-center text-align-center">
        <div class="col-sm-4 m-5">
            <h2>Bình luận bài viết</h2>
            <div class="card">
                <img src="https://giadinh.mediacdn.vn/zoom/740_463/2017/phanbietraucuqua-1499228262649.jpg"
                    alt="Hình ảnh" />
                <div class="card-body">
                    <h3 class="card-title">8 loại rau củ quả giàu canxi</h3>
                    <p class="card-text">
                        Canxi là khoáng chất cần thiết đối với cơ thể người. Có nhiều cách để bổ sung
                        canxi, trong đó bổ sung qua đường ăn uống là cách tốt nhất. Có 8 loại rau củ
                        giàu canxi...
                    </p>
                </div>
            </div>
    
            <form @submit.prevent="submitComment">
                <div class="mt-3">
                    <textarea id="commentText" cols="60" v-model="data.commentText"
                        placeholder="Nhập bình luận của bạn"></textarea>
                </div>
                <button type="submit" class="btn btn-success">Gửi bình luận</button>
            </form>
            <div v-if="data.comments.length" class="mt-3">
                <h5>Danh sách các bình luận:</h5>
                <ul style="list-style-type: circle;">
                    <li v-for="(comment, index) in data.comments" :key="index">
                        <p>
                            <strong>{{ comment.name }}</strong>: {{ comment.text }}
                        </p>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</template>
<script setup>
import { reactive } from "vue";
const props = defineProps(['email']);

const data = reactive({
  commentText: "",
  comments: []
});

const submitComment = () => {
  if (data.commentText.trim() !== "") {
    data.comments.push({
      name: props.email,
      text: data.commentText.trim()
    });
    data.commentText = "";
  };
}
</script>
  