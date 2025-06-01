// MissionRepositoryCustom.java
package umc.spring.study.repository.MissionRepository;

import umc.spring.study.domain.Mission;

import java.util.List;

public interface MissionRepositoryCustom {
    List<Mission> findMissionsByRegionId(Long regionId);
    List<Mission> findMissionByMissionStatus(Long memberId, Long cursor, String status);
    List<Mission> findHomeMissions(Long memberId, Long regionId, Long cursor);
}
