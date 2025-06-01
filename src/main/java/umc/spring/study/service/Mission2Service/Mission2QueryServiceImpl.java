package umc.spring.study.service.Mission2Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.enums.MissionStatusType;
import umc.spring.study.domain.mapping.UserMission;
import umc.spring.study.repository.MissionRepository.MissionRepository;
import umc.spring.study.repository.MissionRepository2.MissionRepository2;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class Mission2QueryServiceImpl implements Mission2QueryService {
    private final MissionRepository2 missionRepository2;

    @Override
    public Optional<UserMission> findMissionsForUserByStatus(Long userId, Long missionId, MissionStatusType status){
        return missionRepository2.findByUserIdAndMissionIdAndStatus(userId, missionId, status);
    }
}
