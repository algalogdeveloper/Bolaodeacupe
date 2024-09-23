package org.logcod.lojajogos.jdbc.sql.funcionario;

public class CreateSQLFuncionario {

	

	public static String save() {
		// TODO Auto-generated method stub
		return "insert into funcionario (idfuncionario,nome,contato,login,senha,permissao,email) "
				+ "values (?,?,?,?,?,?,?) ";
	}

	public static String merge() {
		return  "update funcionario set nome=?,contato=?,permissao=?,email=?,senha = ? where idfuncionario = ? ";
	}

}
