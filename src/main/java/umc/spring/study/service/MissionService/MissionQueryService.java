package umc.spring.study.service.MissionService;

import umc.spring.study.domain.Mission;

import java.util.List;

public interface MissionQueryService {
    List<Mission> findMissionByMissionStatus(Long userId, Long cursor, String status);
    List<Mission> getHome(Long userId, Long regionId, Long cursor);
}
