package dev.carlosandrade.microservice.investimento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
@EnableScheduling
@EnableResourceServer
public class InvestimentosApplication {
	
	@Bean
	public RequestInterceptor getInterceptorDeAutenticacao() {
		return new RequestInterceptor() {
			@Override
			public void apply(RequestTemplate template) {
				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				if(authentication == null) {
					return;
				}
				
				OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)authentication.getDetails();
				template.header("Authorization", "Bearer" + details.getTokenValue());
			}
		};
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/").allowedOrigins("http://localhost:8081");
			}
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(InvestimentosApplication.class, args);
	}

}
