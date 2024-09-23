CREATE TABLE compra (
	idcompra int4 NOT NULL,
	datajogo date NOT NULL,
	idpessoa int4 NOT NULL,
	pagou bool NOT NULL,
	cancelar bool NULL,
	valor float8 NOT NULL,
	numero_cartela varchar(5) NOT NULL,
	premio varchar(300) NOT NULL,
	qtd_cartela int4 NULL,
	valorbilhete float8 NOT NULL,
	idfuncionario int4 NOT NULL,
        desconto float8 ,
        qtd_no_canhoto int4,
	CONSTRAINT compra_numero_cartela_key UNIQUE (numero_cartela),
	CONSTRAINT compra_pkey PRIMARY KEY (idcompra),
	CONSTRAINT compra_idfuncionario_fkey FOREIGN KEY (idfuncionario) REFERENCES public.funcionario(idfuncionario),
	CONSTRAINT compra_idpessoa_fkey FOREIGN KEY (idpessoa) REFERENCES public.pessoa(idpessoa)
);