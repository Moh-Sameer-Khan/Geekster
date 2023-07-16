package com.geekster.InstagramBackend.repository;

import com.geekster.InstagramBackend.model.Post;
import com.geekster.InstagramBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPostRepo extends JpaRepository<Post, Long> {

    List<Post> findByPostOwner(User existingUser);
}
