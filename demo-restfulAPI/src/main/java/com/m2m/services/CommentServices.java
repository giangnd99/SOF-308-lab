package com.m2m.services;

import com.m2m.dto.response.CommentResponse;
import com.m2m.entity.Comment;

import java.util.List;

public interface CommentServices {

    CommentResponse createComment(Comment comment);

    List<CommentResponse> getCommentsByPostId(Long postId);
}
