package umc.spring.study.converter;

import org.springframework.data.domain.Page;
import umc.spring.study.domain.User;
import umc.spring.study.domain.Store;
import umc.spring.study.domain.Review;
import umc.spring.study.web.dto.ReviewRequestDTO;
import umc.spring.study.web.dto.ReviewResponseDTO;
import umc.spring.study.web.dto.ReviewRequestDTO;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class ReviewConverter {

    public static ReviewResponseDTO.AddReviewResultDTO AddReviewResultDTO(Review review){
        return ReviewResponseDTO.AddReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.AddReviewDto request, Store store, User user){

        return Review.builder()
                .text(request.getText())
                .star(request.getStar())
                .store(store)
                .user(user)
                .build();
    }

    //week9
    public static ReviewResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewPage) {
        return ReviewResponseDTO.ReviewPreViewListDTO.builder()
                .totalPages(reviewPage.getTotalPages())
                .reviews(
                        reviewPage.stream()
                                .map(review -> ReviewResponseDTO.ReviewPreviewDTO.builder()
                                        .reviewId(review.getId())
                                        .text(review.getText())
                                        .star((int) review.getStar())
                                        .build())
                                .collect(Collectors.toList())
                )
                .build();
    }
}
