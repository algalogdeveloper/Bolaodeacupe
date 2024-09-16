package org.logcod.lojajogos.jdbc.queries.aposta;

public class CreateNamedQueryAposta {

	public static String consultarApostas() {
		// TODO Auto-generated method stub
		return "select * from aposta";
	}

	public static String maxId() {
		// TODO Auto-generated method stub
		return "select max(idaposta) as id from aposta";
	}

	public static String obter() {
		// TODO Auto-generated method stub
		return "select * from aposta a where a.idaposta = ?";
	}

	public static String apostaPorNumero() {
		// TODO Auto-generated method stub
		return "select * from endereco e " + "inner join pessoa p on e.idendereco = p.idendereco "
				+ "inner join compra c on p.idpessoa = c.idpessoa "
				+ "inner join aposta a on c.idcompra=a.idcompra "
				+ "inner join jogo j on a.idjogo=j.idjogo where j.numero like ?";
	}

	public static String listaCompletadeApostaPorCliente() {
		// TODO Auto-generated method stub
		return "select * from aposta a ";
	}

	public static String consultarApostasIdCompra() {
		// TODO Auto-generated method stub
		return "select * from aposta a where a.idcompra = ?";
	}

	public static String consultarApostasNumero() {
		// TODO Auto-generated method stub
		return "select * from aposta a where a.numero like ?";
	}

}
