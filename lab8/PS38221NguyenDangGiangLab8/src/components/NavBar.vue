<template>
  <nav class="navbar navbar-expand-lg py-2 position-relative">
    <div class="container-fluid d-flex align-items-center">
      <!-- Logo -->
      <div class="navbar-brand text-center mb-3">
        <a
          class="text-dark text-decoration-none fw-bold d-flex align-items-center"
          href="/"
        >
          <img
            src="../assets/images/cat--v3.png"
            alt="Logo"
            width="80"
            height="80"
            class="rounded-circle bg-light border border-5 border-light"
          />
          <span class="ms-3 fs-4">GiangND</span>
        </a>
      </div>

      <!-- Search bar -->
      <div class="w-100 d-flex justify-content-center">
        <form class="d-flex w-50 px-5 position-relative">
          <input
            class="form-control border-light bg-dark text-light shadow-sm px-4 py-2 rounded-start"
            type="search"
            placeholder="Search Threads..."
            aria-label="Search"
          />
          <button class="btn btn-outline-dark px-4 rounded-end" type="submit">
            <i class="fa-solid fa-magnifying-glass"></i>
          </button>
        </form>
      </div>
    </div>
  </nav>
</template>

<style scoped>
.navbar-brand:hover img {
  transform: scale(1.1);
  box-shadow: 0px 4px 15px rgba(255, 255, 255, 0.4);
}
</style>
