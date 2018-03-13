package com.themepark.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;

import com.themepark.repository.AppUserRepository;
import com.themepark.service.AppUserService;

@CrossOrigin
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AppUserService appUserService;

	@Autowired
	private SecurityAuthenticationProvider demoAuthenticationProvider;

	@Autowired
	private AccessDeniedHandler accessDeniedHandler;

	@Override
	public void configure(final WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/" , "/login**", "/logout", "/js/**", "/css/**", "/imgages/**", "/fonts/**", "/webjars/**");
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {

		http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());

		http.csrf().disable().authorizeRequests()

				.antMatchers("/registration/**").hasAnyAuthority("SUPER_ADMIN", "USER")

				.anyRequest().authenticated().and()

				.addFilterBefore(new AuthenticationFilter(this.appUserService), BasicAuthenticationFilter.class)
				.exceptionHandling().accessDeniedHandler(this.accessDeniedHandler);
	}

	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(this.demoAuthenticationProvider);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}