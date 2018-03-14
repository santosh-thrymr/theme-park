package com.themepark.model;

import com.themepark.enums.Gender;
import com.themepark.enums.Role;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AppUser.class)
public abstract class AppUser_ extends com.themepark.model.BaseEntity_ {

	public static volatile SingularAttribute<AppUser, String> lastName;
	public static volatile SingularAttribute<AppUser, Role> role;
	public static volatile SingularAttribute<AppUser, String> address;
	public static volatile SingularAttribute<AppUser, Boolean> enableSmsUpdate;
	public static volatile SingularAttribute<AppUser, Gender> gender;
	public static volatile SingularAttribute<AppUser, String> displayName;
	public static volatile SingularAttribute<AppUser, Long> mobileNumber;
	public static volatile SingularAttribute<AppUser, Long> postalCode;
	public static volatile SingularAttribute<AppUser, Integer> phoneIntCallingCode;
	public static volatile SingularAttribute<AppUser, Integer> mobileIntCallingCode;
	public static volatile SingularAttribute<AppUser, byte[]> avatar;
	public static volatile SingularAttribute<AppUser, String> countryOfResidence;
	public static volatile SingularAttribute<AppUser, Boolean> enableEmailUpdate;
	public static volatile SingularAttribute<AppUser, String> firstName;
	public static volatile SingularAttribute<AppUser, String> password;
	public static volatile SingularAttribute<AppUser, Long> phoneNumber;
	public static volatile SingularAttribute<AppUser, String> nationality;
	public static volatile SingularAttribute<AppUser, AppUser> createdBy;
	public static volatile SingularAttribute<AppUser, Date> dob;
	public static volatile SingularAttribute<AppUser, RegistrationDetails> registrationDetails;
	public static volatile SingularAttribute<AppUser, String> email;

}

