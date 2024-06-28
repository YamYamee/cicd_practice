package com.umc.domain.Comment.Converter;

import com.umc.common.jwt.SecurityUtil;
import com.umc.domain.Comment.dto.CommentRequestDTO;
import com.umc.domain.Comment.dto.CommentResponseDTO;
import com.umc.domain.Comment.dto.DeleteResponseDTO;
import com.umc.domain.Comment.entity.Comments;


import java.time.LocalDateTime;

public class CommentConverter { // 로그인 안 한 경우에 대한 예외 처리 추가 =

    LocalDateTime now = LocalDateTime.now();

    public static Comments toComments(CommentRequestDTO request){
        return Comments.builder()
        .comment(request.getContent())
        .member(SecurityUtil.getCurrentUser()).build();

    }

    public static CommentResponseDTO CreateCommentResponseDTO(Comments comment){
        return CommentResponseDTO.builder()
                .commentId(comment.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static DeleteResponseDTO CreateDeleteDTO(Long id){

        return DeleteResponseDTO.builder()
                .commentId(id)
                .deletedAt(LocalDateTime.now())
                .build();
    }
}
