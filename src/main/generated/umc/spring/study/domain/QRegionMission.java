package umc.spring.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRegionMission is a Querydsl query type for RegionMission
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRegionMission extends EntityPathBase<RegionMission> {

    private static final long serialVersionUID = 1443854161L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRegionMission regionMission = new QRegionMission("regionMission");

    public final umc.spring.study.domain.common.QBaseEntity _super = new umc.spring.study.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMission mission;

    public final NumberPath<Integer> missionNumber = createNumber("missionNumber", Integer.class);

    public final QRegion region;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QRegionMission(String variable) {
        this(RegionMission.class, forVariable(variable), INITS);
    }

    public QRegionMission(Path<? extends RegionMission> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRegionMission(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRegionMission(PathMetadata metadata, PathInits inits) {
        this(RegionMission.class, metadata, inits);
    }

    public QRegionMission(Class<? extends RegionMission> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.mission = inits.isInitialized("mission") ? new QMission(forProperty("mission"), inits.get("mission")) : null;
        this.region = inits.isInitialized("region") ? new QRegion(forProperty("region")) : null;
    }

}

