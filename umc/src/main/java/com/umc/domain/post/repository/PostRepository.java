package com.umc.domain.post.repository;

import com.umc.domain.post.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p WHERE p.id = :postId")
    Posts findPostById(@Param("postId") Long postId);
}
