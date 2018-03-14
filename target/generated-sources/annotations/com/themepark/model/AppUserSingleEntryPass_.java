package com.themepark.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AppUserSingleEntryPass.class)
public abstract class AppUserSingleEntryPass_ extends com.themepark.model.BaseEntity_ {

	public static volatile SingularAttribute<AppUserSingleEntryPass, Integer> myKidOrMyKadCount;
	public static volatile SingularAttribute<AppUserSingleEntryPass, AppUser> appUser;
	public static volatile SingularAttribute<AppUserSingleEntryPass, Float> price;
	public static volatile SingularAttribute<AppUserSingleEntryPass, SingleEntryPass> singleEntryPass;
	public static volatile SingularAttribute<AppUserSingleEntryPass, Integer> standardCount;

}

