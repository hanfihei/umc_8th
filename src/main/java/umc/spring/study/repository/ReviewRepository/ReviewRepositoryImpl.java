package umc.spring.study.repository.ReviewRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.study.domain.*;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final EntityManager entityManager;

    @Override
    public void insertReview(String text, Double star, Long userId, Long storeId){
        User user = null;
        Store store = null;

        if (userId != null){
            user = jpaQueryFactory.selectFrom(QUser.user)
                    .where(QUser.user.id.eq(userId))
                    .fetchOne();
        }
        if (storeId != null){
            store = jpaQueryFactory.selectFrom(QStore.store)
                    .where(QStore.store.storeId.eq(storeId))
                    .fetchOne();
        }
        if (user == null || store == null) {
            throw new IllegalArgumentException("유효하지 않은 사용자 또는 가게 ID입니다.");
        }

        if (text != null && star != null && user != null && store != null) {
            Review review = Review.builder()
                    .text(text)
                    .star(star)
                    .user(user)
                    .store(store)
                    .build();
            entityManager.persist(review);
        }
    }
}