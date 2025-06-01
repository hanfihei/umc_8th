package umc.spring.study.service.UserService;

<<<<<<< Updated upstream
=======
import jakarta.servlet.http.HttpServletRequest;
>>>>>>> Stashed changes
import org.springframework.data.domain.Page;
import umc.spring.study.domain.User;
import umc.spring.study.domain.mapping.UserMission;
import umc.spring.study.web.dto.MyPageDTO;
<<<<<<< Updated upstream
=======
import umc.spring.study.web.dto.UserResponseDTO;
>>>>>>> Stashed changes

public interface UserQueryService {

    MyPageDTO getMyPage(Long userId);

    Page<UserMission> getInProgressMissions(Long userId, int page);
<<<<<<< Updated upstream
}
=======

    UserResponseDTO.UserInfoDTO getUserInfo(HttpServletRequest request);
    }
>>>>>>> Stashed changes
