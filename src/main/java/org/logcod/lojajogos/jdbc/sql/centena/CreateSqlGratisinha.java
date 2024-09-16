package org.logcod.lojajogos.jdbc.sql.centena;

public class CreateSqlGratisinha {

	public static String save() {
		return "INSERT INTO centena_gratisinha(id_centena,numero,idcompra) VALUES (?,?,?)";
	}

	public static String remove() {
		return "delete from centena_gratisinha where idcompra = ?";
	}

	public static String remove2() {
			return "delete from centena_gratisinha where id_centena = ?";
	}

	public static String merge() {
		return "update centena_gratisinha set numero = ? where id_centena = ?";
	}

}
