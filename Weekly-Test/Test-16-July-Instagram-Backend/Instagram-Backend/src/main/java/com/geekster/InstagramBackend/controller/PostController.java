package com.geekster.InstagramBackend.controller;

import com.geekster.InstagramBackend.model.Post;
import com.geekster.InstagramBackend.model.dto.InstaAllPostsOutput;
import com.geekster.InstagramBackend.model.dto.SignInInputSession;
import com.geekster.InstagramBackend.service.AuthenticationService;
import com.geekster.InstagramBackend.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Validated
@RestController
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("instagram/post")
    public String createInstaPost(@RequestBody @Valid Post post, @RequestParam String email, @RequestParam String tokenValue) {

        boolean validAuthentication = authenticationService.authenticateInsta(email, tokenValue);
        if(validAuthentication) {
            return postService.createInstaPost(post,email);
        }
        else {
            return "Not an Authenticated user activity!!!";
        }
    }

    @GetMapping("instagram/show/AllPosts")
    public InstaAllPostsOutput getAllInstaPosts(@RequestParam String email, @RequestParam String tokenValue) {
        String statusOutputMessage = null;
        List<Post> instaAllPosts = null;
        boolean validAuthentication = authenticationService.authenticateInsta(email, tokenValue);
        if(validAuthentication) {
              instaAllPosts = postService.getAllInstaPosts(tokenValue);
//              handling the LocalDateTime because null coming
              for(Post post : instaAllPosts) {
                  post.setPostUpdatedTimeStamp(LocalDateTime.now());
                  post.setPostCreatedTimeStamp(LocalDateTime.now());
              }
              statusOutputMessage = "All Posts!!!";
              return new InstaAllPostsOutput(statusOutputMessage, instaAllPosts);
        }
        else {
            statusOutputMessage = "Not an Authenticated user activity!!!";
            return new InstaAllPostsOutput(statusOutputMessage, instaAllPosts);
        }
    }

}
