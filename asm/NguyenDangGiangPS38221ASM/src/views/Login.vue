<template>
     <div
      class="modal fade"
      id="staticLogin"
      data-bs-backdrop="static"
      data-bs-keyboard="false"
      tabindex="-1"
      aria-labelledby="staticBackdropLabel"
      aria-hidden="true"
    >
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="staticBackdropLabel">Login</h1>
            <button
              type="button"
              class="btn-close"
              data-bs-dismiss="modal"
              aria-label="Close"
            ></button>
          </div>
          <div class="modal-body">
            <form>
              <div class="row mb-3">
                <label for="inputEmail3" class="col-sm-1 col-form-label"
                  ><i class="fa-solid fa-id-card"></i
                ></label>
                <div class="col-sm-9">
                  <input type="email" class="form-control" id="inputEmail3" />
                </div>
              </div>
              <div class="row mb-3">
                <label for="inputPassword3" class="col-sm-1 col-form-label"
                  ><i class="fa-solid fa-key"></i
                ></label>
                <div class="col-sm-9">
                  <input
                    type="password"
                    class="form-control"
                    id="inputPassword3"
                  />
                </div>
              </div>
              <div class="row mb-3">
                <div class="col-sm-10 offset-sm-2">
                  <div class="form-check">
                    <input
                      class="form-check-input"
                      type="checkbox"
                      id="gridCheck1"
                    />
                    <label class="form-check-label" for="gridCheck1">
                      Remember me
                    </label>
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="col-6">
                  <a href="" class=" text-decoration-none link-success">
                    Register new account
                  </a>
                </div>
                <div class="col-6">
                  <a href="" class="text-decoration-none link-danger">
                    Register new account
                  </a>
                </div>
              </div>
              <div class="modal-footer d-inline">
                <div class="row d-flex justify-content-between">
                  <div class="col-sm-6 text-start">
                    <button type="submit" class="btn btn-primary">
                      Sign in
                    </button>
                  </div>
                  <div class="col-sm-6 text-end">
                    <button
                      type="button"
                      class="btn btn-secondary"
                      data-bs-dismiss="modal"
                    >
                      Close
                    </button>
                  </div>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
</template>