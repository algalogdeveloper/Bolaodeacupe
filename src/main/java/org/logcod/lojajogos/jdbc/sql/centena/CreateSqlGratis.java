package org.logcod.lojajogos.jdbc.sql.centena;

public class CreateSqlGratis {

	public static String save() {
		return "INSERT INTO centena_gratis(id_centena,numero,idcompra) VALUES (?,?,?)";
	}

	public static String remove() {
		return "delete from centena_gratis where idcompra = ?";
	}

	public static String remove2() {
		return "delete from centena_gratis where id_centena = ?";
	}

	public static String merge() {
		return "update centena_gratis set numero = ? where id_centena = ?";
	}

}
