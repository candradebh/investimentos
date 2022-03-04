package dev.carlosandrade.microservice.investimento.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.carlosandrade.microservice.investimento.model.Carteira;
import dev.carlosandrade.microservice.investimento.service.CarteiraService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	
	
	@PostMapping("/login")
    public String ola() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Map<String, String> response = new HashMap<String, String>();
		String string = null;
		if(string != null) {
				
			}
		return authentication.toString();
    }
}
