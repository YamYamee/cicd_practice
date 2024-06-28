package com.umc.domain.post.service;

import com.umc.domain.Comment.entity.Comments;
import com.umc.domain.mapping.Post_Comment.Post_Comment;
import com.umc.domain.mapping.Post_Comment.Post_CommentRepository;
import com.umc.domain.post.Converter.postConverter;
import com.umc.domain.post.dto.DeleteResponseDTO;
import com.umc.domain.post.dto.PostRequestDTO;
import com.umc.domain.post.entity.Posts;
import com.umc.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostService {
    private static PostRepository postRepository;
    private static Post_CommentRepository post_commentRepository;

    public static List<Posts> getPosts(){
        return postRepository.findAll();
    }

    public static Optional<Posts> getPost(Long id){
        return postRepository.findById(id);
    }
    public static Posts getPost2(Long id){
        return postRepository.findPostById(id);
    }

    public static List<Post_Comment> getPost_Comment(Long id){
        List<Post_Comment> post_comment;
        post_comment = post_commentRepository.findCommentsByPostId(id);
        return post_comment;
    }

    public static Posts writePost(PostRequestDTO request){
        Posts post = postConverter.toPosts(request);
        return postRepository.save(post);
    }

    public static Posts editPost(PostRequestDTO request, Long id) {
        postRepository.deleteById(id);
        // 삭제 못했을 경우, 에러 발생 추가하기
        Posts newPost = postConverter.toPosts(request);
        postRepository.save(newPost);
        return newPost;
    }

    public static DeleteResponseDTO deletePost(Long id){
        postRepository.deleteById(id);
        //삭제 못했을 경우, 에러 발생 혹은 실패 코드 보내기
        return postConverter.CreateDeleteDTO(id);
    }

}
