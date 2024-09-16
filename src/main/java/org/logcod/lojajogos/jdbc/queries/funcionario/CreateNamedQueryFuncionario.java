package org.logcod.lojajogos.jdbc.queries.funcionario;

public class CreateNamedQueryFuncionario {

	public static String obter() {
		// TODO Auto-generated method stub
		return "select * from funcionario f where f.email like ?";
	}

	public static String logar() {
		// TODO Auto-generated method stub
		return "select * from funcionario f where f.login like ? and f.senha like ?";
	}

	public static String maxId() {
		// TODO Auto-generated method stub
		return "select max(idfuncionario) as id from funcionario f";
	}

	public static String consultarFuncionarios() {
		// TODO Auto-generated method stub
		return "select * from funcionario f where f.nome like ? or f.email like ?";
	}

	public static String get() {
		// TODO Auto-generated method stub
		return "select * from funcionario f limit ?";
	}

	public static String unique() {
		// TODO Auto-generated method stub
		return "select * from funcionario f where f.idfuncionario = ?";
	}

	public static String validarFuncionario() {
		// TODO Auto-generated method stub
		return "select * from funcionario f where f.login like ? and f.senha like ?";
	}

	

}
