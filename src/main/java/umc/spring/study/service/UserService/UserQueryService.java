package umc.spring.study.service.UserService;

import org.springframework.data.domain.Page;
import umc.spring.study.domain.User;
import umc.spring.study.domain.mapping.UserMission;
import umc.spring.study.web.dto.MyPageDTO;

public interface UserQueryService {

    MyPageDTO getMyPage(Long userId);

    Page<UserMission> getInProgressMissions(Long userId, int page);
}