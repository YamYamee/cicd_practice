package com.umc.domain.user.controller;

import com.umc.common.jwt.JwtTokenProvider;
import com.umc.common.jwt.SecurityUtil;
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

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/users")
@RestController
public class MemberController {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserService usersService;

    @CrossOrigin
    @Operation(summary = "회원가입 API")
    @PostMapping("/sign-up")
    public ApiResponse<String> signUp(@Valid @RequestBody UserSignUpRequestDto userSignUpRequestDto) {
        return usersService.signUp(userSignUpRequestDto);
    }

    @CrossOrigin
    @Operation(summary = "로그인 API")
    @PostMapping("/login")
    public ApiResponse<UserResponseDTO> login(@Valid @RequestBody MemberLoginRequestDTO memberLoginRequestDTO) {
        return usersService.login(memberLoginRequestDTO);
    }

    @CrossOrigin
    @Operation(summary = "회원가입 창 보여주기")
    @GetMapping("/sign-up")
    public String signup() {
        /* 로그인 창 HTML 페이지 전송하기 */
        return null;
    }

    @CrossOrigin
    @Operation(summary = "로그인 창 보여주기")
    @GetMapping("/login")
    public String login() {
        /* 로그인 창 HTML 페이지 전송하기 */
        return null;
    }

}
