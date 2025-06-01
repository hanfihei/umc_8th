package umc.spring.study.web.dto;

<<<<<<< Updated upstream
=======
import io.swagger.v3.oas.annotations.media.Schema;
>>>>>>> Stashed changes
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class UserResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinResultDTO {
        Long userId;
<<<<<<< Updated upstream
=======


>>>>>>> Stashed changes
        LocalDateTime createdAt;
    }

    //week8
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddMissionResultDTO {
        Long Mission2Id;
        LocalDateTime createdAt;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyMissionDTO {
        private String name;
        private String text;
        private Integer point;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyMissionListDTO {
        private List<MyMissionDTO> missionList;
        private int listSize;
    }
<<<<<<< Updated upstream
=======

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LoginResultDTO {
         Long userId;

        String accessToken;
    }


    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserInfoDTO{
        String name;
        String email;
        String gender;
    }


>>>>>>> Stashed changes
}