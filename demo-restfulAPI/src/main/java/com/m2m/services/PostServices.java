package com.m2m.services;

import com.m2m.dto.response.BlogResponse;
import com.m2m.entity.Post;

import java.util.List;

public interface PostServices {

    Post createPost(Post post);

    List<BlogResponse> getAllPosts();

    Post getPostById(Long id);

    Post updatePost(Long id, Post post);

    void deletePost(Long id);
}
