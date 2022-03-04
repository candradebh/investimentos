package dev.carlosandrade.microservice.investimento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import dev.carlosandrade.microservice.investimento.model.Carteira;
import dev.carlosandrade.microservice.investimento.repository.CarteiraRepository;


@Service
public class CarteiraService {
	
	@Autowired
	private CarteiraRepository carteiraRepository;
	
	@HystrixCommand(threadPoolKey = "getByIdThreadPool")
	public Carteira getById(Long id) {
		return carteiraRepository.findById(id).orElse(new Carteira());
	}
}
