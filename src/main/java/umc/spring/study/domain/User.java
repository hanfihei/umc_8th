package umc.spring.study.domain;

import jakarta.persistence.*;
import lombok.*;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umc.spring.study.domain.common.BaseEntity;
import umc.spring.study.domain.enums.Gender;
import umc.spring.study.domain.enums.SocialType;
import umc.spring.study.domain.enums.UserStatus;
import umc.spring.study.domain.mapping.UserAgree;
import umc.spring.study.domain.mapping.UserMission;
import umc.spring.study.domain.mapping.UserPrefer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "`user`")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 50)
    private String phoneNumber;

    @Column(nullable = false, length = 50)
    private String email;

    //@Column(nullable = false, length = 100)
    private String address;

    //@Column(nullable = false, length = 100)
    private String specAddress;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @ColumnDefault("0")
    private Integer point;

    @Enumerated(EnumType.STRING)
    //@Column(columnDefinition = "INACTIVE")
    private UserStatus status;


    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private UserStatus userStatus;

    private LocalDate inactiveDate;

    @OneToMany(mappedBy = "user")
    private List<UserAgree> userAgreeList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserPrefer> userPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserMission> UserMissionList = new ArrayList<>();

    /*
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<FoodChoice> foodChoiceList = new ArrayList<>(); */
}
