package br.com.finControl.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.finControl.model.Lancamento;
import br.com.finControl.repository.Lancamentos;

@Service
public class CadastroLancamentoService {
	
	@Autowired
	private Lancamentos lancamentos;
	
	@Transactional
	public void salvar(Lancamento lancamento){
		
			lancamentos.save(lancamento);
		
	}

}
