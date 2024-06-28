package com.umc.domain.mapping.Post_Comment;

import com.umc.domain.Comment.entity.Comments;
import com.umc.domain.mapping.Post_Comment.Post_Comment;
import com.umc.domain.post.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Post_CommentRepository extends JpaRepository<Post_Comment, Long> {

    @Query("SELECT c FROM Post_Comment c WHERE c.post.id = :postId")
    List<Post_Comment> findCommentsByPostId(@Param("postId") Long postId);
}
