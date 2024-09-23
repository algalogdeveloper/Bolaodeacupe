CREATE TABLE centena_gratis (
	id_centena int4 NOT NULL,
	numero varchar(3) NOT NULL,
	idcompra int4 NOT NULL,
	CONSTRAINT centena_gratis_numero_key UNIQUE (numero),
	CONSTRAINT centena_gratis_pkey PRIMARY KEY (id_centena),
	CONSTRAINT centena_gratis_idcompra_fkey FOREIGN KEY (idcompra) REFERENCES public.compra(idcompra)
);