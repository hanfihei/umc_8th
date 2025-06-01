package umc.spring.study.domain.mapping;

import umc.spring.study.domain.FoodCategory;
import umc.spring.study.domain.User;
import jakarta.persistence.*;
import lombok.*;
import umc.spring.study.domain.common.BaseEntity;

@Setter
@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserPrefer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "food_category_id")
    private FoodCategory foodCategory;

    //@Column(nullable = false, length = 50)
    //private String preferName; // 선호하는 음식/카테고리 이름

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}