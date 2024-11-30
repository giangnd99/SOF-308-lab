package com.m2m.dto.response;

import com.m2m.entity.Comment;
import com.m2m.entity.Post;
import com.m2m.entity.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CommentResponse {
    private Long id;
    private String content;
    private User user;
    private String createdDate;
    private Post post;

    public static CommentResponse convert(Comment comment) {
        CommentResponse response = new CommentResponse();
        response.setId(comment.getId());
        response.setContent(comment.getContent());
        response.setUser(comment.getUser());
        response.setPost(comment.getPost());
        response.setCreatedDate(comment.getCreatedDate().toString());
        return response;
    }

    public static List<CommentResponse> converts(List<Comment> comments) {
        List<CommentResponse> responses = new ArrayList<CommentResponse>();
        for (Comment comment : comments) {
            CommentResponse response = new CommentResponse();
            response.setId(comment.getId());
            response.setContent(comment.getContent());
            response.setUser(comment.getUser());
            response.setPost(comment.getPost());
            response.setCreatedDate(comment.getCreatedDate().toString());
            responses.add(response);
        }
        return responses;
    }
}
