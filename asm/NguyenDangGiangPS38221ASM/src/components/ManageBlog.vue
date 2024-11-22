<template>
  <div
    class="tab-pane fade"
    id="blogs-tab-pane"
    role="tabpanel"
    aria-labelledby="v-pills-disabled-tab"
    tabindex="0"
  >
    <nav>
      <div class="nav nav-tabs" id="nav-tab" role="tablist">
        <button
          class="nav-link active"
          id="nav-home-tab"
          data-bs-toggle="tab"
          data-bs-target="#nav-home"
          type="button"
          role="tab"
          aria-controls="nav-home"
          aria-selected="true"
        >
          Write
        </button>
        <button
          class="nav-link"
          id="nav-contact-tab"
          data-bs-toggle="tab"
          data-bs-target="#nav-contact"
          type="button"
          role="tab"
          aria-controls="nav-contact"
          aria-selected="false"
        >
          List blogs
        </button>
      </div>
    </nav>
    <!-- write-start -->

    <div class="tab-content" id="nav-tabContent">
      <div
        class="tab-pane fade show active"
        id="nav-home"
        role="tabpanel"
        aria-labelledby="nav-home-tab"
        tabindex="0"
      >
        <form class="mt-3">
          <div class="card">
            <div class="card-header">
              <label for="image" class="form-label">Blog's image</label>
            </div>
            <img
              src="https://thptphanthiet.edu.vn/$qtc_Content/uploads/2022/02/khai-niem-cong-nghe-thong-tin-1.jpg"
              class="card-img-top rounded mx-auto img-thumbnail"
              alt=""
              style="width: 300px; height: 300px"
            />
            <div class="card-body">
              <input
                type="file"
                class="form-control"
                name="image"
                id=""
                aria-describedby="helpId"
                placeholder=""
              />
              <small id="helpId" class="form-text text-muted"
                >Load file image blog</small
              >
            </div>
          </div>
          <div
            class="mb-3 border border-2 rounded-3 d-flex justify-content-center"
          ></div>
          <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Title</label>
            <input
              type="email"
              class="form-control"
              id="exampleInputEmail1"
              aria-describedby="emailHelp"
            />
            <div id="emailHelp" class="form-text">
              We'll never share your email with anyone else.
            </div>
          </div>
          <div class="mb-3">
            <label for="content" class="form-label">Content</label>
            <textarea
              class="form-control"
              name="content"
              id=""
              rows="20"
            ></textarea>
          </div>
          <div class="mb-3 d-flex">
            <button type="submit" class="btn btn-primary me-3">Write</button>
            <button type="submit" class="btn btn-danger me-3">Close</button>
          </div>
        </form>
      </div>
      <!-- write-end -->
      <!-- ListBlog-start -->

      <div
        class="tab-pane fade"
        id="nav-contact"
        role="tabpanel"
        aria-labelledby="nav-contact-tab"
        tabindex="0"
      >
        <div class="tab-content" id="pills-tabContent">
          <div
            class="tab-pane fade show active"
            id="pills-home"
            role="tabpanel"
            aria-labelledby="pills-home-tab"
            tabindex="0"
          >
            <table class="table table-hover">
              <thead class="table-dark">
                <tr>
                  <th scope="col">#</th>
                  <th scope="col">Title</th>
                  <th scope="col">Summary</th>
                  <th scope="col">Blogger</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <th scope="row">1</th>
                  <td>Title blog 1</td>
                  <td>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit.
                    Voluptates, doloribus!
                  </td>
                  <td>@mdo</td>
                </tr>
                <tr>
                  <th scope="row">2</th>
                  <td>Title blog 2</td>
                  <td>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit.
                    Debitis, ullam.
                  </td>
                  <td>@fat</td>
                </tr>
                <tr>
                  <th scope="row">3</th>
                  <td>Title blog 3</td>
                  <td>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit.
                    Harum, ad!
                  </td>
                  <td>@twitter</td>
                </tr>
                <tr>
                  <th scope="row">4</th>
                  <td>Title blog 5</td>
                  <td>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit.
                    Harum, ad!
                  </td>
                  <td>@twitter</td>
                </tr>
                <tr>
                  <th scope="row">5</th>
                  <td>Title blog 6</td>
                  <td>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit.
                    Harum, ad!
                  </td>
                  <td>@twitter</td>
                </tr>
                <tr>
                  <th scope="row">6</th>
                  <td>Title blog 6</td>
                  <td>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit.
                    Harum, ad!
                  </td>
                  <td>@twitter</td>
                </tr>
                <tr>
                  <th scope="row">7</th>
                  <td>Title blog 7</td>
                  <td>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit.
                    Harum, ad!
                  </td>
                  <td>@twitter</td>
                </tr>
                <tr>
                  <th scope="row">8</th>
                  <td>Title blog 8</td>
                  <td>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit.
                    Harum, ad!
                  </td>
                  <td>@twitter</td>
                </tr>
                <tr>
                  <th scope="row">9</th>
                  <td>Title blog 9</td>
                  <td>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit.
                    Harum, ad!
                  </td>
                  <td>@twitter</td>
                </tr>
                <tr>
                  <th scope="row">10</th>
                  <td>Title blog 10</td>
                  <td>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit.
                    Harum, ad!
                  </td>
                  <td>@twitter</td>
                </tr>
              </tbody>
            </table>
          </div>
          <div
            class="tab-pane fade"
            id="pills-profile"
            role="tabpanel"
            aria-labelledby="pills-profile-tab"
            tabindex="0"
          >
            <table class="table table-hover">
              <thead class="table-dark">
                <tr>
                  <th scope="col">#</th>
                  <th scope="col">Title</th>
                  <th scope="col">Summary</th>
                  <th scope="col">Blogger</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <th scope="row">11</th>
                  <td>Title blog 11</td>
                  <td>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit.
                    Voluptates, doloribus!
                  </td>
                  <td>@mdo</td>
                </tr>
                <tr>
                  <th scope="row">12</th>
                  <td>Title blog 12</td>
                  <td>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit.
                    Debitis, ullam.
                  </td>
                  <td>@fat</td>
                </tr>
                <tr>
                  <th scope="row">13</th>
                  <td>Title blog 13</td>
                  <td>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit.
                    Harum, ad!
                  </td>
                  <td>@twitter</td>
                </tr>
                <tr>
                  <th scope="row">14</th>
                  <td>Title blog 14</td>
                  <td>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit.
                    Harum, ad!
                  </td>
                  <td>@twitter</td>
                </tr>
                <tr>
                  <th scope="row">15</th>
                  <td>Title blog 15</td>
                  <td>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit.
                    Harum, ad!
                  </td>
                  <td>@twitter</td>
                </tr>
                <tr>
                  <th scope="row">16</th>
                  <td>Title blog 16</td>
                  <td>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit.
                    Harum, ad!
                  </td>
                  <td>@twitter</td>
                </tr>
                <tr>
                  <th scope="row">17</th>
                  <td>Title blog 17</td>
                  <td>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit.
                    Harum, ad!
                  </td>
                  <td>@twitter</td>
                </tr>
                <tr>
                  <th scope="row">18</th>
                  <td>Title blog 18</td>
                  <td>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit.
                    Harum, ad!
                  </td>
                  <td>@twitter</td>
                </tr>
                <tr>
                  <th scope="row">19</th>
                  <td>Title blog 19</td>
                  <td>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit.
                    Harum, ad!
                  </td>
                  <td>@twitter</td>
                </tr>
                <tr>
                  <th scope="row">20</th>
                  <td>Title blog 20</td>
                  <td>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit.
                    Harum, ad!
                  </td>
                  <td>@twitter</td>
                </tr>
              </tbody>
            </table>
          </div>
          <div
            class="tab-pane fade"
            id="pills-contact"
            role="tabpanel"
            aria-labelledby="pills-contact-tab"
            tabindex="0"
          >
            <table class="table table-hover">
              <thead class="table-dark">
                <tr>
                  <th scope="col">#</th>
                  <th scope="col">Title</th>
                  <th scope="col">Summary</th>
                  <th scope="col">Blogger</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <th scope="row">21</th>
                  <td>Title blog 21</td>
                  <td>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit.
                    Voluptates, doloribus!
                  </td>
                  <td>@mdo</td>
                </tr>
                <tr>
                  <th scope="row">22</th>
                  <td>Title blog 22</td>
                  <td>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit.
                    Debitis, ullam.
                  </td>
                  <td>@fat</td>
                </tr>
                <tr>
                  <th scope="row">23</th>
                  <td>Title blog 23</td>
                  <td>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit.
                    Harum, ad!
                  </td>
                  <td>@twitter</td>
                </tr>
                <tr>
                  <th scope="row">24</th>
                  <td>Title blog 24</td>
                  <td>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit.
                    Harum, ad!
                  </td>
                  <td>@twitter</td>
                </tr>
                <tr>
                  <th scope="row">25</th>
                  <td>Title blog 25</td>
                  <td>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit.
                    Harum, ad!
                  </td>
                  <td>@twitter</td>
                </tr>
                <tr>
                  <th scope="row">26</th>
                  <td>Title blog 26</td>
                  <td>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit.
                    Harum, ad!
                  </td>
                  <td>@twitter</td>
                </tr>
                <tr>
                  <th scope="row">27</th>
                  <td>Title blog 27</td>
                  <td>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit.
                    Harum, ad!
                  </td>
                  <td>@twitter</td>
                </tr>
                <tr>
                  <th scope="row">28</th>
                  <td>Title blog 28</td>
                  <td>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit.
                    Harum, ad!
                  </td>
                  <td>@twitter</td>
                </tr>
                <tr>
                  <th scope="row">29</th>
                  <td>Title blog 29</td>
                  <td>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit.
                    Harum, ad!
                  </td>
                  <td>@twitter</td>
                </tr>
                <tr>
                  <th scope="row">30</th>
                  <td>Title blog 30</td>
                  <td>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit.
                    Harum, ad!
                  </td>
                  <td>@twitter</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
        <nav aria-label="Page navigation example">
          <ul class="nav nav-pills pagination" id="pills-tab" role="tablist">
            <li class="page-item nav-item" role="presentation">
              <a class="page-link" href="#" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
              </a>
            </li>
            <li class="page-item" role="presentation">
              <a
                class="page-link"
                href="#"
                id="pills-home-tab"
                data-bs-toggle="pill"
                data-bs-target="#pills-home"
                role="tab"
                aria-controls="pills-home"
                aria-selected="true"
                >1</a
              >
            </li>
            <li class="page-item" role="presentation">
              <a
                class="page-link"
                href="#"
                id="pills-profile-tab"
                data-bs-toggle="pill"
                data-bs-target="#pills-profile"
                role="tab"
                aria-controls="pills-profile"
                aria-selected="false"
                >2</a
              >
            </li>
            <li class="page-item" role="presentation">
              <a
                class="page-link"
                href="#"
                id="pills-contact-tab"
                data-bs-toggle="pill"
                data-bs-target="#pills-contact"
                role="tab"
                aria-controls="pills-contact"
                aria-selected="false"
                >3</a
              >
            </li>
            <li class="page-item">
              <a class="page-link" href="#" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
              </a>
            </li>
          </ul>
        </nav>
      </div>
      <!-- ListBlog-end -->
    </div>
  </div>
</template>
