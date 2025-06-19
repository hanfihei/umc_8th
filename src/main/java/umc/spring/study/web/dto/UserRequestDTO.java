package umc.spring.study.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import umc.spring.study.domain.enums.Role;
import umc.spring.study.validation.annotation.ExistCategories;

import java.util.List;


public class UserRequestDTO {

    @Setter
    @Getter
    public static class JoinDto {
        @NotBlank
        private String name;
        @NotNull
        private Integer gender;
        @NotNull
        private Integer birthYear;
        @NotNull
        private Integer birthMonth;
        @NotNull
        private Integer birthDay;
        @NotNull
        private String phoneNumber;
        @Size(min = 5, max = 12)
        private String address;
        @Size(min = 5, max = 12)
        private String specAddress;
        @ExistCategories
        private List<Long> preferCategory;

        //시큐리티
        @Email
        private String email;
        @NotBlank
        private String password;
        @NotNull
        private Role role;





    }
    @Getter
    @Setter
    public static class AddMissionDto {
        @NotNull
        Long userId;
        @NotNull
        Long missionId;
    }

    @Getter
    @Setter
    public static class LoginRequestDTO {
        @NotBlank(message = "이메일은 필수입니다.")
        @Email(message = "올바른 이메일 형식이어야 합니다.")
        private String email;

        @NotBlank(message = "패스워드는 필수입니다.")
        private String password;
    }
}


