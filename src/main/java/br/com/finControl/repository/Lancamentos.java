package br.com.finControl.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.finControl.model.Lancamento;
import br.com.finControl.repository.helper.lancamento.LancamentosQueries;

public interface Lancamentos extends JpaRepository<Lancamento, Long>, LancamentosQueries{

//	http://docs.spring.io/spring-data/jpa/docs/1.4.1.RELEASE/reference/html/jpa.repositories.html
	
	public Optional<Lancamento> findByvalor(BigDecimal bigDecimal);
	
}
