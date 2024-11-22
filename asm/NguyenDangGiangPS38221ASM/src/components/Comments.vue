<template>
  <div class="card-footer border border-1">
    <div class="card" v-for="(comment, index) in comments" :key="index">
      <div class="card-body">
        <blockquote class="blockquote mb-0">
          <p>{{ comment.author }}</p>
          <footer class="blockquote-footer">
            {{ comment.content }}
            <cite title="Source title">
              <span class="text-muted float-right text-lowercase fs-6 mx-2">
                >{{ comment.time }}
              </span>
            </cite>
          </footer>
        </blockquote>
      </div>
    </div>
    <div class="row g-0">
      <div class="mb-3">
        <label for="commentBox" class="form-label text-dark fw-bolder">
          Write your comments:
        </label>
        <textarea
          id="commentBox"
          class="form-control mb-3"
          rows="3"
          v-model="newComment"
        ></textarea>
        <button class="btn btn-outline-secondary" @click="addComment">
          Send
        </button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      comments: [
        {
          author: "Nguyen Van A",
          content: "Bai viet rat bo ich",
          time: "8:03 PM Today",
        },
        {
          author: "Nguyen Van B",
          content: "Cam on bai viet nay",
          time: "8:10 PM Today",
        },
      ],
      newComment: "",
    };
  },
  methods: {
    addComment() {
      if (this.newComment.trim()) {
        this.comments.push({
          author: "New User",
          content: this.newComment,
          time: new Date().toLocaleTimeString(),
        });
        this.newComment = "";
      }
    },
  },
};
</script>
