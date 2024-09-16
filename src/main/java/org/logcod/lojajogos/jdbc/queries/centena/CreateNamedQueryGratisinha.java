package org.logcod.lojajogos.jdbc.queries.centena;

public class CreateNamedQueryGratisinha {

	public static String maxCentenaGratisinha() {
		// TODO Auto-generated method stub
		return "select max(id_centena) as id_centena from centena_gratisinha";
	}

	public static String qtdCentenaGratisinha() {
		// TODO Auto-generated method stub
		return "select count(id_centena) as id_centena from centena_gratisinha";
	}

	public static String obter() {
		// TODO Auto-generated method stub
		return "select * from centena_gratisinha cg where cg.id_centena = ?";
	}

	public static String all() {
		// TODO Auto-generated method stub
		return "select * from centena_gratisinha cg order by cg.numero";
	}

	public static String obter2() {
		// TODO Auto-generated method stub
		return "select * from centena_gratisinha cg where cg.numero = ?";
	}

	public static String find() {
		// TODO Auto-generated method stub
		return "select * from centena_gratisinha cg where cg.numero = ?";
	}

}
