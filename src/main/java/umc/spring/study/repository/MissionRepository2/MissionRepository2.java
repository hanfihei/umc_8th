package umc.spring.study.repository.MissionRepository2;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.User;
import umc.spring.study.domain.enums.MissionStatusType;
import umc.spring.study.domain.mapping.UserMission;

import java.util.Optional;

@Repository
public interface MissionRepository2 extends JpaRepository<UserMission, Long> {

    Optional<UserMission> findByUserIdAndMissionId(Long userId, Long missionId);

    Optional<UserMission> findByUserAndMission(User user, Mission mission);
    Optional<UserMission> findByUserIdAndMissionIdAndStatus(Long userId, Long missionId, MissionStatusType missionStatus);


    Page<UserMission> findAllByUserAndStatus(User user, MissionStatusType status, Pageable pageable);

}
