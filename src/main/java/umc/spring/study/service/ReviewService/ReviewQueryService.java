package umc.spring.study.service.ReviewService;

import org.springframework.data.domain.Page;
import umc.spring.study.domain.Review;

public interface ReviewQueryService {
    void insertReview(String text, double star, Long userId, Long storeId);
    Page<Review> getReviewsByUser(Long userId, int page);
}