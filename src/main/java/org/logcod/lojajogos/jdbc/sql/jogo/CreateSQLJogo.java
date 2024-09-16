package org.logcod.lojajogos.jdbc.sql.jogo;

public class CreateSQLJogo {

	public static String naoDisponivel() {
		return "update jogo set disponivel = false where jogo.numero = ? ";
	}

	public static String insertJogo() {
		return  "insert into jogo (idjogo,numero,disponivel) values (?,?,?)";
	}

	public static String getNaoDisponivel() {
		return "update jogo set disponivel = false where jogo.idjogo = ? ";
	}

	public static String all() {
		return  "update jogo set disponivel = true where jogo.idjogo > 0 ";
	}

	public static String disponivelMilhar() {
			return "update jogo set disponivel = true where jogo.numero = ? ";
	}

	public static String disponivel() {
		return "update jogo set disponivel = true where jogo.numero = ? ";
	}

}
