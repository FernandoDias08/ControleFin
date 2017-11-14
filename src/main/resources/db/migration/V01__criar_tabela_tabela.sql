CREATE TABLE tabela (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	descricao VARCHAR(50),
	codigo INT NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tabela (descricao, codigo) values ('Venda', 1);