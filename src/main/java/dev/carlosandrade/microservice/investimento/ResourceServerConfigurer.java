package dev.carlosandrade.microservice.investimento;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
public class ResourceServerConfigurer extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		
		//http.authorizeRequests().antMatchers(HttpMethod.GET, "/**").hasRole("USER");	
		//http.authorizeRequests().antMatchers(HttpMethod.GET, "/carteira/**").hasRole("USER");
		//http.authorizeRequests().antMatchers(HttpMethod.POST, "/carteira/**").hasRole("USER");
		
		//http.authorizeRequests().antMatchers("/carteira/**").permitAll();	//permitindo so essa
	
	}
}
