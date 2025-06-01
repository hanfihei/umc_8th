package umc.spring.study.repository.ReviewRepository;

public interface ReviewRepositoryCustom {
    void insertReview(String text, Double star, Long userId, Long storeId);

}
