CREATE TABLE jogo (
	idjogo int4 NOT NULL,
	numero varchar(4) NOT NULL,
	disponivel bool NOT NULL,
	CONSTRAINT jogo_numero_key UNIQUE (numero),
	CONSTRAINT jogo_pkey PRIMARY KEY (idjogo)
);