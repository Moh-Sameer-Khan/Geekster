package com.geekster.InstagramBackend.service;

import com.geekster.InstagramBackend.model.Post;
import com.geekster.InstagramBackend.model.User;
import com.geekster.InstagramBackend.repository.IPostRepo;
import com.geekster.InstagramBackend.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {

    @Autowired
    IPostRepo iPostRepo;

    @Autowired
    IUserRepo iUserRepo;

    @Autowired
    AuthenticationService authenticationService;
    public String createInstaPost(Post post, String signInEmail) {
        User postOwner =  iUserRepo.findFirstByUserEmail(signInEmail);
        post.setPostOwner(postOwner);

        post.setPostCreatedTimeStamp(LocalDateTime.now());
        post.setPostUpdatedTimeStamp(LocalDateTime.now());
        iPostRepo.save(post);
        return "Post Uploaded!!!";
    }

    public List<Post> getAllInstaPosts(String tokenValue) {
        User existingUser = authenticationService.findUser(tokenValue);
        return iPostRepo.findByPostOwner(existingUser);
    }
}
