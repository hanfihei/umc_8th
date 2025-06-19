package umc.spring.study.service.UserService;

import umc.spring.study.domain.User;
import umc.spring.study.web.dto.UserRequestDTO;
import umc.spring.study.web.dto.UserResponseDTO;

public interface UserCommandService {
    User joinUser(UserRequestDTO.JoinDto request);

    UserResponseDTO.LoginResultDTO loginUser(UserRequestDTO.LoginRequestDTO request);
}
