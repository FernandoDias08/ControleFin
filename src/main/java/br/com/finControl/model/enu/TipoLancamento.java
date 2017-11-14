package br.com.finControl.model.enu;

public enum TipoLancamento {

	PAGAR("À Pagar"),
	RECEBER("À Receber");
	
	private String descricao;
	
	TipoLancamento(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
