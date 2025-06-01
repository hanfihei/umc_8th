package umc.spring.study.service.UserService;

<<<<<<< Updated upstream
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.study.apiPayload.code.status.ErrorStatus;
import umc.spring.study.apiPayload.exception.handler.GeneralException;
=======
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.study.apiPayload.code.status.ErrorStatus;
import umc.spring.study.apiPayload.exception.handler.GeneralException;
import umc.spring.study.apiPayload.exception.handler.UserHandler;
import umc.spring.study.config.security.jwt.JwtTokenProvider;
import umc.spring.study.converter.UserConverter;
>>>>>>> Stashed changes
import umc.spring.study.domain.User;
import umc.spring.study.domain.enums.MissionStatusType;
import umc.spring.study.domain.mapping.UserMission;
import umc.spring.study.repository.MissionRepository2.MissionRepository2;
import umc.spring.study.repository.UserRepository.UserRepository;
import umc.spring.study.web.dto.MyPageDTO;
<<<<<<< Updated upstream
=======
import umc.spring.study.web.dto.UserResponseDTO;
>>>>>>> Stashed changes

@Service
@RequiredArgsConstructor
public class UserQueryServiceImpl implements UserQueryService {

    private final UserRepository userRepository;
    private final MissionRepository2 missionRepository2;
<<<<<<< Updated upstream
=======
    private final JwtTokenProvider jwtTokenProvider;
>>>>>>> Stashed changes

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
<<<<<<< Updated upstream
=======

    @Override
    @Transactional(readOnly = true)
    public UserResponseDTO.UserInfoDTO getUserInfo(HttpServletRequest request){
        Authentication authentication = jwtTokenProvider.extractAuthentication(request);
        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(()-> new UserHandler(ErrorStatus.MEMBER_NOT_FOUND));
        return UserConverter.toUserInfoDTO(user);
    }
>>>>>>> Stashed changes
}
