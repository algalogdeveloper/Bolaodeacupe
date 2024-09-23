CREATE TABLE endereco (
	idendereco int4 NOT NULL,
	descricao varchar(100) NOT NULL,
	cidade varchar(100) NOT NULL,
	CONSTRAINT endereco_pkey PRIMARY KEY (idendereco)
);