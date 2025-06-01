package umc.spring.study.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import umc.spring.study.apiPayload.ApiResponse;

@Schema(description = "로그인 성공 응답 예시")
public class LoginSuccessResponse extends ApiResponse<UserResponseDTO.LoginResultDTO> {
    public LoginSuccessResponse() {
        super(true, "COMMON200", "성공입니다.",
                UserResponseDTO.LoginResultDTO.builder()
                        .userId(1L)
                        .accessToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
                        .build()
        );
    }
}
