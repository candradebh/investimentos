package dev.carlosandrade.microservice.investimento.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import dev.carlosandrade.microservice.investimento.model.Carteira;


@Repository
public interface CarteiraRepository extends CrudRepository<Carteira, Long>{
	
	
}
