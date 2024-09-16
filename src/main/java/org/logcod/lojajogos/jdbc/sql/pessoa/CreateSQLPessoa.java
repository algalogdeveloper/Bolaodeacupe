package org.logcod.lojajogos.jdbc.sql.pessoa;

public class CreateSQLPessoa {

	public static String insertPessoa() {
		return "INSERT INTO pessoa(idpessoa,nome,email,contato,referencia,idendereco,dataregistro) VALUES (?,?,?,?,?,?,?)";
	}

	public static String mergePessoa() {
		return "update pessoa set nome=?,email=?,contato=?,referencia=?,idendereco=? where idpessoa = ?";
	}

	public static String removePessoa() {
		return "delete from pessoa where pessoa.idpessoa = ?";
	}

}
