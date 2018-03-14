package com.themepark.model;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BaseEntity.class)
public abstract class BaseEntity_ {

	public static volatile SingularAttribute<BaseEntity, Timestamp> createdDate;
	public static volatile SingularAttribute<BaseEntity, Timestamp> lastUpdate;
	public static volatile SingularAttribute<BaseEntity, Long> id;

}

