<template>
  <div class="row">
    <div class="col-4">
      <div class="card border-secondary border-2 mt-3">
        <div class="card-header">
          <h5 class="card-title">Nguyễn Đằng Giang</h5>
          <h6 class="card-subtitle mb-2 text-body-secondary">
            Email:nguyendanggiang99@gmail.com
          </h6>
        </div>
        <img
          class="card-img-top rounded-circle border border-2 shadow-lg mx-auto"
          src="../assets/images/ava.png"
          alt="Title"
          style="width: 100px; height: 100px"
        />
        <div class="card-body">
          <p class="card-text">Birthday:</p>
          <p class="card-tex">Phone:</p>
          <p class="card-tex">Address:</p>
        </div>
      </div>
    </div>

    <div class="col">
      <div class="container my-3 mx-auto">
        <div class="card">
          <div class="card-header bg-dark text-light">Edit profile</div>
          <div class="card-body">
            <form>
              <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label"
                  >Fullname</label
                >
                <input
                  type="text"
                  class="form-control"
                  id="exampleInputEmail1"
                  aria-describedby="emailHelp"
                />
                <div id="emailHelp" class="form-text">
                  We'll never share your email with anyone else.
                </div>
              </div>
              <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label"
                  >Email address</label
                >
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
                <label for="exampleInputEmail1" class="form-label"
                  >Birthday</label
                >
                <input
                  type="date"
                  class="form-control"
                  id="exampleInputEmail1"
                  aria-describedby="emailHelp"
                />
                <div id="emailHelp" class="form-text">
                  We'll never share your email with anyone else.
                </div>
              </div>
              <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label"
                  >Phone number</label
                >
                <input
                  type="tel"
                  class="form-control"
                  id="exampleInputEmail1"
                  aria-describedby="emailHelp"
                />
                <div id="emailHelp" class="form-text">
                  We'll never share your email with anyone else.
                </div>
              </div>
              <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label"
                  >Address</label
                >
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
                <label for="exampleInputPassword1" class="form-label"
                  >Password</label
                >
                <input
                  type="password"
                  class="form-control"
                  id="exampleInputPassword1"
                />
              </div>
              <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label"
                  >Upload avatar</label
                >
                <input
                  type="file"
                  class="form-control"
                  id="exampleInputPassword1"
                />
              </div>
              <button type="submit" class="btn btn-success">Submit</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
