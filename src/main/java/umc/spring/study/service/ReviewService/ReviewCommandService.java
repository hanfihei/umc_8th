package umc.spring.study.service.ReviewService;

import umc.spring.study.web.dto.ReviewRequestDTO;
import umc.spring.study.domain.Review;
import umc.spring.study.web.dto.ReviewResponseDTO;

public interface ReviewCommandService {
    Review joinReview(ReviewRequestDTO.AddReviewDto request,Long storeId);
}
