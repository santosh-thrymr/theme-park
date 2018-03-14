package com.themepark.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BigLondonAdmissionFee.class)
public abstract class BigLondonAdmissionFee_ extends com.themepark.model.BaseEntity_ {

	public static volatile SingularAttribute<BigLondonAdmissionFee, Float> adultsMyKRate;
	public static volatile SingularAttribute<BigLondonAdmissionFee, Float> kidsOrSrCitizenMyKRate;
	public static volatile SingularAttribute<BigLondonAdmissionFee, String> description;
	public static volatile SingularAttribute<BigLondonAdmissionFee, Float> adultsStandardRate;
	public static volatile SingularAttribute<BigLondonAdmissionFee, String> type;
	public static volatile SingularAttribute<BigLondonAdmissionFee, Float> kidsOrSrCitizenStandardRate;

}

