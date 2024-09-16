package org.logcod.lojajogos.jdbc.queries.jogo;

import java.util.Objects;

public class CreateNamedQueryJogo {

    public static String retornaChave() {
        return "select max(idjogo) as id from jogo j";
    }

    public static String getJogo() {
        return "SELECT * FROM jogo jg  WHERE jg.numero like ? and jg.disponivel";
    }

    public static String findJogo() {
        return "SELECT * FROM jogo jg  WHERE jg.numero like ?";
    }

    public static String getJogoId() {
        return "SELECT * FROM jogo jg WHERE jg.idjogo =  ? ";
    }

    public static String getJogos(String value) {
        String query;
        if (Objects.isNull(value) || Objects.equals(value, "")) {
            query = "SELECT idjogo,numero,disponivel FROM jogo limit 15 ";

        } else {
            query = "SELECT * FROM jogo jg where jg.numero like '%" + value + "' limit 10 ";
        }
        return query;
    }

    public static String selecioneMilharVendidos() {
        return "SELECT * FROM jogo where numero like ? and  not disponivel order by numero  limit 100";
    }

    public static String createQueryMilharVinculadoAhPessoa() {
        String query = "select j.idjogo as idjogo, j.numero as numero, j.disponivel as disponivel from pessoa p inner join compra c"
                + " on p.idpessoa = c.idpessoa inner join aposta a"
                + " on c.idcompra = a.idcompra inner join jogo j "
                + " on a.idjogo = j.idjogo where j.numero like ? and not j.disponivel ";
        return query;

    }

}
