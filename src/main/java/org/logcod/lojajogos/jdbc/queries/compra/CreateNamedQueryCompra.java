package org.logcod.lojajogos.jdbc.queries.compra;

public class CreateNamedQueryCompra {

    public static String verificarSeCompraEstaPaga() {
        return "select * from compra c where c.pagou=true and c.idcompra = ?";
    }

    public static String obterCompraPorClienteId() {
        return "select * from compra c where c.idpessoa = ?";
    }

    public static String obterCompraPorClientePorMilharReferencia() {
        return "select * from compra c where c.numero_cartela = ?";
    }

    public static String carregarFaturamentoTotalCartelas() {
        return "select count(idpessoa) as pessoa, sum(valor) as valor, sum(qtd_cartela) as qtd_cart from compra c where pagou";
    }

    public static String carregarFaturamentoTotalCartelasParaReceber() {
        return "select count(idpessoa) as pessoa, sum(valor) as valor, sum(qtd_cartela) as qtd_cart from compra c where not pagou";
    }

    public static String carregarFaturamentoTotalCartelasPagasNoGeral() {
        return "select count(idpessoa) as pessoa, sum(valor) as valor, sum(qtd_cartela) as qtd_cart from compra c";
    }

    public static String vizualizarPagamentosDoDia() {
        return "select * from compra c where c.datajogo = current_date and pagou";
    }

    public static String vizualizarPagamentosHoje() {
        return "select * from compra c where c.datajogo = current_date ";
    }

    public static String obter() {
        return "select * from compra c where c.idcompra = ?";
    }

    public static String obter2() {
        return "select * from compra c where c.idcompra = ? and c.idpessoa = ?";
    }

    public static String consultarCompras() {
        return "select * from compra c where c.idpessoa = ?";
    }

    public static String all() {
        return "select * from compra c";
    }

    public static String selecionarComprasPeloSeuEnderecoDeCadastro() {
        return "select * from endereco e inner join pessoa p on e.idendereco=p.idendereco "
                + "inner join compra c on c.idpessoa = p.idpessoa "
                + "where  e.idendereco = ? and not pagou order by c.idcompra ";
    }
    
    
    public static String selecionarComprasPeloSeuEnderecoDeCadastroListaCompleta() {
        return "select * from endereco e inner join pessoa p on e.idendereco=p.idendereco "
                + "inner join compra c on c.idpessoa = p.idpessoa "
                + "where  e.idendereco = ?  order by c.idcompra ";
    }

    public static String selecionarComprasPeloSeuMilharDeCadastro() {
        // TODO Auto-generated method stub
        return "select  distinct (c.idpessoa ),c.idcompra ,c.numero_cartela ,c.premio ,c.datajogo,c.cancelar ,c.pagou ,c.valor  "
                + "from pessoa p " + "inner join compra c on p.idpessoa=c.idpessoa"
                + " inner join aposta a on c.idcompra=a.idcompra " + "inner join jogo j on a.idjogo=j.idjogo "
                + "where j.numero " + "like ? limit 10 ";
    }

    public static String maxId() {
        return "select max(idcompra) as id from compra";
    }

    public static String pegarValor() {
        // TODO Auto-generated method stub
        return "select max(valor) as get from compra c where idcompra = ? and idpessoa = ?";
    }

    public static String qtdMinCartela() {
        // TODO Auto-generated method stub
        return "select min(qtd_cartela) as minima from compra c ";
    }

    public static String pegarValorValorbilhete() {
        // TODO Auto-generated method stub
        return "select max(valorbilhete) as value from compra c where c.idcompra = ?";
    }

    public static String listaCompletaSemFiltrosCompras() {
        // TODO Auto-generated method stub
        return "select * from endereco e, pessoa p , compra c, aposta a, jogo j "
                + "where e.idendereco = p.idendereco " + "and p.idpessoa = c.idpessoa "
                + "and c.idcompra = a.idcompra " + "and a.idjogo = j.idjogo";
    }

    public static String listaEmabertoCompras() {
        // TODO Auto-generated method stub
        return "select * from compra c where not c.pagou";
    }

    public static String consultarComprasEmabertoCobrador() {
        return "select * from compra c where not c.pagou";
    }

    public static String catalogodeComprasComsuasApostasEmaberto() {
        return "select * from compra c where not c.pagou limit ? offset ?";
    }

    public static String calcularValorPagamentoCurrenteDate() {
        // TODO Auto-generated method stub
        return "select  sum(c2.valor) as valor from  compra c2 where c2.datajogo = current_date and  c2.pagou ";
    }

    public static String joinEnderecoPessoaCompraApostaGerandoPdfEmaberto() {
        // TODO Auto-generated method stub
        return "select distinct (c.idpessoa) as idpessoa,c.idcompra as idcompra,p.nome as nome ,c.datajogo as datajogo ,e.descricao as descricao  ,c.pagou as pagou, c.numero_cartela as numero_cartela, c.valor as valor  from  endereco e  inner join pessoa p on e.idendereco  = p.idendereco \n"
                + "inner join  compra c  on  p.idpessoa  = c.idpessoa inner  join  aposta a on  c.idcompra  = a.idcompra \n"
                + "where  not  pagou order by  e.descricao ";
    }

    public static String filtrarCompraPorFuncionario() {
        // TODO Auto-generated method stub
        return "select  e.idendereco as idendereco  ,\n" + "c.idpessoa as idpessoa  , \n"
                + "c.idcompra as idcompra,\n" + "c.datajogo as datajogo , \n" + "c.pagou as pagou, \n"
                + "c.valor as valor,\n" + "c.numero_cartela  as numero_cartela\n"
                + "from  endereco e  inner join pessoa p \n" + "on e.idendereco  = p.idendereco \n"
                + "inner  join  compra c  \n" + "on p.idpessoa  = c.idpessoa  \n" + "inner  join  funcionario f \n"
                + "on c.idfuncionario  = f.idfuncionario \n" + "where  e.idendereco = ? and  f.idfuncionario = ?\n"
                + " and c.pagou = ?";
    }

    public static String filtrarTodasComprasPorFuncionario() {
        // TODO Auto-generated method stub
        return "select  e.idendereco as idendereco  ,\n" + "c.idpessoa as idpessoa  , \n"
                + "c.idcompra as idcompra,\n" + "c.datajogo as datajogo , \n" + "c.pagou as pagou, \n"
                + "c.valor as valor,\n" + "c.numero_cartela  as numero_cartela\n"
                + "from  endereco e  inner join pessoa p \n" + "on e.idendereco  = p.idendereco \n"
                + "inner  join  compra c  \n" + "on p.idpessoa  = c.idpessoa  \n" + "inner  join  funcionario f \n"
                + "on c.idfuncionario  = f.idfuncionario \n" + "where  e.idendereco = ? and  f.idfuncionario = ?\n";
    }

    public static String consultarMilharClienteQtdEValor() {
        // TODO Auto-generated method stub
        return "select c.idcompra as idcompra,c.numero_cartela as numero_cartela, c.datajogo as datajogo, c.idpessoa as idpessoa, c.qtd_cartela as qtd_cartela,c.pagou as pagou, c.valor as valor "
                + "from endereco e, pessoa p, compra c " + "where e.idendereco = p.idendereco "
                + "and p.idpessoa = c.idpessoa " + "and c.qtd_cartela = ?" + "and c.valor = ?";
    }

    public static String encontrarQuantidadeDeTaloesDoEndereco() {
        // TODO Auto-generated method stub
        return "select sum(c.qtd_cartela) as soma from endereco e , pessoa p , compra c \n"
                + "where  e.idendereco  = p.idendereco  \n" + "and p.idpessoa  = c.idpessoa and e.idendereco = ?";
    }

    public static String buscarCompraClienteMobile() {
        // TODO Auto-generated method stub
        return "select distinct (c.idpessoa ),c.idcompra ,c.numero_cartela ,c.premio ,c.datajogo,c.cancelar ,c.pagou ,c.valor, c.qtd_cartela  "
                + "from pessoa p " + "inner join compra c on p.idpessoa=c.idpessoa  "
                + "inner join aposta a on c.idcompra=a.idcompra " + "inner join jogo j on a.idjogo=j.idjogo "
                + "where j.numero like ? or p.nome like ? limit 15 ";
    }

    public static String qtdTalaoInseridos() {
        // TODO Auto-generated method stub
        return "select sum(c.qtd_cartela) as soma from compra c";
    }

    public static String listarComprasSemFiltros() {
        // TODO Auto-generated method stub
        return "select * from compra ";
    }

    public static String buscarGanhadores() {
        // TODO Auto-generated method stub
        return "select * from endereco e " + "inner join pessoa p on e.idendereco = p.idendereco "
                + "inner join compra c on p.idpessoa = c.idpessoa " + "inner join aposta a on c.idcompra=a.idcompra "
                + "inner join jogo j on a.idjogo=j.idjogo " + "where " + "j.numero like ? " + "or j.numero like ? "
                + "or j.numero like ? " + "or j.numero like ? " + "or j.numero like ? " + "or j.numero like ? "
                + "or j.numero like ? " + "or j.numero like ? " + "or j.numero like ? " + "or j.numero like ?";
    }

    public static String detalhesAposta() {
        // TODO Auto-generated method stub
        return "select * from aposta a where a.idcompra = ?";
    }

    public static String consultarCompraPorPessoa() {
        // TODO Auto-generated method stub
        return "select * from pessoa p, compra c where p.idpessoa= c.idpessoa and  p.nome like ?";
    }

    public static String selecionarComprasPeloEnderecoDasPessoas() {
        // TODO Auto-generated method stub
        return "select * from endereco e\n" + "inner join pessoa p on e.idendereco = p.idendereco\n"
                + "inner join compra c on p.idpessoa = c.idpessoa\n" + "where e.descricao like ?";
    }

    public static String exibirCartelasPagas() {
        // TODO Auto-generated method stub
        return "select * from endereco e " + "inner join pessoa p on e.idendereco = p.idendereco "
                + "inner join compra c on p.idpessoa = c.idpessoa "
                + "where e.descricao like ? and c.pagou = true limit 30";
    }

    public static String selecioneCartelasVendidasNoDia() {
        return "select * from compra c where c.datajogo = current_date and not pagou";
    }

    public static String listarCompras() {
        return "select * from endereco e inner "
                + "join pessoa p on e.idendereco=p.idendereco  inner "
                + "join compra c on c.idpessoa = p.idpessoa "
                + "where e.idendereco = ? ";
    }

    public static String exibirCartelasNaoPagas() {
        return "select * from endereco e\n" + "inner join pessoa p on e.idendereco = p.idendereco\n"
                + "inner join compra c on p.idpessoa = c.idpessoa\n"
                + "where e.descricao like ?  and not c.pagou ";
    }

    public static String listarComprasSemFiltrosCobrador() {
        return "select * from endereco e inner join pessoa p on e.idendereco=p.idendereco "
                + "inner join compra c on c.idpessoa = p.idpessoa where e.descricao = ? ";
    }

    public static String listaCompletaSemFiltrosApostas() {
        return "select * from endereco e, pessoa p , compra c "
                + "where e.idendereco = p.idendereco "
                + "and p.idpessoa = c.idpessoa order by p.nome";
    }

    public static String listaCompletaSemFiltrosApostasConcluidas() {
        return "select * from endereco e, pessoa p , compra c "
                + "where e.idendereco = p.idendereco and c.pagou "
                + "and p.idpessoa = c.idpessoa order by p.nome";
    }

}
