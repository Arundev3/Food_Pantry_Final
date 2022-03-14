package com.group2.project.capstone.conzfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import com.group2.project.capstone.service.MemberService;
import com.group2.project.capstone.service.StoreService;

@Configuration
@Order(99)
public class StoreSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private StoreService storeService;
	
	//@Lazy
	@Bean
	public BCryptPasswordEncoder storePasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//@Lazy
	@Bean
	public DaoAuthenticationProvider storeAuthenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(storeService);
		auth.setPasswordEncoder(storePasswordEncoder());
		return auth;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(storeAuthenticationProvider());
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.requestMatcher(new AntPathRequestMatcher("/stores/PantryStore_Login**"))
		.csrf().disable()
		.authorizeRequests()
		.antMatchers(
				"/stores/PantryStore_Login**", 
					"/js/**",
					"/css/**",
					"/img/**").permitAll()
		.and()
		.formLogin()
		.loginPage("/stores/PantryStore_Login")
		.defaultSuccessUrl("/welcome")
		.permitAll()
		.and()
		.logout()
		.invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/home?logout")
		.permitAll();
	}

}
