package com.umc.domain.post.controller;

import com.umc.common.jwt.JwtTokenProvider;
import com.umc.common.jwt.SecurityUtil;
import com.umc.domain.Comment.entity.Comments;
import com.umc.domain.mapping.Post_Comment.Post_Comment;
import com.umc.domain.post.Converter.postConverter;
import com.umc.domain.post.dto.DeleteResponseDTO;
import com.umc.domain.post.dto.PostRequestDTO;
import com.umc.domain.post.dto.PostResponseDTO;
import com.umc.domain.post.entity.Posts;
import com.umc.domain.post.repository.PostRepository;
import com.umc.domain.post.service.PostService;
import com.umc.domain.user.dto.MemberLoginRequestDTO;
import com.umc.domain.user.dto.UserResponseDTO;
import com.umc.domain.user.dto.UserSignUpRequestDto;
import com.umc.domain.user.service.UserService;
import com.umc.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/users")
@RestController
public class PostController {

    private final JwtTokenProvider jwtTokenProvider;
    private final PostRepository postRepository;

    @CrossOrigin
    @Operation(summary = "글 목록 보여주기")
    @GetMapping("/posts")
    public String getPosts() {

        List<Posts> posts = PostService.getPosts();
        //갖고 온 데이터를 이용해서 HTML에 정보를 보내고, 프론트 엔드 단에서 형식에 맞게 보여주기
        return null; //'HTML 페이지 보내주기'
    }

    @CrossOrigin
    @Operation(summary = "특정 글 보여주기 + 댓글 보여주기")
    @GetMapping("/posts/{id}")
    public String getDetailPage(@PathVariable Long id) {

        Optional<Posts> post = PostService.getPost(id);
        List<Post_Comment> post_comments = PostService.getPost_Comment(id);
        //갖고 온 데이터를 이용해서 HTML에 정보를 보내고, 프론트 엔드 단에서 형식에 맞게 보여주기
        //Post_Comment에서 Comment만 추출하기
        return null; //'HTML 페이지 보내주기'
    }

    @CrossOrigin
    @Operation(summary = "특정 글 수정하는 폼 보여주기")
    @GetMapping("/edits/{id}")
    public String getEditPage(@PathVariable Long id) {
        Optional<Posts> post = PostService.getPost(id);
        //갖고 온 데이터를 이용해서 HTML에 정보를 보내고, 프론트 엔드 단에서 형식에 맞게 보여주기
        //전송 버튼을 누르면 수정된 정보를 PUT 요청함.
        return null; //'HTML 페이지 보내주기'
    }

    @CrossOrigin
    @Operation(summary = "글 작성")
    @PostMapping("/posts")
    public ApiResponse<PostResponseDTO> writePost(@Valid @RequestBody PostRequestDTO postRequestDTO) {
        Posts post = PostService.writePost(postRequestDTO);
        return ApiResponse.onSuccess(postConverter.CreatePostResponseDTO(post));
    }

    @CrossOrigin
    @Operation(summary = "글 수정")
    @PutMapping("/posts/{id}")
    public ApiResponse<PostResponseDTO> editPost(@PathVariable Long id, @RequestBody PostRequestDTO postRequestDTO) {
        Posts post = PostService.editPost(postRequestDTO, id);
        return ApiResponse.onSuccess(postConverter.CreatePostResponseDTO(post));
    } // 실패한 경우는 어떻게 처리하는지?

    @CrossOrigin
    @Operation(summary = "글 삭제")
    @DeleteMapping("/posts/{id}")
    public ApiResponse<DeleteResponseDTO> deletePost(@PathVariable Long id) {
        return ApiResponse.onSuccess(PostService.deletePost(id));
    }

}
