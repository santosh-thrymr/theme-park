package com.themepark.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AppUserEntryPackage.class)
public abstract class AppUserEntryPackage_ extends com.themepark.model.BaseEntity_ {

	public static volatile SingularAttribute<AppUserEntryPackage, Integer> selectedCount;
	public static volatile SingularAttribute<AppUserEntryPackage, AppUser> appUser;
	public static volatile SingularAttribute<AppUserEntryPackage, EntryPackage> entryPackage;
	public static volatile SingularAttribute<AppUserEntryPackage, Float> price;

}

