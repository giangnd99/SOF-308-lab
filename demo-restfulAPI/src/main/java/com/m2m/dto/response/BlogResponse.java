package com.m2m.dto.response;

import com.m2m.entity.Comment;
import com.m2m.entity.Post;
import com.m2m.entity.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BlogResponse {

    private Long id;
    private String title;
    private String content;
    private User user;
    private String image;
    private List<Comment> comments;
    private String createDate;

    public static BlogResponse convert(Post post) {
        BlogResponse response = new BlogResponse();
        response.setId(post.getId());
        response.setTitle(post.getTitle());
        response.setContent(post.getContent());
        response.setImage(post.getImage());
        response.setUser(post.getUser());
        response.setComments(post.getComments());
        response.setCreateDate(post.getCreatedDate().toString());
        return response;
    }

    public static List<BlogResponse> converts(List<Post> posts) {
        List<BlogResponse> responses = new ArrayList<>();
        for (Post post : posts) {
            BlogResponse response = new BlogResponse();
            response.setId(post.getId());
            response.setTitle(post.getTitle());
            response.setContent(post.getContent());
            response.setImage(post.getImage());
            response.setUser(post.getUser());
            response.setComments(post.getComments());
            response.setCreateDate(post.getCreatedDate().toString());
            responses.add(response);
        }
        return responses;
    }
}
