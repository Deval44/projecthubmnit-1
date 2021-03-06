package com.mnithelp.projecthub.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.antMatcher("/**").authorizeRequests()
			.antMatchers("/","/oauth/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.oauth2Login()
				.userInfoEndpoint()
				.userService(oauthUserService)
				.and()
			    .successHandler(new AuthenticationSuccessHandler() {
			 
			        @Override
			        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			                Authentication authentication) throws IOException, ServletException {
			 
			            CustomOAuth2User oauthUser = (CustomOAuth2User) authentication.getPrincipal();
			 
			            userService.processOAuthPostLogin(oauthUser.getEmail(),oauthUser.getName());
			 
			            response.sendRedirect("http://localhost:3000");
			            //response.sendRedirect("/custom/api/projects/users/" + oauthUser.getEmail());
			        }
			    });
	}

	@Autowired
	private CustomOAuth2UserService oauthUserService;
	
	@Autowired
	private UserService userService;
	
}
