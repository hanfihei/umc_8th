package umc.spring.study.service.Mission2Service;

import umc.spring.study.web.dto.UserRequestDTO;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.mapping.UserMission;

public interface Mission2CommandService {
    UserMission AddMission(UserRequestDTO.AddMissionDto request);
}
