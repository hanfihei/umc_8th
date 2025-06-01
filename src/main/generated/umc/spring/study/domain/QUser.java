package umc.spring.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 610669650L;

    public static final QUser user = new QUser("user");

    public final umc.spring.study.domain.common.QBaseEntity _super = new umc.spring.study.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<umc.spring.study.domain.enums.Gender> gender = createEnum("gender", umc.spring.study.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DatePath<java.time.LocalDate> inactiveDate = createDate("inactiveDate", java.time.LocalDate.class);

    public final StringPath name = createString("name");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<Review, QReview> reviewList = this.<Review, QReview>createList("reviewList", Review.class, QReview.class, PathInits.DIRECT2);

    public final EnumPath<umc.spring.study.domain.enums.SocialType> socialType = createEnum("socialType", umc.spring.study.domain.enums.SocialType.class);

    public final StringPath specAddress = createString("specAddress");

    public final EnumPath<umc.spring.study.domain.enums.UserStatus> status = createEnum("status", umc.spring.study.domain.enums.UserStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final ListPath<umc.spring.study.domain.mapping.UserAgree, umc.spring.study.domain.mapping.QUserAgree> userAgreeList = this.<umc.spring.study.domain.mapping.UserAgree, umc.spring.study.domain.mapping.QUserAgree>createList("userAgreeList", umc.spring.study.domain.mapping.UserAgree.class, umc.spring.study.domain.mapping.QUserAgree.class, PathInits.DIRECT2);

    public final ListPath<umc.spring.study.domain.mapping.UserMission, umc.spring.study.domain.mapping.QUserMission> UserMissionList = this.<umc.spring.study.domain.mapping.UserMission, umc.spring.study.domain.mapping.QUserMission>createList("UserMissionList", umc.spring.study.domain.mapping.UserMission.class, umc.spring.study.domain.mapping.QUserMission.class, PathInits.DIRECT2);

    public final ListPath<umc.spring.study.domain.mapping.UserPrefer, umc.spring.study.domain.mapping.QUserPrefer> userPreferList = this.<umc.spring.study.domain.mapping.UserPrefer, umc.spring.study.domain.mapping.QUserPrefer>createList("userPreferList", umc.spring.study.domain.mapping.UserPrefer.class, umc.spring.study.domain.mapping.QUserPrefer.class, PathInits.DIRECT2);

    public final EnumPath<umc.spring.study.domain.enums.UserStatus> userStatus = createEnum("userStatus", umc.spring.study.domain.enums.UserStatus.class);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

