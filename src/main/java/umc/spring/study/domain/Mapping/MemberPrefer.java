package umc.spring.study.domain.Mapping;

import umc.spring.study.domain.User;
import jakarta.persistence.*;
import lombok.*;
import umc.spring.study.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberPrefer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String preferName; // 선호하는 음식/카테고리 이름

    @ManyToOne
    @JoinColumn(name = "member_id")
    private User user;
}