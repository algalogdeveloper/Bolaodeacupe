package org.logcod.lojajogos.jdbc.queries.centena;

public class CreateNamedQueryGratis {

	public static String maxCentenaGratis() {
		// TODO Auto-generated method stub
		return "select max(id_centena) as id_centena from centena_gratis";
	}

	public static String qtdCentenaGratis() {
		// TODO Auto-generated method stub
		return "select count(id_centena) as id_centena from centena_gratis";
	}

	public static String obter() {
		// TODO Auto-generated method stub
		return "select * from centena_gratis cg where cg.id_centena = ?";
	}

	public static String all() {
		// TODO Auto-generated method stub
		return "select * from centena_gratis cg order by cg.numero";
	}

	public static String obter2() {
		// TODO Auto-generated method stub
		return "select * from centena_gratis cg where cg.numero = ?";
	}

	public static String find() {
		// TODO Auto-generated method stub
		return "select * from centena_gratis cg where cg.numero = ?";
	}

}
