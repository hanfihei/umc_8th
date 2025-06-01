package umc.spring.study.converter;

import umc.spring.study.domain.User;
import umc.spring.study.domain.enums.Gender;
import umc.spring.study.web.dto.UserRequestDTO;
import umc.spring.study.web.dto.UserResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserConverter {
    public static UserResponseDTO.JoinResultDTO toJoinResultDTO(User user) {
        return UserResponseDTO.JoinResultDTO.builder()
                .userId(user.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

<<<<<<< Updated upstream
=======
    public static UserResponseDTO.LoginResultDTO toLoginResultDTO(Long userId, String accessToken) {
        return UserResponseDTO.LoginResultDTO.builder()
                .userId(userId)
                .accessToken(accessToken)
                .build();
    }

    public static UserResponseDTO.UserInfoDTO toUserInfoDTO(User user){
        return UserResponseDTO.UserInfoDTO.builder()
                .name(user.getName())
                .email(user.getEmail())
                .gender(user.getGender().name())
                .build();
    }




>>>>>>> Stashed changes
    public static User toUser(UserRequestDTO.JoinDto request) {

        Gender gender = null;

        switch (request.getGender()) {
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .role(request.getRole())
                .phoneNumber(request.getPhoneNumber())
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .userPreferList(new ArrayList<>())
                .build();
    }
}