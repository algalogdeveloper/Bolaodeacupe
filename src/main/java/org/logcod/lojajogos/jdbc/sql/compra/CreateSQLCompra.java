package org.logcod.lojajogos.jdbc.sql.compra;

public class CreateSQLCompra {

	public static String receberPagamentoParcial() {
		return  "update compra set valor = valor - ? where idcompra = ? and valor >=  ?";
	}

	public static String truncarDataTables() {
		// TODO Auto-generated method stub
		return "truncate table aposta,compra,pessoa";
	}

	public static String habilitarCobranca() {
		// TODO Auto-generated method stub
		return "update compra set pagou = false where idcompra > 0";
	}

	public static String pagarCompra() {
		return "update compra set pagou = true where idcompra = ?";
	}

	public static String insertCompra() {
		// TODO Auto-generated method stub
		return "insert into compra (idcompra,dataJogo,idpessoa,pagou,cancelar,valor,numero_cartela,premio,qtd_cartela,valorBilhete,idfuncionario,desconto,qtd_no_canhoto) "
				+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?) ";
	}

	public static String removeCompra() {
		// TODO Auto-generated method stub
		return "delete from compra c where idcompra = ?";
	}

	public static String alterarQtdValor(int qtd, double valor) {
		// TODO Auto-generated method stub
		return "update compra set valor = valor + " + valor + " , qtd_cartela = qtd_cartela + " + qtd
				+ " where idcompra = ?";
	}

	public static String finalizarPagamento() {
		// TODO Auto-generated method stub
		return "update compra set pagou=true,  dataJogo=current_date , idfuncionario = ? where idcompra = ?";
	}

	public static String alterarPessoa() {
		// TODO Auto-generated method stub
		return "update compra set idpessoa=? where idcompra = ? ";
	}

	public static String alterarMilharPessoa() {
			return "update aposta set idjogo = ? where idaposta = ?";
	}

	public static String voltarPrecoFixo(Integer chave) {
		// TODO Auto-generated method stub
		return "update compra set valor = ? where idcompra = " + chave;
	}

	public static String ativarTodosCartelasParaVenda() {
		// TODO Auto-generated method stub
		return "update jogo set disponivel = true where idjogo > 0";
	}

	public static String ativarCobrancaCliente() {
		// TODO Auto-generated method stub
		return "update compra set pagou = false where idcompra = ? ";
	}

	public static String obterPrecoNormalizado() {
		// TODO Auto-generated method stub
		return  "update compra set valor = ? where idcompra = ? ";
	}

	public static String ajustarValorTalaoCliente() {
		// TODO Auto-generated method stub
		return "update compra set valor = ? where idcompra = ?";
	}

	public static String updateNumeroCartela() {
		// TODO Auto-generated method stub
		return "update compra set numero_cartela = ? where idpessoa=?";
	}

	

}
