package dev.carlosandrade.microservice.investimento.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.exception.FallbackDefinitionException;
import dev.carlosandrade.microservice.investimento.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeoutException;

@Service
public class AuthService {

    private static final Logger LOG = LoggerFactory.getLogger(AuthService.class);

    @Autowired
    AuthServiceClient authService;

    // faz a chamada ao servico de autenticacao
    @HystrixCommand(threadPoolKey = "getAccessTokenThreadPool", ignoreExceptions = {TimeoutException.class,
            FallbackDefinitionException.class})
    public ResponseVo getAccessToken(UserDto userDto) {
        UserDto v_userDto = userDto;
        ResponseVo response = null;
        try {
            response = authService.postLogin(v_userDto);
        } catch (Exception e) {
            System.out.println("ERRO" + e.getMessage());
        }

        return response;
    }

    // chamando o getUser la no servidor auth
    public String getUserAuth() {
        return authService.getUser();
    }

    public ResponseVo getAccessTokenFallback(ResponseVo response) {
        ResponseVo v_response = new ResponseVo();
        return v_response;
    }
}
