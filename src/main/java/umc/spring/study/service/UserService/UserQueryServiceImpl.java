package umc.spring.study.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.study.apiPayload.code.status.ErrorStatus;
import umc.spring.study.apiPayload.exception.handler.GeneralException;
import umc.spring.study.domain.User;
import umc.spring.study.domain.enums.MissionStatusType;
import umc.spring.study.domain.mapping.UserMission;
import umc.spring.study.repository.MissionRepository2.MissionRepository2;
import umc.spring.study.repository.UserRepository.UserRepository;
import umc.spring.study.web.dto.MyPageDTO;

@Service
@RequiredArgsConstructor
public class UserQueryServiceImpl implements UserQueryService {

    private final UserRepository userRepository;
    private final MissionRepository2 missionRepository2;

    @Override
    public MyPageDTO getMyPage(Long userId) {
        return userRepository.getMyPage(userId);
    }

    @Override
    public Page<UserMission> getInProgressMissions(Long userId, int page) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));

        return missionRepository2.findAllByUserAndStatus(user, MissionStatusType.ONGOING, PageRequest.of(page, 10));
    }
}
