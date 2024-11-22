<template>
  <div class="col-lg-1 col-sm-3">
    <nav class="navbar">
      <div class="container-fluid">
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarToggleExternalContent"
          aria-controls="navbarToggleExternalContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
      </div>
    </nav>
    <div
      class="collapse text-dark"
      id="navbarToggleExternalContent"
      data-bs-theme="dark"
    >
      <ul class="nav nav-pills flex-column" id="myTab" role="tablist">
        <li class="nav-item" role="presentation">
          <button
            class="nav-link link-dark"
            id="comment-tab"
            data-bs-toggle="tab"
            data-bs-target="#comment-tab-pane"
            type="button"
            role="tab"
            aria-controls="comment-tab-pane"
            aria-selected="false"
          >
            <i class="fa-solid fa-home me-2"></i>Home
          </button>
        </li>
        <li class="nav-item" role="presentation">
          <button
            class="nav-link link-dark"
            id="profile-tab"
            data-bs-toggle="tab"
            data-bs-target="#profile-tab-pane"
            type="button"
            role="tab"
            aria-controls="profile-tab-pane"
            aria-selected="false"
          >
            <i class="fa-solid fa-user me-2"></i>Profile
          </button>
        </li>
        <li class="nav-item" role="presentation">
          <button
            class="nav-link link-dark"
            id="blogs-tab"
            data-bs-toggle="tab"
            data-bs-target="#blogs-tab-pane"
            type="button"
            role="tab"
            aria-controls="blogs-tab-pane"
            aria-selected="false"
          >
            <i class="fa-solid fa-pen-nib me-2"></i>Blogs
          </button>
        </li>

        <li class="nav-item dropdown">
          <a
            class="nav-link link-dark dropdown-toggle"
            href="#"
            role="button"
            data-bs-toggle="dropdown"
            aria-expanded="false"
          >
            <i class="fa-solid fa-user me-2"></i>Account
          </a>
          <ul class="dropdown-menu bg-dark text-light z-3">
            <li>
              <a
                id="accountDropdown"
                class="dropdown-item text-light"
                href="#"
                data-bs-toggle="modal"
                data-bs-target="#staticLogin"
                >Login</a
              >
            </li>
            <li>
              <a
                id="accountDropdown"
                class="dropdown-item text-light"
                href="#"
                data-bs-toggle="modal"
                data-bs-target="#staticRegister"
                >Register</a
              >
            </li>
            <li>
              <hr class="dropdown-divider bg-light" />
            </li>
            <li>
              <a id="accountDropdown" class="dropdown-item text-light" href="#"
                >Logout</a
              >
            </li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</template>
