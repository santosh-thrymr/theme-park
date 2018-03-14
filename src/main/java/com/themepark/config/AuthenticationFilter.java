package com.themepark.config;

import java.io.IOException;

import javax.security.sasl.AuthenticationException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.filter.OncePerRequestFilter;

import com.themepark.Constants;
import com.themepark.model.AppUser;
import com.themepark.service.AppUserService;

@CrossOrigin
public class AuthenticationFilter extends OncePerRequestFilter {
	private AppUserService appUserService;

	public AuthenticationFilter(final AppUserService appUserService) {
		super();
		this.appUserService = appUserService;
	}

	@Override
	protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response,
			final FilterChain filterChain) throws ServletException, IOException {

		System.out.println("  ---  url " + request.getRequestURL());

		HttpSession httpSession = request.getSession();
		Long appUserId = (Long) httpSession.getAttribute(Constants.LOGGED_IN_USER_ID);

		try {
			AppUser appUser = this.appUserService.getLoggedInUser(appUserId);
			if (appUser == null) {
				System.out.println("request.getContextPath() : " + request.getContextPath());
				response.sendRedirect("/");
				return;
			}
			System.out.println("appuser : " + appUser);

			// Create our Authentication and let Spring know about it
			final Authentication auth = new DemoAuthenticationToken(appUser.getAuthorities(), appUser, appUser.id);
			SecurityContextHolder.getContext().setAuthentication(auth);

			filterChain.doFilter(request, response);

		} catch (SecurityException | AuthenticationException se) {
			se.printStackTrace();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
