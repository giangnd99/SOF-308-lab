<template>
  <div class="container mt-5">
    <div class="row justify-content-center align-items-center">
      <div class="col">
        <h1 class="display-4 fw-bolder">Kiến thức sức khỏe cộng đồng</h1>
      </div>
    </div>
    <div class="row align-items-center">
      <div v-for="(item, index) in items" :key="index" class="col-4">
        <div class="card text-start p-0">
          <div class="card-body">
            <div class="ratio ratio-4x3">
              <img
                class="card-img-top"
                :src="item.img"
                alt="Title"
                style="width: 300px; height: 200px"
              />
            </div>
            <h4 class="card-title text-start">{{ item.title }}</h4>
            <p class="card-text text-start">{{ item.content }}</p>
            <button type="button" class="btn btn-info text-dark">
              Xem chi tiết
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script setup>
import img1 from "../assets/images/rau-cu.jpg";
import img2 from "../assets/images/gia-vi.jpg";
import img3 from "../assets/images/loai-dau.jpg";
const items = [
  {
    title: "8 loại rau củ giàu canxi",
    content:
      "Canxi là khoáng chất cần thiết đối với cơ thể người. Có nhiều cách để bổ sung canxi, trong đó bổ sung qua đường ăn uống là cách tốt nhất. Có 8 loại rau củ giàu canxi...",
    img: img1,
  },
  {
    title: "Các loại gia vị tốt cho sức khỏe",
    content:
      "Một số loại gia vị cung cấp nhều polyphenol chống oxy hóa cao hơn các loại gia vị quen thuộc khác. Với một lượng nhỏ các món ăn đã thêm hương thơm và vị hấp dẫn...",
    img: img2,
  },
  {
    title: "9 loại đậu bổ dưỡng dùng nhiều",
    content:
      "Đậu lăng, đậu nành, đậu phộng, đậu Hà Lan giàu chất xơ, protein cùng nhiều Vitamin và khoáng chất giúp giảm lượng đường trong máu, tốt hơn cho tim...",
    img: img3,
  },
];
</script>
<style scoped>
.card {
  width: 350px;
  height: 490px;
}
</style>
