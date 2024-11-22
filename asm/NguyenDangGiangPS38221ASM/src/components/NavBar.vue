<template>
  <nav class="navbar navbar-expand-lg bg-dark opacity-75" data-bs-theme="dark">
    <div class="container-fluid">
      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <div class="text-info mx-auto shadow-lg">
          <div class="nav-brand">
            <a class="navbar-brand text-light" href="/">
              <img
                src="../assets/images/cat--v3.png"
                alt="Logo"
                width="42"
                height="42"
                class="d-inline-block bg-light opacity-75 border border-1 rounded-5 border-light"
              />
              GiangND
            </a>
          </div>
        </div>
        <form class="d-flex" role="search">
          <input
            class="form-control me-3 border-light"
            type="search"
            placeholder="Search"
            aria-label="Search"
          />
          <button class="btn btn-outline-light" type="submit">Search</button>
        </form>
      </div>
    </div>
  </nav>
</template>
