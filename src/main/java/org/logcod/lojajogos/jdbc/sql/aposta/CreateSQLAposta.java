package org.logcod.lojajogos.jdbc.sql.aposta;

public class CreateSQLAposta {

	public static String save() {
		// TODO Auto-generated method stub
		return "insert into aposta (idaposta,idjogo,dataAposta,idcompra) values (?,?,?,?) ";
	}

	public static String obterPorCompraEAposta() {
		// TODO Auto-generated method stub
		return "select * from aposta a where a.idaposta = ? and a.idcompra = ? ";
	}

	public static String remove() {
		// TODO Auto-generated method stub
		return "delete from aposta where idaposta = ?";
	}

	public static String removerMilharAhMais() {
		// TODO Auto-generated method stub
		return "";
	}

	

}
