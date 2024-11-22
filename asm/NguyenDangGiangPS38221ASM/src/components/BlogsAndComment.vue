<template>
  <div class="container my-5" >
    <div class="row p-5">
      <!-- Navigation Section -->
      <div class="col-2 ">
        <h5>Bài viết liên quan</h5>
        <nav
          id="simple-list-example"
          class="d-flex flex-column gap-2 text-center"
        >
          <a class="btn btn-outline-primary" href="#blog1">Blog Title 1</a>
          <a class="btn btn-outline-primary" href="#tips">Blog Title 1</a>
          <a class="btn btn-outline-primary" href="#comments">Blog Title 1</a>
        </nav>
      </div>

      <!-- Content Section -->
      <div class="col-10 p-5">
        <div
          data-bs-spy="scroll"
          data-bs-target="#simple-list-example"
          data-bs-offset="0"
          class="scrollspy-example"
          tabindex="0"
        >
          <!-- Blog Section -->
          <div id="blog1" class="mb-4">
            <div class="d-flex align-items-center">
              <img
                src="https://via.placeholder.com/50"
                class="rounded-circle me-3"
                alt="User avatar"
              />
              <div>
                <h6 class="mb-0">giang_nd</h6>
                <small class="text-muted">1 hours</small>
              </div>
            </div>
            <p class="mt-3">Lorem ipsum dolor sit amet.</p>
            <div class="border rounded">
              <div class="row">
                <img
                  src="https://via.placeholder.com/600x300"
                  class="img-fluid"
                  alt="Post content"
                />
              </div>
              <div class="p-3">
                <div class="row">
                  <div class="col-6">
                    <button class="btn btn-outline-primary me-2">
                      Like <span class="badge bg-primary">0</span>
                    </button>
                    <button class="btn btn-outline-secondary">Comment</button>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- Comments start -->
          <div id="comments">
            <h5 class="fw-bold">Comments</h5>
            <div class="card mb-3">
              <div class="card-body">
                <blockquote class="blockquote mb-0">
                  <p>Nguyen Van A</p>
                  <footer class="blockquote-footer">
                    Bài viết rất bổ ích Lorem ipsum dolor sit amet consectetur,
                    adipisicing elit.
                  </footer>
                </blockquote>
              </div>
            </div>
            <div class="card mb-3">
              <div class="card-body">
                <blockquote class="blockquote mb-0">
                  <p>Nguyen Van B</p>
                  <footer class="blockquote-footer">
                    Tôi thấy bài viết rất thú vị. Cảm ơn bạn!
                  </footer>
                </blockquote>
              </div>
            </div>
                 <!-- Comments end -->
            <!-- Add Comment start -->
            <div class="mb-3">
              <label for="comment" class="form-label fw-bold"
                >Write your comments:</label
              >
              <textarea
                id="comment"
                class="form-control mb-3"
                rows="3"
              ></textarea>
              <button class="btn btn-outline-primary">Send</button>
            </div>
               <!-- Add Comment end -->
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
