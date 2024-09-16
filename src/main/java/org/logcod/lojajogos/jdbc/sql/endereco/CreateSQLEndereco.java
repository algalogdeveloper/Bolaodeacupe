package org.logcod.lojajogos.jdbc.sql.endereco;

public class CreateSQLEndereco {

	public static String insertEndereco() {
		return "insert into endereco (idendereco,descricao,cidade) values (?,?,?)";
	}

	public static String mergeEndereco() {
		// TODO Auto-generated method stub
		return "update endereco set descricao=?,cidade=? where idendereco = ?";
	}

	public static String removeEndereco() {
		// TODO Auto-generated method stub
		return "delete from endereco where idendereco = ? ";
	}

}
