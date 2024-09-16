CREATE TABLE pessoa (
	idpessoa int4 NOT NULL,
	nome varchar(200) NOT NULL,
	email varchar NULL,
	contato varchar NULL,
	referencia varchar NULL,
	idendereco int4 NOT NULL,
	dataregistro date NULL,
	CONSTRAINT pessoa_contato_key UNIQUE (contato),
	CONSTRAINT pessoa_pkey PRIMARY KEY (idpessoa),
	CONSTRAINT pessoa_referencia_key UNIQUE (referencia),
	CONSTRAINT pessoa_idendereco_fkey FOREIGN KEY (idendereco) REFERENCES public.endereco(idendereco)
);