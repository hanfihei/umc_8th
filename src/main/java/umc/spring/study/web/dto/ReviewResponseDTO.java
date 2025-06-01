package umc.spring.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class ReviewResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddReviewResultDTO{
        Long reviewId;
        LocalDateTime createdAt;


        private Long id;
        private String text;
        private Float star;
        private String storeName;
        private String memberName;
    }

    @Getter
    @Builder
    public static class ReviewPreviewDTO {
        private Long reviewId;
        private String text;
        private Integer star;
    }

    @Getter
    @Builder
    public static class ReviewPreViewListDTO {
        private int totalPages;
        private List<ReviewPreviewDTO> reviews;
    }

    //week9
    @Getter
    @Builder
    public static class MissionPreviewDTO {
        private Long missionId;
        private String text;
        private Integer star;
    }

    //week9
    @Getter
    @Builder
    public static class MissionPreViewListDTO {
        private int totalPages;
        private List<MissionPreviewDTO> mission;
    }


}
