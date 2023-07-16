package com.geekster.InstagramBackend.model.dto;

import com.geekster.InstagramBackend.model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class InstaAllPostsOutput {

    private String statusMessage;
    private List<Post> instaAllPosts;
}
