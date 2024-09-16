package org.logcod.lojajogos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.logcod.lojajogos.config.ContextConfigDataSource;
import org.logcod.lojajogos.config.util.Informacoes;
import org.logcod.lojajogos.jdbc.sql.ganhador.CreateSQLGanhador;
import org.logcod.lojajogos.model.entity.Ganhador;
import org.logcod.lojajogos.service.CompraService;
import org.logcod.lojajogos.service.MilharService;

public class RepositorioGanhador {
	Connection connection;
	MilharService ms = new MilharService();
	CompraService cs = new CompraService();
	ContextConfigDataSource dataSource;

	public RepositorioGanhador() {

		dataSource = ContextConfigDataSource.jdbcConectBD();
		connection = dataSource.aberta();
	}
	public int save(Ganhador ganhador) {
		try {
			PreparedStatement ps = connection
					.prepareStatement(CreateSQLGanhador.save());
		    ps.setInt(1, ganhador.getPosicao());
			ps.setString(2, ganhador.getPessoa());
			ps.setString(3, ganhador.getEndereco());
			ps.setString(4, ganhador.getMilhar());
			ps.setString(5, ganhador.getPagou());
			return ps.executeUpdate();
		} catch (SQLException e) {
			Informacoes.SOP(e.getLocalizedMessage());
			return -1;
		}

	}
	
	
	public int update(Ganhador ganhador) {
		try {
			PreparedStatement ps = connection
					.prepareStatement(CreateSQLGanhador
							.merge(ganhador.getPosicao()));
		    ps.setInt(1, ganhador.getPosicao());
			ps.setString(2, ganhador.getPessoa());
			ps.setString(3, ganhador.getEndereco());
			ps.setString(4, ganhador.getMilhar());
			ps.setString(5, ganhador.getPagou());
			return ps.executeUpdate();
		} catch (SQLException e) {
			Informacoes.SOP(e.getLocalizedMessage());
			return -1;
		}

	}
	
	public List<Ganhador> listaDeGanhadoresTemporaria(){
		try {
			PreparedStatement ps = connection
					.prepareStatement(CreateSQLGanhador.listaDeGanhadoresTemporaria());
			ResultSet rs = ps.executeQuery();
			List<Ganhador> lista = new ArrayList<Ganhador>();
			while(rs.next()) {
				Ganhador g = new Ganhador();
				g.setPosicao(rs.getInt(1));
				g.setPessoa(rs.getString(2));
				g.setEndereco(rs.getString(3));
				g.setMilhar(rs.getString(4));
				g.setPagou(rs.getString(5));
				lista.add(g);
			}
			return lista;			
		} catch (Exception e) {
			return null;
		}
		
	}
	public void limparListaGanhadores() {
		try {
			PreparedStatement ps = connection.prepareStatement(CreateSQLGanhador.limparListaGanhadores());
			ps.execute();
		} catch (Exception e) {
			Informacoes.SOP(e.getLocalizedMessage());
		}
		
	}


}
