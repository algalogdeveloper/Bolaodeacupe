package org.logcod.lojajogos.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.logcod.lojajogos.config.ContextConfigDataSource;
import org.logcod.lojajogos.config.util.DataSourceUtil;
import org.logcod.lojajogos.model.entity.ListaOrdenada;

public class BeanRelatorioPDFVenda {

	private Connection connection;
	ContextConfigDataSource dataSource;

	public BeanRelatorioPDFVenda() {
		dataSource = ContextConfigDataSource.jdbcConectBD();
		connection = dataSource.aberta();
	}

	

	public List<ListaOrdenada> listaOrdendaEagrupadaVendas() {
		String query = "select e.descricao as descricao ,p.nome as pessoa, c.valor as valor,c.datajogo as datajogo, a.dataaposta as dataaposta, c.qtd_cartela as qtdcartela, count(a.idcompra) as qtd, c.pagou as pagou, e.idendereco as chave  from endereco e inner join pessoa p on e.idendereco = p.idendereco "
				+ " inner join compra c on p.idpessoa = c.idpessoa inner join aposta a on c.idcompra=a.idcompra  "
				+ " where not c.pagou " + " group by e.descricao,p.nome, c.valor,c.datajogo,a.dataaposta,c.qtd_cartela,c.pagou,e.idendereco "
				+ "order by e.descricao";
		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			List<ListaOrdenada> listaAgrupda = new ArrayList<>();
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ListaOrdenada ordenada = new ListaOrdenada();
				ordenada.setChave(rs.getInt("chave"));
				ordenada.setDescricao(rs.getString("descricao"));
				ordenada.setPessoa(rs.getString("pessoa"));
				ordenada.setQtdCartela(rs.getInt("qtdcartela"));
				ordenada.setValor(rs.getDouble("valor"));
				ordenada.setDataAposta(DataSourceUtil.formatDataUtilCalendar(rs.getDate("dataaposta")));
				ordenada.setDataCobranca(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
				ordenada.setQtd(rs.getInt("qtd"));
				ordenada.setPagou(rs.getBoolean("pagou"));
				listaAgrupda.add(ordenada);
			}
			return listaAgrupda;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}


}
