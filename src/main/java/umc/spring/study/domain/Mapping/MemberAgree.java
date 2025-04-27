package umc.spring.study.domain.Mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.study.domain.User;
import umc.spring.study.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberAgree extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String agreementType;  // 약관 종류 (예: 개인정보, 서비스이용약관 등)

    @ManyToOne
    @JoinColumn(name = "member_id")
    private User user;
}
