package umc.spring.study.repository.MissionRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.QMission;
import umc.spring.study.domain.QStore;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Mission> findMissionsByRegionId(Long regionId) {
        QMission mission = QMission.mission;
        QStore store = QStore.store;

        return queryFactory
                .selectFrom(mission)
                .join(mission.store, store)
                .where(store.region.id.eq(regionId))
                .fetch();
    }

    @Override
    public List<Mission> findHomeMissions(Long memberId, Long regionId, Long cursor) {
        QMission mission = QMission.mission;
        QStore store = QStore.store;

        return queryFactory
                .selectFrom(mission)
                .join(mission.store, store)
                .where(store.region.id.eq(regionId))
                .orderBy(mission.id.asc())
                .limit(10)
                .fetch();
    }

    @Override
    public List<Mission> findMissionByMissionStatus(Long memberId, Long cursor, String status) {
        QMission mission = QMission.mission;

        return queryFactory
                .selectFrom(mission)
                .where(mission.status.stringValue().eq(status))
                .orderBy(mission.id.asc())
                .limit(10)
                .fetch();
    }
}
