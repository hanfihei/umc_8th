package umc.spring.study.domain.Mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.User;
import umc.spring.study.domain.common.BaseEntity;
import umc.spring.study.domain.enums.MissionStatusType;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MissionStatusType status;  // 미션 수행 상태

    private LocalDateTime completedDate;  // 미션 완료 날짜

    @ManyToOne
    @JoinColumn(name = "member_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "mission_id")
    private Mission mission;
}
