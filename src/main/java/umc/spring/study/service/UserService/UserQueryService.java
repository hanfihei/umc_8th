package umc.spring.study.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import umc.spring.study.domain.User;
import umc.spring.study.domain.mapping.UserMission;
import umc.spring.study.web.dto.MyPageDTO;
import umc.spring.study.web.dto.UserResponseDTO;

public interface UserQueryService {

    MyPageDTO getMyPage(Long userId);

    Page<UserMission> getInProgressMissions(Long userId, int page);

    UserResponseDTO.UserInfoDTO getUserInfo(HttpServletRequest request);
    }