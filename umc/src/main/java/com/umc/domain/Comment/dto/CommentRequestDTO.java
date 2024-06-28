package com.umc.domain.Comment.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentRequestDTO {

    @Column(name = "Content", columnDefinition = "TEXT")
    private String content;

    Long postId;
}