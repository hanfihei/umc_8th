package umc.spring.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.study.validation.annotation.ExistStore;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class StoreResponseDTO {

        @Builder
        @Getter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class AddStoreResultDTO{

            Long storeId;
            LocalDateTime createdAt;
        }

        //week9
        @Builder
        @Getter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class ReviewPreViewListDTO {
            List<ReviewPreViewDTO> reviewList;
            Integer listSize;
            Integer totalPage;
            Long totalElements;
            Boolean isFirst;
            Boolean isLast;
    }

        //week9
        @Builder
        @Getter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class ReviewPreViewDTO {
            String ownerNickname;
            Float score;
            String body;
            LocalDate createdAt;
    }

    //week9
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionPreViewDTO {
        String ownerNickname;
        Float score;
        String body;
        LocalDate createdAt;
    }

    //week9
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionPreViewListDTO {
        List<MissionPreViewDTO> missionList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }


}
