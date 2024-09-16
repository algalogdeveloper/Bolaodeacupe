package org.logcod.lojajogos.jdbc.queries.pessoa;

public class CreateNamedQueryPessoa {

	public static String obterPessoaId() {
		// TODO Auto-generated method stub
		return "select * from pessoa p where p.idpessoa = ?";
	}

	public static String consultarPorNomeEmailContato() {
		// TODO Auto-generated method stub
		return "select * from pessoa p where p.nome like ? or p.email like ? or p.contato like ?";
	}

	public static String consultarPorEmailContato() {
		// TODO Auto-generated method stub
		return "select * from pessoa p where p.email like ? or p.contato like ?";
	}

	public static String consultarPorNome() {
		// TODO Auto-generated method stub
		return "select * from pessoa p where p.nome like ?";
	}

	public static String consultarPorContato() {
		// TODO Auto-generated method stub
		return "select * from pessoa p where p.contato like ?";
	}

	public static String consultaNome() {
		// TODO Auto-generated method stub
		return "select * from pessoa p where p.nome like ?";
	}

	public static String maxIdPessoa() {
		// TODO Auto-generated method stub
		return "select max(idpessoa) as idpessoa from pessoa";
	}

}
