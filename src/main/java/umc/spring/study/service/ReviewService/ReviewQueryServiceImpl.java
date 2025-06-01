package umc.spring.study.service.ReviewService;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.study.apiPayload.code.status.ErrorStatus;
import umc.spring.study.apiPayload.exception.handler.GeneralException;
import umc.spring.study.domain.Review;
import umc.spring.study.domain.User;
import umc.spring.study.repository.ReviewRepository.ReviewRepository;
import umc.spring.study.repository.UserRepository.UserRepository;
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;

    @Override
    public void insertReview(String content, double star, Long userId, Long storeId){
        reviewRepository.insertReview(content, star, userId, storeId);
    }

    @Override
    public Page<Review> getReviewsByUser(Long userId, int page) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));

        Pageable pageable = PageRequest.of(page, 10);
        return reviewRepository.findAllByUser(user, pageable);
    }
}