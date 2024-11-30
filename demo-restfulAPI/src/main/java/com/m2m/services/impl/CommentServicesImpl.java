package com.m2m.services.impl;

import com.m2m.dto.response.CommentResponse;
import com.m2m.entity.Comment;
import com.m2m.repo.CommentRepo;
import com.m2m.repo.PostRepo;
import com.m2m.services.CommentServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServicesImpl implements CommentServices {

    private final CommentRepo commentRepository;
    private final PostRepo postRepository;

    @Autowired
    public CommentServicesImpl(CommentRepo commentRepository, PostRepo postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    @Transactional(rollbackOn = Throwable.class)
    public CommentResponse createComment(Comment comment) {
        if (comment == null || comment.getContent() == null || comment.getContent().trim().isEmpty()) {
            throw new IllegalArgumentException("Comment content cannot be null or empty.");
        }
        if (!postRepository.existsById(comment.getPost().getId())) {
            throw new IllegalArgumentException("Post with ID " + comment.getPost().getId() + " does not exist.");
        }
        return CommentResponse.convert(commentRepository.save(comment));
    }

    @Override
    public List<CommentResponse> getCommentsByPostId(Long postId) {
        if (postId == null || postId <= 0) {
            throw new IllegalArgumentException("Invalid post ID.");
        }
        if (!postRepository.existsById(postId)) {
            throw new IllegalArgumentException("Post with ID " + postId + " does not exist.");
        }
        List<Comment> comments = commentRepository.findByPostId(postId);
        if (comments.isEmpty()) {
            throw new IllegalArgumentException("No comments found for post with ID " + postId);
        }

        return CommentResponse.converts(comments);
    }
}
