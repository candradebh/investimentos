package dev.carlosandrade.microservice.investimento;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Request;

@Configuration
public class ClientConfig {

	private int connectTimeOutMillis = 160000000;
	private int readTimeOutMillis = 160000000;

	@Bean
	public Request.Options options() {
		return new Request.Options(connectTimeOutMillis, readTimeOutMillis);
	}
}
