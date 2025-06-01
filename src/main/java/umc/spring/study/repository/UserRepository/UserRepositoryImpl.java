package umc.spring.study.repository.UserRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.study.domain.QUser;
import umc.spring.study.domain.User;
import umc.spring.study.web.dto.MyPageDTO;

import static com.querydsl.core.types.Projections.constructor;
import lombok.AllArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QUser user = QUser.user;  // 직접 할당

    @Override
    public MyPageDTO getMyPage(Long userId) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (userId != null) {
            predicate.and(user.id.eq(userId));
        }

        return jpaQueryFactory
                .select(constructor(MyPageDTO.class,
                        user.id,
                        user.name,
                        user.email,
                        user.phoneNumber,
                        user.point
                ))
                .from(user)
                .where(predicate)
                .fetchOne();
    }
    }

