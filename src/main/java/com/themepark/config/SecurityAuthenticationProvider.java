package com.themepark.config;

import org.omg.CORBA.UnknownUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.themepark.model.AppUser;
import com.themepark.repository.AppUserRepository;

/**
 * @author Bharath P
 * @createdOn 21-Mar-2017
 */
@CrossOrigin
@Component
public class SecurityAuthenticationProvider implements AuthenticationProvider {

	private final AppUserRepository appUserRepository;

	@Autowired
	public SecurityAuthenticationProvider(final AppUserRepository appUserRepository) {
		this.appUserRepository = appUserRepository;
	}

	@Override
	public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
		final DemoAuthenticationToken demoAuthentication = (DemoAuthenticationToken) authentication;
		final AppUser user = this.appUserRepository.findOne(demoAuthentication.getUid());

		if (user == null) {
			try {
				throw new UnknownUserException();
			} catch (final UnknownUserException e) {
				e.printStackTrace();
			}
		}

		return user;
	}

	@Override
	public boolean supports(final Class<?> authentication) {
		return DemoAuthenticationToken.class.isAssignableFrom(authentication);
	}
}
