package io.application;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.authentication.BearerTokenExtractor;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationProcessingFilter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth)  {
		try{
		auth
			.inMemoryAuthentication()
			.withUser("admin").password(passwordEncoder().encode("admin123")).roles("ADMIN")
			.and()
			.withUser("user").password(passwordEncoder().encode("user123")).roles("USER");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error");
		}
	}

	@Override
	protected void configure(HttpSecurity http) {
		try{
		http
			.authorizeRequests()
			.anyRequest().authenticated()
			.and()
			.httpBasic()
			.and()
			.formLogin().permitAll();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error");
		}
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public AuthenticationSuccessHandler successHandler() {
	    SimpleUrlAuthenticationSuccessHandler handler = new SimpleUrlAuthenticationSuccessHandler();
	    handler.setUseReferer(true);
	    return handler;
	}
	

	// OAuth PART DOESN'T WORK PROPERLY
	/*
	
	 private OAuth2AuthenticationProcessingFilter getOAuth2AuthenticationProcessingFilter() {
	        BearerTokenExtractor tokenExtractor = new BearerTokenExtractor();
	        OAuth2AuthenticationManager manager = new OAuth2AuthenticationManager();
	        manager.setTokenServices(tokenService());
	        OAuth2AuthenticationProcessingFilter filter = new OAuth2AuthenticationProcessingFilter();
	        filter.setTokenExtractor(tokenExtractor);
	        filter.setAuthenticationManager(manager);
	        return filter;

	    }
	
	
	 @Bean
	 @Primary
	    public ResourceServerTokenServices tokenService() {
	        RemoteTokenServices tokenServices = new RemoteTokenServices();
	        tokenServices.setClientId("758522523635-461rkudhrvpv7ja4incpod8iojetr0mu.apps.googleusercontent.com");
	        tokenServices.setClientSecret("lBniwwcVpZ8JgV1mBhSJS9sh");
	        tokenServices.setCheckTokenEndpointUrl("http://www.googleapis.com/oauth2/v3/token");
	        return tokenServices;
	    }
	    
	    */
	
	
}
