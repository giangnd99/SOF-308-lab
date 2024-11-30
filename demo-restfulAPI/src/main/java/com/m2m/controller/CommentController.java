package com.m2m.controller;

import com.m2m.dto.response.CommentResponse;
import com.m2m.entity.Comment;
import com.m2m.services.CommentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentServices commentService;

    @Autowired
    public CommentController(CommentServices commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/")
    public CommentResponse createComment(@RequestBody Comment comment) {
        return commentService.createComment(comment);
    }

    @GetMapping("/post/{postId}")
    public List<CommentResponse> getCommentsByPostId(@PathVariable Long postId) {
        return commentService.getCommentsByPostId(postId);
    }
}