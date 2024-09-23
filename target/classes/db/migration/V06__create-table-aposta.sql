CREATE TABLE aposta (
	idaposta int4 NOT NULL,
	idjogo int4 NOT NULL,
	dataaposta date NOT NULL,
	idcompra int4 NOT NULL,
	CONSTRAINT aposta_idjogo_key UNIQUE (idjogo),
	CONSTRAINT aposta_pkey PRIMARY KEY (idaposta),
	CONSTRAINT aposta_idcompra_fkey FOREIGN KEY (idcompra) REFERENCES public.compra(idcompra),
	CONSTRAINT aposta_idjogo_fkey FOREIGN KEY (idjogo) REFERENCES public.jogo(idjogo)
);