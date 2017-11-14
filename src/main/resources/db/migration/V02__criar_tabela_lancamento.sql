CREATE TABLE fin_lancamentos (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	tipo_lancamento VARCHAR(50) NOT NULL,
	descricao VARCHAR(100) NOT NULL,
	valor DECIMAL(10,2) NOT NULL,
	data_vencimento DATE NOT NULL
	

	
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
