package umc.spring.study.web.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;


import io.swagger.v3.oas.annotations.responses.ApiResponses;
<<<<<<< Updated upstream
=======
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
>>>>>>> Stashed changes
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.apiPayload.exception.handler.GeneralException;
import umc.spring.study.converter.ReviewConverter;
import umc.spring.study.converter.UserConverter;
import umc.spring.study.domain.Review;
import umc.spring.study.domain.User;
import umc.spring.study.domain.mapping.UserMission;
import umc.spring.study.service.Mission2Service.Mission2CommandService;
import umc.spring.study.service.ReviewService.ReviewQueryService;
import umc.spring.study.service.UserService.UserCommandService;
import umc.spring.study.service.UserService.UserQueryService;
import umc.spring.study.validation.annotation.AlreadyOngoing;
import umc.spring.study.validation.annotation.PageError;
<<<<<<< Updated upstream
=======
import umc.spring.study.web.dto.LoginSuccessResponse;
>>>>>>> Stashed changes
import umc.spring.study.web.dto.ReviewResponseDTO;
import umc.spring.study.web.dto.UserRequestDTO;
import umc.spring.study.web.dto.UserResponseDTO;
import umc.spring.study.converter.Mission2Converter;

import umc.spring.study.apiPayload.code.status.ErrorStatus;
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserRestController {
    private final UserCommandService userCommandService;
    private final Mission2CommandService mission2CommandService;
    private final ReviewQueryService reviewQueryService;
    private final UserQueryService userQueryService;

<<<<<<< Updated upstream

    @PostMapping("/")
    public ApiResponse<UserResponseDTO.JoinResultDTO> join(@RequestBody @Valid UserRequestDTO.JoinDto request) {
=======
    @PostMapping("/join")
    @Operation(summary = "유저 회원가입 API",description = "유저가 회원가입하는 API입니다.")
    public ApiResponse<UserResponseDTO.JoinResultDTO> join(@RequestBody @Valid UserRequestDTO.JoinDto request){
>>>>>>> Stashed changes
        User user = userCommandService.joinUser(request);
        return ApiResponse.onSuccess(UserConverter.toJoinResultDTO(user));
    }

<<<<<<< Updated upstream
=======

    @PostMapping("/login")
    @Operation(summary = "유저 로그인 API",description = "유저가 로그인하는 API입니다.")
    public ApiResponse<UserResponseDTO.LoginResultDTO> login(@RequestBody @Valid UserRequestDTO.LoginRequestDTO request) {
        return ApiResponse.onSuccess(userCommandService.loginUser(request));
    }


    @GetMapping("/info")
    @Operation(summary = "유저 내 정보 조회 API - 인증 필요",
            description = "유저가 내 정보를 조회하는 API입니다.",
            security = { @SecurityRequirement(name = "JWT TOKEN") }
    )
    public ApiResponse<UserResponseDTO.UserInfoDTO> getMyInfo(HttpServletRequest request) {
        return ApiResponse.onSuccess(userQueryService.getUserInfo(request));
    }


>>>>>>> Stashed changes
    @PostMapping("/missions")
    public ApiResponse<UserResponseDTO.AddMissionResultDTO> join(@RequestBody @AlreadyOngoing @Valid UserRequestDTO.AddMissionDto request) {
        UserMission mission2 = mission2CommandService.AddMission(request);
        return ApiResponse.onSuccess(Mission2Converter.addResultDTO(mission2));
    }

    //week9
    @GetMapping("/{userId}/reviews")
    @Operation(summary = "내가 작성한 리뷰 목록 조회 API", description = "사용자가 작성한 리뷰 목록을 페이징하여 조회합니다. page는 1부터 시작합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name = "userId", description = "사용자의 ID"),
            @Parameter(name = "page", description = "1부터 시작하는 페이지 번호", required = false)
    })
    public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> getUserReviews(
            @PathVariable(name = "userId") Long userId,
            @PageError Integer page) {

        Page<Review> reviews = reviewQueryService.getReviewsByUser(userId, page);

        if (reviews.isEmpty()) {
            throw new GeneralException(ErrorStatus. ARTICLE_NOT_FOUND);
        }

        return ApiResponse.onSuccess(ReviewConverter.reviewPreViewListDTO(reviews));
    }


    //week9
    @GetMapping("/{userId}/missions/ongoing")
    @Operation(summary = "진행 중인 미션 목록 조회", description = "해당 유저가 수행 중인 미션 리스트를 페이징으로 조회합니다.")
    @Parameters({
            @Parameter(name = "userId", description = "유저 ID", required = true),
            @Parameter(name = "page", description = "페이지 번호 (1부터 시작)", required = true)
    })
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "PAGE4001", description = "page는 1 이상의 값이여야 합니다."),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "MEMBER4001", description = "해당 사용자가 존재하지 않습니다.")
    })
    public ApiResponse<UserResponseDTO.MyMissionListDTO> getInProgressMissions(
            @PathVariable(name = "userId") Long userId,
            @PageError Integer page
    ) {
        Page<UserMission> missions = userQueryService.getInProgressMissions(userId, page);
        return ApiResponse.onSuccess(Mission2Converter.toMyMissionListDTO(missions));
    }

<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
}
