package br.com.finControl.repository.filter;

import java.math.BigDecimal;
import java.sql.Date;

public class LancamentoFilter {

	private String descricao;
	private BigDecimal valor;
//	private Date dataVencimento;

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
//	public Date getDataVencimento() {
//		return dataVencimento;
//	}
//	public void setDataVencimento(Date dataVencimento) {
//		this.dataVencimento = dataVencimento;
//	}

}
