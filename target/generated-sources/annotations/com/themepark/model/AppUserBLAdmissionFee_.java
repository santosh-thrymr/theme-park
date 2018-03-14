package com.themepark.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AppUserBLAdmissionFee.class)
public abstract class AppUserBLAdmissionFee_ extends com.themepark.model.BaseEntity_ {

	public static volatile SingularAttribute<AppUserBLAdmissionFee, AppUser> appUser;
	public static volatile SingularAttribute<AppUserBLAdmissionFee, BigLondonAdmissionFee> bigLondonAdmissionFee;
	public static volatile SingularAttribute<AppUserBLAdmissionFee, Integer> kidsOrSrCitizenSelectedCount;
	public static volatile SingularAttribute<AppUserBLAdmissionFee, Float> kidsOrSrCitizenPrice;
	public static volatile SingularAttribute<AppUserBLAdmissionFee, Integer> adultSelectedCount;
	public static volatile SingularAttribute<AppUserBLAdmissionFee, Float> adultsPrice;

}

