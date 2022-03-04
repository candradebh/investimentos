package dev.carlosandrade.microservice.investimento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.carlosandrade.microservice.investimento.model.Carteira;
import dev.carlosandrade.microservice.investimento.service.CarteiraService;

@RestController
@RequestMapping("/carteira")
public class CarteiraController {
	
	
	@Autowired
	private CarteiraService carteiraService;
	
	
	@RequestMapping("/{id}")
	public Carteira getById(@PathVariable("id") Long id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return carteiraService.getById(id);
	}
	
	@GetMapping("/ola")
    public String ola() {
		//Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //return "Ola\n" + authentication.toString();
		return "Ola";
    }
}
