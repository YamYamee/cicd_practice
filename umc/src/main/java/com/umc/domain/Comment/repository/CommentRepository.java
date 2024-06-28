package com.umc.domain.Comment.repository;

import com.umc.domain.Comment.entity.Comments;
import com.umc.domain.post.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comments, Long> {

}
