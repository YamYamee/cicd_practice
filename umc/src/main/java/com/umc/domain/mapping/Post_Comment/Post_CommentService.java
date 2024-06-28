package com.umc.domain.mapping.Post_Comment;

import com.umc.domain.Comment.Converter.CommentConverter;
import com.umc.domain.Comment.dto.CommentRequestDTO;
import com.umc.domain.Comment.entity.Comments;
import com.umc.domain.Comment.repository.CommentRepository;
import com.umc.domain.mapping.Post_Comment.Post_CommentRepository;
import com.umc.domain.post.Converter.postConverter;
import com.umc.domain.post.dto.DeleteResponseDTO;
import com.umc.domain.post.dto.PostRequestDTO;
import com.umc.domain.post.entity.Posts;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class Post_CommentService {
    private static Post_CommentRepository post_commentRepository;

    public static Post_Comment writePost_Comment(Comments comment, Posts posts){

        Post_Comment post_comment = new Post_Comment();
        post_comment.setPost(posts);
        post_comment.setComment(comment);

        return post_commentRepository.save(post_comment);
    }

}