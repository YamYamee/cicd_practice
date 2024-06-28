package com.umc.domain.Comment.controller;

import com.umc.common.jwt.JwtTokenProvider;
import com.umc.common.response.ApiResponse;
import com.umc.domain.Comment.Converter.CommentConverter;
import com.umc.domain.Comment.dto.CommentRequestDTO;
import com.umc.domain.Comment.dto.CommentResponseDTO;
import com.umc.domain.Comment.dto.DeleteResponseDTO;
import com.umc.domain.Comment.entity.Comments;
import com.umc.domain.Comment.repository.CommentRepository;
import com.umc.domain.Comment.service.CommentService;
import com.umc.domain.post.Converter.postConverter;
import com.umc.domain.post.dto.PostRequestDTO;
import com.umc.domain.post.dto.PostResponseDTO;
import com.umc.domain.post.entity.Posts;
import com.umc.domain.post.repository.PostRepository;
import com.umc.domain.post.service.PostService;
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
public class CommentController {

    private final JwtTokenProvider jwtTokenProvider;
    private final CommentRepository commentRepository;

    @CrossOrigin
    @Operation(summary = "댓글 수정하는 폼 보여주기")
    @GetMapping("/edits/comment/{id}")
    public String getEditPage(@PathVariable Long id) {
        Optional< Comments> comment = CommentService.getComment(id);
        //갖고 온 데이터를 이용해서 HTML에 정보를 보내고, 프론트 엔드 단에서 형식에 맞게 보여주기
        //전송 버튼을 누르면 수정된 정보를 PUT 요청함.
        return null; //'HTML 페이지 보내주기'
    }

    @CrossOrigin
    @Operation(summary = "댓글 작성")
    @PostMapping("/comments")
    public ApiResponse<CommentResponseDTO> writePost(@Valid @RequestBody CommentRequestDTO commentRequestDTO) {
        Comments comment = CommentService.writeComment(commentRequestDTO);
        return ApiResponse.onSuccess(CommentConverter.CreateCommentResponseDTO(comment));
    }

    @CrossOrigin
    @Operation(summary = "댓글 수정")
    @PutMapping("/edits/comment/{id}")
    public ApiResponse<CommentResponseDTO> editComment(@PathVariable Long id, @RequestBody CommentRequestDTO commentRequestDTO) {
        Comments comments = CommentService.editPost(commentRequestDTO, id);
        return ApiResponse.onSuccess(CommentConverter.CreateCommentResponseDTO(comments));
    } // 실패한 경우는 어떻게 처리하는지?

    @CrossOrigin
    @Operation(summary = "댓글 삭제")
    @DeleteMapping("/comment/{id}")
    public ApiResponse<DeleteResponseDTO> deletePost(@PathVariable Long id) {
        return ApiResponse.onSuccess(CommentService.deletePost(id));
    }

}
