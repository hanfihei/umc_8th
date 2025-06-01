package umc.spring.study.service.Mission2CommandServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.study.apiPayload.code.status.ErrorStatus;
import umc.spring.study.apiPayload.exception.handler.GeneralException;
import umc.spring.study.converter.Mission2Converter;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.User;
import umc.spring.study.domain.mapping.UserMission;
import umc.spring.study.repository.MissionRepository.MissionRepository;
import umc.spring.study.repository.MissionRepository2.MissionRepository2;
import umc.spring.study.repository.UserRepository.UserRepository;
import umc.spring.study.service.Mission2Service.Mission2CommandService;
import umc.spring.study.web.dto.UserRequestDTO;

@Service
@RequiredArgsConstructor
public class Mission2CommandServiceImpl implements Mission2CommandService {

    private final MissionRepository missionRepository;
    private final UserRepository userRepository;
    private final MissionRepository2 missionRepository2;

    @Override
    public UserMission AddMission(UserRequestDTO.AddMissionDto request) {



        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.MISSION_NOT_FOUND));

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));

        UserMission userMission = Mission2Converter.toMemberMission(request, user, mission);
        return missionRepository2.save(userMission);
    }
}
