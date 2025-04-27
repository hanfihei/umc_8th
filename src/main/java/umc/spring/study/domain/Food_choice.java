package umc.spring.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.study.domain.common.BaseEntity;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Food_choice extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String foodName;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    private String field;  // 필드 타입 지정이 애매했으니 그냥 String

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
