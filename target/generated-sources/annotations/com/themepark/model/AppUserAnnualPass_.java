package com.themepark.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AppUserAnnualPass.class)
public abstract class AppUserAnnualPass_ extends com.themepark.model.BaseEntity_ {

	public static volatile SingularAttribute<AppUserAnnualPass, Integer> selectedCount;
	public static volatile SingularAttribute<AppUserAnnualPass, AppUser> appUser;
	public static volatile SingularAttribute<AppUserAnnualPass, AnnualPass> annualPass;
	public static volatile SingularAttribute<AppUserAnnualPass, Float> price;

}

