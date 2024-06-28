package com.umc.domain.post.dto;


import com.umc.common.jwt.TokenInfo;
import com.umc.domain.post.entity.Posts;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class PostResponseDTO {
    Long postId;
    LocalDateTime createdAt;
}
