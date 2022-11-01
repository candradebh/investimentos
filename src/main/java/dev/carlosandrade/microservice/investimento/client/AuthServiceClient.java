package dev.carlosandrade.microservice.investimento.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dev.carlosandrade.microservice.investimento.ClientConfig;
import dev.carlosandrade.microservice.investimento.dto.UserDto;

@FeignClient(value = "auth", configuration = ClientConfig.class)
public interface AuthServiceClient {

	@RequestMapping(value = "/oauth/token", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseVo postLogin(@RequestBody UserDto body);

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	String getUser();

}
