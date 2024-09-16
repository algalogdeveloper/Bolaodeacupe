package org.logcod.lojajogos.jdbc.sql.ganhador;

public class CreateSQLGanhador {

	public static String save() {
		// TODO Auto-generated method stub
		return "insert into ganhador (posicao,pessoa,endereco,milhar,pagou) values (?,?,?,?,?) ";
	}

	public static String merge(int posicao) {
		// TODO Auto-generated method stub
		return "update ganhador set posicao= ?, pessoa=?,endereco=?,milhar=?,pagou=? where posicao =  "+posicao;
	}

	public static String limparListaGanhadores() {
		// TODO Auto-generated method stub
		return "DELETE FROM ganhador WHERE posicao > 0";
	}

	public static String listaDeGanhadoresTemporaria() {
		// TODO Auto-generated method stub
		return "SELECT * FROM ganhador g";
	}

}
