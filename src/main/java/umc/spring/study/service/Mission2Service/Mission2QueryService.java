package umc.spring.study.service.Mission2Service;

import umc.spring.study.domain.Mission;
import umc.spring.study.domain.enums.MissionStatusType;
import umc.spring.study.domain.mapping.UserMission;

import java.util.Optional;

public interface Mission2QueryService {

    Optional<UserMission> findMissionsForUserByStatus(Long userId, Long cursor, MissionStatusType status);

}
