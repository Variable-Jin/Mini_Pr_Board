package com.agile.demo.api.sample;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSampleEntity is a Querydsl query type for SampleEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSampleEntity extends EntityPathBase<SampleEntity> {

    private static final long serialVersionUID = -565908047L;

    public static final QSampleEntity sampleEntity = new QSampleEntity("sampleEntity");

    public final com.agile.demo.core.base.QBaseEntity _super = new com.agile.demo.core.base.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> savedAt = _super.savedAt;

    //inherited
    public final NumberPath<Long> seq = _super.seq;

    public final StringPath title = createString("title");

    public QSampleEntity(String variable) {
        super(SampleEntity.class, forVariable(variable));
    }

    public QSampleEntity(Path<? extends SampleEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSampleEntity(PathMetadata metadata) {
        super(SampleEntity.class, metadata);
    }

}

