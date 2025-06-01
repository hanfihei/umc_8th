package umc.spring.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.study.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;

    @Column(nullable = false, length = 100)
    private String storeName;

    private String address;

    @Column(nullable = false)
    private double star;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @ManyToOne//fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

//    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
 //   private List<Review> review = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Mission> missionList = new ArrayList<>();

    @Override
    public String toString() {
        return "Store{" +
                "storeId=" + storeId +
                ", name='" + storeName + '\'' +
                ", address='" + address + '\'' +
                ", score=" + star +
                ", region=" + (region != null ? region.getName() : "N/A") +
                '}';
    }

}
