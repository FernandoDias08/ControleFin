package br.com.finControl.repository.helper.lancamento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.finControl.model.Lancamento;
import br.com.finControl.repository.filter.LancamentoFilter;

public interface LancamentosQueries {

	public Page<Lancamento> filtrar(LancamentoFilter filtro, Pageable pageable);
}
