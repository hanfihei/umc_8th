package umc.spring.study.service.MissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.study.domain.Mission;
import umc.spring.study.repository.MissionRepository.MissionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;

    @Override
    public List<Mission> findMissionByMissionStatus(Long userId, Long cursor, String status) {
        List<Mission> missions = missionRepository.findMissionByMissionStatus(userId, cursor, status);

        missions.forEach(mission ->
                System.out.println("미션: " + mission.getId() + ", 포인트: " + mission.getPoint()));

        return missions;
    }

    @Override
    public List<Mission> getHome(Long memberId, Long regionId, Long cursor) {
        return missionRepository.findHomeMissions(memberId, regionId, cursor);
    }
}
