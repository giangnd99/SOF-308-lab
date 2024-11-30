package com.m2m.services.impl;

import com.m2m.dto.response.BlogResponse;
import com.m2m.entity.Post;
import com.m2m.repo.PostRepo;
import com.m2m.services.PostServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServicesImpl implements PostServices {

    private final PostRepo postRepo;

    @Autowired
    public PostServicesImpl(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    @Transactional(rollbackOn = Throwable.class)
    public Post createPost(Post post) {
        if (post == null) {
            throw new IllegalArgumentException("Post cannot be null");
        }

        if (post.getTitle() == null || post.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Post title is required");
        }

        return postRepo.save(post);
    }

    @Override
    public List<BlogResponse> getAllPosts() {
        return BlogResponse.converts(postRepo.findAll());
    }

    @Override
    public Post getPostById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid post ID");
        }

        Optional<Post> post = postRepo.findById(id);
        return post.orElseThrow(() -> new IllegalArgumentException("Post not found with id: " + id));
    }

    @Override
    @Transactional(rollbackOn = Throwable.class)
    public Post updatePost(Long id, Post post) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid post ID");
        }

        Post existingPost = getPostById(id);

        if (post.getTitle() != null && !post.getTitle().isEmpty()) {
            existingPost.setTitle(post.getTitle());
        }
        if (post.getContent() != null && !post.getContent().isEmpty()) {
            existingPost.setContent(post.getContent());
        }
        if (post.getImage() != null && !post.getImage().isEmpty()) {
            existingPost.setImage(post.getImage());
        }

        return postRepo.save(existingPost);
    }

    @Override
    @Transactional(rollbackOn = Throwable.class)
    public void deletePost(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid post ID");
        }

        Post post = getPostById(id);

        postRepo.delete(post);
    }
}
