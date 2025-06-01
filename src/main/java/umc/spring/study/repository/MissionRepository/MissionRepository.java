package umc.spring.study.repository.MissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.Review;
import umc.spring.study.domain.Store;
import umc.spring.study.domain.enums.MissionStatusType;

public interface MissionRepository extends JpaRepository<Mission, Long>, MissionRepositoryCustom {

    boolean existsByStoreAndStatus(Store store, MissionStatusType status);
    Page<Mission> findAllByStore(Store store, Pageable pageable);

}
