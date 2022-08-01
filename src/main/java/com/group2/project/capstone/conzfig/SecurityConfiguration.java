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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.group2.project.capstone.service.MemberService;

@Configuration
//@EnableWebSecurity
//@Order(1)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private MemberService memberService;
	
	@Lazy
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Lazy
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(memberService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	
	@Bean
    public AuthenticationEntryPoint authenticationEntryPoint(){
        BasicAuthenticationEntryPoint entryPoint = 
          new BasicAuthenticationEntryPoint();
        entryPoint.setRealmName("admin realm");
        return entryPoint;
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
//		"/members/Community_Login**", 
//		"/js/**",
//		"/css/**",
//		"/img/**"
		
		http.authorizeRequests().antMatchers(
				"welcome").permitAll()
		.and()
		.formLogin()
		.loginPage("/members/member_login")
		.defaultSuccessUrl("/member_account")
		.permitAll()
		.and()
		.logout()
		.invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/home?logout")
		.permitAll()
		.and()
		.httpBasic()
		.authenticationEntryPoint(authenticationEntryPoint());
	}

}
