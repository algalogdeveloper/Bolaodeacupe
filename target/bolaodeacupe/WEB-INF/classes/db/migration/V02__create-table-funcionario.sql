CREATE TABLE funcionario (
	idfuncionario int4 NOT NULL,
	nome varchar(200) NOT NULL,
	contato varchar(20) NULL,
	login varchar(50) NOT NULL,
	senha varchar(30) NOT NULL,
	permissao int4 NULL,
	email varchar(50) NULL,
	CONSTRAINT funcionario_email_key UNIQUE (email),
	CONSTRAINT funcionario_login_key UNIQUE (login),
	CONSTRAINT funcionario_pkey PRIMARY KEY (idfuncionario)
);