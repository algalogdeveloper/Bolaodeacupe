package org.logcod.lojajogos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import org.logcod.lojajogos.config.ContextConfigDataSource;
import org.logcod.lojajogos.config.util.DataSourceUtil;
import org.logcod.lojajogos.jdbc.queries.aposta.CreateNamedQueryAposta;
import org.logcod.lojajogos.jdbc.queries.compra.CreateNamedQueryCompra;
import org.logcod.lojajogos.model.entity.Aposta;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.model.entity.Local;
import org.logcod.lojajogos.service.ApostaService;
import org.logcod.lojajogos.service.CompraService;
import org.logcod.lojajogos.service.MilharService;
import org.logcod.lojajogos.service.PessoaService;

public class RepositoryConsultas {

    protected static Connection connection = null;
    protected PreparedStatement ps = null;
    protected ResultSet rs = null;
    protected ApostaService as = new ApostaService();
    protected PessoaService psp = new PessoaService();
    protected MilharService ms = new MilharService();
    protected CompraService cs = new CompraService();
    protected static ContextConfigDataSource dataSource;

    public static RepositoryConsultas abrirConsultas() {
        dataSource = ContextConfigDataSource.jdbcConectBD();
        connection = dataSource.aberta();
        return new RepositoryConsultas();
    }

    public List<Compra> listarComprasSemFiltros() {
        try {
            ps = connection.prepareStatement(CreateNamedQueryCompra.listarComprasSemFiltros());
            rs = ps.executeQuery();
            List<Compra> compras = new ArrayList();
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setQtd_cartela(rs.getInt("qtd_cartela"));
                compra.setPremio(rs.getString("premio"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compras.add(compra);
            }
            return compras;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Aposta> buscarGanhadores(String p1, String p2, String p3, String p4, String p5, String p6, String p7,
            String p8, String p9, String p10) {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateNamedQueryCompra.buscarGanhadores());
            ps.setString(1, p1);
            ps.setString(2, p2);
            ps.setString(3, p3);
            ps.setString(4, p4);
            ps.setString(5, p5);
            ps.setString(6, p6);
            ps.setString(7, p7);
            ps.setString(8, p8);
            ps.setString(9, p9);
            ps.setString(10, p10);
            rs = ps.executeQuery();
            System.out.println(ps.toString());
            List<Aposta> apostas = new ArrayList();
            int pos = 1;
            while (rs.next()) {
                Aposta aposta = new Aposta();
                aposta.setIdAposta(pos++);
                aposta.setMilhar(ms.getJogo(rs.getInt("idjogo")));
                aposta.setCompra(cs.get(rs.getInt("idcompra")));
                aposta.setDataAposta(DataSourceUtil.formatDataUtilCalendar(rs.getDate("dataaposta")));
                apostas.add(aposta);
            }
            return apostas;
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        }

    }

    public Collection<Aposta> detalhesAposta(int idCompra) {

        try {
            PreparedStatement ps = connection.prepareStatement(CreateNamedQueryCompra.detalhesAposta());
            ps.setInt(1, idCompra);
            rs = ps.executeQuery();
            Collection<Aposta> apostas = new LinkedHashSet<>();
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
            return null;
        }
    }

    public Collection<Compra> consultarCompraPorPessoa(String filtro) {
        Collection<Compra> compras = new LinkedHashSet<>();
        try {
            ps = connection.prepareStatement(CreateNamedQueryCompra.consultarCompraPorPessoa());
            ps.setString(1, "%" + filtro + "%");
            System.out.println(ps.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setQtd_cartela(rs.getInt("qtd_cartela"));
                compra.setPremio(rs.getString("premio"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compras.add(compra);
            }
            return compras;
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return compras;
        }
    }

    public Collection<Compra> selecionarComprasPeloEnderecoDasPessoas(Local local) {
        try {
            ps = connection.prepareStatement(CreateNamedQueryCompra.selecionarComprasPeloEnderecoDasPessoas());
            ps.setString(1, "%" + local.getDescricao() + "%");
            rs = ps.executeQuery();
            Collection<Compra> compras = new ArrayDeque<>();
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setQtd_cartela(rs.getInt("qtd_cartela"));
                compra.setPremio(rs.getString("premio"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compras.add(compra);
            }
            return compras;
        } catch (SQLException e) {
            return null;
        }

    }

    public Collection<Compra> exibirCartelasPagas(String filtro, String filt) {
        Collection<Compra> compras = new LinkedHashSet<>();
        try {
            ps = connection.prepareStatement(CreateNamedQueryCompra.exibirCartelasPagas());
            ps.setString(1, "%" + filt + "%");
            System.out.println(ps.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setQtd_cartela(rs.getInt("qtd_cartela"));
                compra.setPremio(rs.getString("premio"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compras.add(compra);
            }
            return compras;
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());

            return compras;
        }
    }

    public Collection<Compra> selecioneCartelasVendidasNoDia() {
        try {
            ps = connection.prepareStatement(CreateNamedQueryCompra.selecioneCartelasVendidasNoDia());
            rs = ps.executeQuery();
            Collection<Compra> compras = new ArrayDeque();
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setQtd_cartela(rs.getInt("qtd_cartela"));
                compra.setPremio(rs.getString("premio"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setApostas(as.consultarApostasIdCompra(rs.getInt("idcompra")));
                compras.add(compra);
            }
            return compras;
        } catch (SQLException e) {
            return null;
        }

    }

    public Collection<Compra> listarCompras(int filter) {
        try {
            ps = connection.prepareStatement(CreateNamedQueryCompra.listarCompras());
            ps.setInt(1, filter);
            rs = ps.executeQuery();
            Collection<Compra> compras = new ArrayDeque<>();
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setQtd_cartela(rs.getInt("qtd_cartela"));
                compra.setPremio(rs.getString("premio"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setApostas(as.consultarApostasIdCompra(rs.getInt("idcompra")));
                compras.add(compra);
            }
            return compras;
        } catch (SQLException e) {

            System.out.println(e.getLocalizedMessage());
            return null;
        }

    }

    public Collection<Aposta> consultarApostas() {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateNamedQueryAposta.consultarApostas());
            rs = ps.executeQuery();
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
            System.out.println(e.getCause());
            return null;
        }
    }

    public Collection<Compra> exibirCartelasNaoPagas(String parameter, String filt) {
        Collection<Compra> compras = new ArrayDeque<>();
        try {
            ps = connection.prepareStatement(CreateNamedQueryCompra.exibirCartelasNaoPagas());
            ps.setString(1, "%" + filt + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setQtd_cartela(rs.getInt("qtd_cartela"));
                compra.setPremio(rs.getString("premio"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compras.add(compra);
            }
            return compras;
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return compras;
        }
    }

    public Collection<Compra> listarComprasSemFiltrosCobrador(String filter) {
        try {
            ps = connection.prepareStatement(CreateNamedQueryCompra.listarComprasSemFiltrosCobrador());
            ps.setString(1, filter);
            rs = ps.executeQuery();
            Collection<Compra> compras = new ArrayDeque<>();
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setQtd_cartela(rs.getInt("qtd_cartela"));
                compra.setPremio(rs.getString("premio"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setApostas(as.consultarApostasIdCompra(rs.getInt("idcompra")));
                compras.add(compra);
            }
            return compras;
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        }

    }

}
