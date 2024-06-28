package com.umc.domain.user.dto;


import com.umc.common.jwt.TokenInfo;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserResponseDTO {
    TokenInfo tokenInfo;
    String nickName;
}
