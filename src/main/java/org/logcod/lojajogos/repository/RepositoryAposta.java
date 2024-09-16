package org.logcod.lojajogos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.logcod.lojajogos.config.ContextConfigDataSource;
import org.logcod.lojajogos.config.util.DataSourceUtil;
import org.logcod.lojajogos.jdbc.queries.aposta.CreateNamedQueryAposta;
import org.logcod.lojajogos.jdbc.queries.compra.CreateNamedQueryCompra;
import org.logcod.lojajogos.jdbc.sql.aposta.CreateSQLAposta;
import org.logcod.lojajogos.model.entity.Aposta;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.service.CompraService;
import org.logcod.lojajogos.service.FuncionarioService;
import org.logcod.lojajogos.service.MilharService;
import org.logcod.lojajogos.service.PessoaService;

public class RepositoryAposta {

	Connection connection;
	MilharService ms = new MilharService();
	CompraService cs = new CompraService();
	ContextConfigDataSource dataSource;
	PessoaService pessoaService = new PessoaService();
	FuncionarioService fs = new FuncionarioService();

	public RepositoryAposta() {
		dataSource = ContextConfigDataSource.jdbcConectBD();
		connection = dataSource.aberta();
	}

	public int maxId() {
		try {
			PreparedStatement ps = connection.prepareStatement(CreateNamedQueryAposta.maxId());
			ResultSet rs = ps.executeQuery();
			rs.next();
			int id = rs.getInt("id");
			return id;
		} catch (SQLException e) {
			return 0;
		}
	}

	public int save(Aposta aposta) {
		try {
			PreparedStatement ps = connection.prepareStatement(CreateSQLAposta.save());
			ps.setInt(1, maxId() + 1);
			ps.setInt(2, aposta.getMilhar().getIdMilhar());
			ps.setDate(3, DataSourceUtil.formatDataUtil());
			ps.setInt(4, aposta.getCompra().getIdCompra());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			return -1;
		}

	}

	public Aposta get(int id) {
		try {
			PreparedStatement ps = connection.prepareStatement(CreateNamedQueryAposta.obter());
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Aposta aposta = new Aposta();
			while (rs.next()) {
				aposta.setIdAposta(rs.getInt("idaposta"));
				aposta.setCompra(cs.get(rs.getInt("idcompra")));
				aposta.setMilhar(ms.getJogo(rs.getInt("idjogo")));
				aposta.setDataAposta(DataSourceUtil.formatDataUtilCalendar(rs.getDate("dataaposta")));

			}
			return aposta;
		} catch (SQLException e) {
			System.out.println("falha: " + e.getLocalizedMessage());
			return null;
		}

	}

	public Aposta apostaPorNumero(String value) {
		try {
			PreparedStatement ps = connection
					.prepareStatement(CreateNamedQueryAposta
							.apostaPorNumero());
			ps.setString(1, value);
			ResultSet rs = ps.executeQuery();
			System.out.println(ps.toString());
			Aposta aposta = new Aposta();
			while (rs.next()) {
				aposta.setIdAposta(rs.getInt("idaposta"));
				aposta.setCompra(cs.get(rs.getInt("idcompra")));
				aposta.setMilhar(ms.getJogo(rs.getInt("idjogo")));
				aposta.setDataAposta(DataSourceUtil.formatDataUtilCalendar(rs.getDate("dataaposta")));

			}
			return aposta;
		} catch (SQLException e) {
			System.out.println("falha: " + e.getLocalizedMessage());
			return null;
		}

	}

	public Aposta get(int idaposta, int idcompra) {
		try {
			PreparedStatement ps = connection
					.prepareStatement(CreateSQLAposta.obterPorCompraEAposta());
			ps.setInt(1, idaposta);
			ps.setInt(2, idcompra);
			ResultSet rs = ps.executeQuery();
			Aposta aposta = null;
			while (rs.next()) {
				aposta = new Aposta();
				aposta.setIdAposta(rs.getInt("idaposta"));
				aposta.setMilhar(ms.getJogo(rs.getInt("idjogo")));
				aposta.setCompra(cs.get(rs.getInt("idcompra")));
				aposta.setDataAposta(DataSourceUtil.formatDataUtilCalendar(rs.getDate("dataaposta")));
			}
			return aposta;
		} catch (SQLException e) {
			System.out.println("falha: " + e.getLocalizedMessage());
			return null;
		}

	}

	public List<Aposta> listaCompletadeApostaPorCliente() {
		try {
			PreparedStatement ps = connection
					.prepareStatement(CreateNamedQueryAposta.listaCompletadeApostaPorCliente());
			ResultSet rs = ps.executeQuery();
			List<Aposta> apostas = new ArrayList<Aposta>();
			while (rs.next()) {
				Aposta aposta = new Aposta();
				aposta.setIdAposta(rs.getInt("idaposta"));
				aposta.setMilhar(ms.getJogo(rs.getInt("idjogo")));
				aposta.setCompra(cs.get(rs.getInt("idcompra")));
				aposta.setDataAposta(DataSourceUtil.formatDataUtilCalendar(rs.getDate("dataaposta")));
				apostas.add(aposta);
			}
			return apostas;
		} catch (SQLException e) {
			System.out.println("falha: " + e.getLocalizedMessage());
			return null;
		}
	}

	public Collection<Aposta> consultarApostasIdCompra(int chavePK) {
		try {
			PreparedStatement ps = connection
					.prepareStatement(CreateNamedQueryAposta.consultarApostasIdCompra());
			ps.setInt(1, chavePK);
			ResultSet rs = ps.executeQuery();
			Collection<Aposta> apostas = new ArrayList<Aposta>();
			while (rs.next()) {
				Aposta aposta = new Aposta();
				aposta.setIdAposta(rs.getInt("idaposta"));
				aposta.setMilhar(ms.getJogo(rs.getInt("idjogo")));
				//aposta.setCompra(cs.get(rs.getInt("idcompra")));
				aposta.setDataAposta(DataSourceUtil.formatDataUtilCalendar(rs.getDate("dataaposta")));
				apostas.add(aposta);
			}
			return apostas;
		} catch (SQLException e) {
			System.out.println("falha: " + e.getLocalizedMessage());
			return null;
		}

	}

	public void deleteAposta(int idaposta) {
		try {
			PreparedStatement ps = connection
					.prepareStatement(CreateSQLAposta.remove());
			ps.setInt(1, idaposta);
			System.out.println(ps.toString());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("erro: " + e.getLocalizedMessage());
		}
	}

	public Collection<Aposta> consultarApostasNumero(String numero) {
		try {
		    PreparedStatement ps = connection
					.prepareStatement(CreateNamedQueryAposta.consultarApostasNumero());
			ps.setString(1, numero);
			ResultSet rs = ps.executeQuery();
			Collection<Aposta> apostas = new ArrayDeque<>();
			while (rs.next()) {
				Aposta aposta = new Aposta();
				aposta.setIdAposta(rs.getInt("idaposta"));
				aposta.setMilhar(ms.getJogo(rs.getInt("idjogo")));
				aposta.setCompra(cs.get(rs.getInt("idcompra")));
				aposta.setDataAposta(DataSourceUtil.formatDataUtilCalendar(rs.getDate("dataaposta")));
				apostas.add(aposta);
			}
			return apostas;
		} catch (SQLException e) {
			System.out.println("falha: " + e.getLocalizedMessage());
			return null;
		}

	}

	public int update(int chavePK) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Compra> listaCompletaSemFiltrosApostas() {
		try {
			PreparedStatement ps = connection.prepareStatement(CreateNamedQueryCompra.listaCompletaSemFiltrosApostas());
			ResultSet rs = ps.executeQuery();
			List<Compra> compras = new ArrayList<Compra>();
			compras.isEmpty();
			while (rs.next()) {
				Compra compra = new Compra();
				compra.setIdCompra(rs.getInt("idcompra"));
				compra.setNumero_cartela(rs.getString("numero_cartela"));
				compra.setPremio(rs.getString("premio"));
				compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
				compra.setPessoa(pessoaService.get(rs.getInt("idpessoa")));
				compra.setCancelar(rs.getBoolean("cancelar"));
				compra.setPagou(rs.getBoolean("pagou"));
				compra.setValor(rs.getDouble("valor"));
				compra.setValorBilhete(rs.getDouble("valorBilhete"));
				compra.setQtd_cartela(rs.getInt("qtd_cartela"));
				compra.setFuncionario(fs.getFuncionario(rs.getInt("idfuncionario")));
				compras.add(compra);

			}
			return compras;
		} catch (SQLException e) {
			System.out.println(e);
			return new ArrayList<>();
		}
	}
        
        
        public List<Compra> listaCompletaSemFiltrosApostasConcluidas() {
		try {
			PreparedStatement ps = connection.prepareStatement(CreateNamedQueryCompra.listaCompletaSemFiltrosApostasConcluidas());
			ResultSet rs = ps.executeQuery();
			List<Compra> compras = new ArrayList<Compra>();
			compras.isEmpty();
			while (rs.next()) {
				Compra compra = new Compra();
				compra.setIdCompra(rs.getInt("idcompra"));
				compra.setNumero_cartela(rs.getString("numero_cartela"));
				compra.setPremio(rs.getString("premio"));
				compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
				compra.setPessoa(pessoaService.get(rs.getInt("idpessoa")));
				compra.setCancelar(rs.getBoolean("cancelar"));
				compra.setPagou(rs.getBoolean("pagou"));
				compra.setValor(rs.getDouble("valor"));
				compra.setValorBilhete(rs.getDouble("valorBilhete"));
				compra.setQtd_cartela(rs.getInt("qtd_cartela"));
				compra.setFuncionario(fs.getFuncionario(rs.getInt("idfuncionario")));
				compras.add(compra);

			}
			return compras;
		} catch (SQLException e) {
			System.out.println(e);
			return new ArrayList<>();
		}
	}
        
        public void removerMilharAhMais(int idaposta) {
        	try {
        		PreparedStatement ps = connection.prepareStatement(CreateSQLAposta.remove());
    			ps.setObject(1, idaposta);
        		ps.execute();
    			System.out.println(ps.toString());
			} catch (SQLException e) {
				System.out.println(e.getLocalizedMessage());
			}
        }

}
