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
import java.util.Objects;
import java.util.Set;
import java.util.Vector;
import org.logcod.lojajogos.config.ContextConfigDataSource;
import org.logcod.lojajogos.config.util.DataSourceUtil;
import org.logcod.lojajogos.jdbc.queries.compra.CreateNamedQueryCompra;
import org.logcod.lojajogos.jdbc.sql.compra.CreateSQLCompra;
import org.logcod.lojajogos.model.entity.Aposta;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.model.entity.Faturamento;
import org.logcod.lojajogos.model.entity.Funcionario;
import org.logcod.lojajogos.model.entity.Local;
import org.logcod.lojajogos.model.entity.Milhar;
import org.logcod.lojajogos.service.ApostaService;
import org.logcod.lojajogos.service.CentenaGratisService;
import org.logcod.lojajogos.service.ConsultasService;
import org.logcod.lojajogos.service.FuncionarioService;
import org.logcod.lojajogos.service.MilharService;
import org.logcod.lojajogos.service.PessoaService;

public class RepositoryCompra {

    protected Connection connection;
    protected PreparedStatement ps;
    protected ContextConfigDataSource dataSource;
    protected ApostaService as = new ApostaService();
    protected PessoaService psp = new PessoaService();
    protected MilharService ms = new MilharService();
    protected ConsultasService cs = new ConsultasService();
    protected FuncionarioService funcionarioService = new FuncionarioService();
    protected CentenaGratisService cgs = new CentenaGratisService();

    public RepositoryCompra() {
        dataSource = ContextConfigDataSource.jdbcConectBD();
        connection = dataSource.aberta();
    }

    public int receberPagamentoParcial(int idcompra, double valor) {
        try {
            ps = connection.prepareStatement(CreateSQLCompra.receberPagamentoParcial());
            ps.setDouble(1, valor);
            ps.setInt(2, idcompra);
            ps.setDouble(3, valor);
            ps.execute();
            System.out.println(ps.toString());
            return obterCompra(idcompra).getIdCompra();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
    }

    public boolean verificarSeCompraEstaPaga(Integer key) {
        try {
            ps = connection.prepareStatement(CreateNamedQueryCompra.verificarSeCompraEstaPaga());
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();
            Compra compra = null;
            if (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setPremio(rs.getString("premio"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setValorBilhete(rs.getDouble("valorBilhete"));
            }
            return Objects.nonNull(compra);
        } catch (SQLException e) {
            return false;
        }
    }

    public Compra obterCompraPorClienteId(int idCliente) {
        try {
            ps = connection.prepareStatement(CreateNamedQueryCompra.obterCompraPorClienteId());
            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();
            Compra compra = null;
            if (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setPremio(rs.getString("premio"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setQtd_cartela(rs.getInt("qtd_cartela"));
                compra.setValorBilhete(rs.getDouble("valorBilhete"));
                compra.setFuncionario(funcionarioService.getFuncionario(rs.getInt("idfuncionario")));
            }
            return compra;

        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return null;

        }
    }

    public Compra obterCompraPorClientePorMilharReferencia(String param) {
        try {
            ps = connection.prepareStatement(CreateNamedQueryCompra.obterCompraPorClientePorMilharReferencia());
            ps.setObject(1, param);
            ResultSet rs = ps.executeQuery();
            Compra compra = null;
            if (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setPremio(rs.getString("premio"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setQtd_cartela(rs.getInt("qtd_cartela"));
                compra.setValorBilhete(rs.getDouble("valorBilhete"));
                compra.setFuncionario(funcionarioService.getFuncionario(rs.getInt("idfuncionario")));
            }
            return compra;

        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return null;

        }
    }

    public boolean truncarDataTables() {
        try {
            ps = connection.prepareStatement(CreateSQLCompra.truncarDataTables());
            return ps.execute();
        } catch (Exception e) {
            return false;
        }
    }

    public Vector<Faturamento> carregarFaturamentoTotalCartelas() {
        try {
            Vector<Faturamento> faturamentos = new Vector<Faturamento>();
            ps = connection.prepareStatement(CreateNamedQueryCompra.carregarFaturamentoTotalCartelas());
            ResultSet rs = ps.executeQuery();
            Faturamento faturamento = null;
            while (rs.next()) {
                faturamento = new Faturamento();
                faturamento.setQtdPessoas(rs.getInt("pessoa"));
                faturamento.setValor(rs.getDouble("valor"));
                faturamento.setQtdCartelas(rs.getInt("qtd_cart"));
                faturamentos.add(faturamento);
            }
            return faturamentos;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    public Vector<Faturamento> carregarFaturamentoTotalCartelasParaReceber() {
        try {
            Vector<Faturamento> faturamentos = new Vector<Faturamento>();
            ps = connection.prepareStatement(CreateNamedQueryCompra.carregarFaturamentoTotalCartelasParaReceber());
            ResultSet rs = ps.executeQuery();
            Faturamento faturamento = null;
            while (rs.next()) {
                faturamento = new Faturamento();
                faturamento.setQtdPessoas(rs.getInt("pessoa"));
                faturamento.setValor(rs.getDouble("valor"));
                faturamento.setQtdCartelas(rs.getInt("qtd_cart"));
                faturamentos.add(faturamento);
            }
            return faturamentos;
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    public Vector<Faturamento> carregarFaturamentoTotalCartelasPagasNoGeral() {
        try {
            Vector<Faturamento> faturamentos = new Vector<Faturamento>();
            ps = connection.prepareStatement(CreateNamedQueryCompra.carregarFaturamentoTotalCartelasPagasNoGeral());
            ResultSet rs = ps.executeQuery();
            Faturamento faturamento = null;
            while (rs.next()) {
                faturamento = new Faturamento();
                faturamento.setQtdPessoas(rs.getInt("pessoa"));
                faturamento.setValor(rs.getDouble("valor"));
                faturamento.setQtdCartelas(rs.getInt("qtd_cart"));
                faturamentos.add(faturamento);
            }
            return faturamentos;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    public Vector<Compra> vizualizarPagamentosDoDia() {
        try {
            ps = connection.prepareStatement(CreateNamedQueryCompra.vizualizarPagamentosDoDia());
            ResultSet rs = ps.executeQuery();
            Vector<Compra> compras = new Vector<Compra>();
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
                compra.setFuncionario(funcionarioService.getFuncionario(rs.getInt("idfuncionario")));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setApostas(as.consultarApostasIdCompra(rs.getInt("idcompra")));
                compras.add(compra);
            }
            return compras;
        } catch (SQLException e) {
            return null;
        }
    }

    public LinkedHashSet<Compra> vizualizarPagamentosHoje() {
        try {
            ps = connection.prepareStatement(CreateNamedQueryCompra.vizualizarPagamentosHoje());
            ResultSet rs = ps.executeQuery();
            LinkedHashSet<Compra> compras = new LinkedHashSet<Compra>();
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
                compra.setFuncionario(funcionarioService.getFuncionario(rs.getInt("idfuncionario")));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setApostas(as.consultarApostasIdCompra(rs.getInt("idcompra")));
                compras.add(compra);
            }
            return compras;
        } catch (SQLException e) {
            return null;
        }
    }

    public Compra get(int chavePK) {
        try {
            ps = connection.prepareStatement(CreateNamedQueryCompra.obter());
            ps.setInt(1, chavePK);
            ResultSet rs = ps.executeQuery();
            Compra compra = null;
            if (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setPremio(rs.getString("premio"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setFuncionario(funcionarioService.getFuncionario(rs.getInt("idfuncionario")));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setQtdAlternativa(rs.getInt("qtd_no_canhoto"));
                compra.setQtd_cartela(rs.getInt("qtd_cartela"));
                compra.setValorBilhete(rs.getDouble("valorbilhete"));
            }
            return compra;

        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return null;

        }

    }

    public boolean habilitarCobranca() {
        try {
            ps = connection.prepareStatement(CreateSQLCompra.habilitarCobranca());
            ps.execute();
            System.out.println(ps.toString());
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    public boolean pagarCompra(int idcompra) {
        try {
            ps = connection.prepareStatement(CreateSQLCompra.pagarCompra());
            ps.setInt(1, idcompra);
            ps.execute();
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    public Compra getPessoa(int idCompra, int idPessoa) {
        try {
            ps = connection.prepareStatement(CreateNamedQueryCompra.obter2());
            ps.setInt(1, idCompra);
            ps.setInt(2, idPessoa);
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            Compra compra = null;
            if (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setPremio(rs.getString("premio"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
            }
            return compra;

        } catch (Exception e) {
            System.out.println("Excessão" + e.getLocalizedMessage());
            return null;

        }

    }

    public boolean inserirMilharParaPessoa(int idCompra, int idPessoa, List<Milhar> milhars) {
        try {
            Compra compra = getPessoa(idCompra, idPessoa);
            boolean insert = false;
            int count = 0;
            for (Milhar milhar : milhars) {
                ms.getNaoDisponivel(milhar.getIdMilhar());
                Aposta aposta = new Aposta(milhar, compra);
                as.save(aposta);
                count++;
            }

            if (milhars.size() == count) {
                insert = true;
            }

            return insert;
        } catch (Exception e) {
            System.out.println("Compras pode ou não ter sido realizada: " + e);
            return false;
        }
    }

    // consultar cartelas vendidas
    public Collection<Compra> consultarCompras(int chavePK) {
        try {
            ps = connection.prepareStatement(CreateNamedQueryCompra.consultarCompras());
            ps.setInt(1, chavePK);
            ResultSet rs = ps.executeQuery();
            Compra compra = null;
            Collection<Compra> compras = new ArrayDeque<Compra>();
            while (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compras.add(compra);
            }
            return compras;

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;

        }

    }

    public Collection<Compra> comprasAll() {
        try {
            ps = connection.prepareStatement(CreateNamedQueryCompra.all());
            ResultSet rs = ps.executeQuery();
            Compra compra = null;
            Collection<Compra> compras = new ArrayDeque<Compra>();
            while (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setPremio(rs.getString("premio"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setFuncionario(funcionarioService.getFuncionario(rs.getInt("idfuncionario")));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compras.add(compra);
            }
            return compras;

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;

        }

    }

    public Collection<Compra> selecionarComprasPeloSeuEnderecoDeCadastro(String local) {
        try {
            ps = connection.prepareStatement(CreateNamedQueryCompra.selecionarComprasPeloSeuEnderecoDeCadastro());
            ps.setInt(1, Integer.parseInt(local));
            ResultSet rs = ps.executeQuery();
             Compra compra = null;
            Collection<Compra> compras = new ArrayDeque<Compra>();
            while (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setPremio(rs.getString("premio"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setValorBilhete(rs.getDouble("valorBilhete"));
                compra.setQtd_cartela(rs.getInt("qtd_cartela"));
                compra.setApostas(as.consultarApostasIdCompra(rs.getInt("idcompra")));
                compras.add(compra);
            }
            return compras;

        } catch (Exception e) {
            return null;
        }
    }

    public Collection<Compra> selecionarComprasPeloSeuMilharDeCadastro(String numero) {
        try {
            ps = connection.prepareStatement(CreateNamedQueryCompra.selecionarComprasPeloSeuMilharDeCadastro());
            ps.setString(1, "%" + numero + "%");
            ResultSet rs = ps.executeQuery();
            System.out.println(ps.toString());
            Compra compra = null;
            Collection<Compra> compras = new ArrayDeque<Compra>();
            while (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setPremio(rs.getString("premio"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setApostas(as.consultarApostasIdCompra(rs.getInt("idcompra")));
                compras.add(compra);
            }
            return compras;

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    public int maxId() {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateNamedQueryCompra.maxId());
            ResultSet rs = ps.executeQuery();
            rs.next();
            int id = 0;
            id = rs.getInt("id");
            return id;
        } catch (SQLException e) {
            // TODO: handle exception
            return 0;
        }
    }

    // cadastrar cartela com os numeros selecionado
    public Compra save(Compra minhaVenda, List<Milhar> itens) {

        try {
            ps = connection.prepareStatement(CreateSQLCompra.insertCompra());
            int key = maxId() + 1;
            ps.setInt(1, key);
            ps.setDate(2, DataSourceUtil.formatDataUtil());
            ps.setInt(3, minhaVenda.getPessoa().getIdPessoa());
            ps.setBoolean(4, minhaVenda.isPagou());
            ps.setBoolean(5, minhaVenda.isCancelar());
            ps.setDouble(6, minhaVenda.getValor());
            ps.setString(7, minhaVenda.getNumero_cartela());
            ps.setString(8, minhaVenda.getPremio());
            ps.setInt(9, minhaVenda.getQtd_cartela());
            ps.setDouble(10, minhaVenda.getValorBilhete());
            ps.setInt(11, minhaVenda.getFuncionario().getIdFuncionario());
            ps.setDouble(12, minhaVenda.getDesconto());
            ps.setInt(13, minhaVenda.getQtdAlternativa());
            ps.execute();
            Compra compra = obterCompra(key);
            for (Milhar m : itens) {
                Aposta aposta = new Aposta(m, compra);
                as.save(aposta);
                ms.getNaoDisponivel(m);
            }
            return obterCompra(key);
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    }

    public void deleteCompra(int idcompra) {
        try {
            ps = connection.prepareStatement(CreateSQLCompra.removeCompra());
            ps.setInt(1, idcompra);
            ps.execute();
        } catch (SQLException e) {
            System.err.println("Log:" + e);
        }
    }

    CentenaGratisService service = new CentenaGratisService();

    public void removerCompras(int idcompra) {
        try {

            Collection<Aposta> apostas = cs.detalhesAposta(idcompra);
            for (Aposta ap : apostas) {
                Milhar m = ms.getJogo(ap.getMilhar().getIdMilhar());
                ms.getDisponivel(m);
                as.deleteAposta(ap.getIdAposta());
            }
            Compra compra = get(idcompra);
            int idpessoa = compra.getPessoa().getIdPessoa();
            service.deleteCentenas(idcompra);
            deleteCompra(compra.getIdCompra());
            psp.delete(idpessoa);

        } catch (Exception e) {
            System.err.println("Log: " + e);
        }
    }

    public int modificarQtd(int idCompra, int qtd, double valor) {
        try {
            ps = connection.prepareStatement(CreateSQLCompra.alterarQtdValor(qtd, valor));
            ps.setInt(1, idCompra);
            System.out.println(ps.toString());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            return -1;
        }

    }

    public Compra obterCompra(int idcompra) {
        try {
            ps = connection.prepareStatement(CreateNamedQueryCompra.obter());
            ps.setInt(1, idcompra);
            ResultSet rs = ps.executeQuery();
            Compra compra = null;
            while (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setPremio(rs.getString("premio"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setValorBilhete(rs.getDouble("valorBilhete"));
                compra.setQtd_cartela(rs.getInt("qtd_cartela"));
                compra.setApostas(as.consultarApostasIdCompra(rs.getInt("idcompra")));
                compra.setFuncionario(funcionarioService.getFuncionario(rs.getInt("idfuncionario")));
                compra.setDesconto(rs.getDouble("desconto"));
            }
            return compra;
        } catch (SQLException e) {
            return null;
        }
    }

    public Compra finalizarPagamento(int idcompra, int chave_acesso) {
        try {
            ps = connection.prepareStatement(CreateSQLCompra.finalizarPagamento());
            ps.setInt(1, chave_acesso);
            ps.setInt(2, idcompra);
            System.out.println(ps.toString());
            ps.execute();
            return obterCompra(idcompra);
        } catch (SQLException e) {
            System.err.println(e.getErrorCode());
            return null;
        }
    }

    public Boolean alterarPessoa(int idcompra, int idpessoa) {
        try {
            ps = connection.prepareStatement(CreateSQLCompra.alterarPessoa());
            ps.setInt(1, idpessoa);
            ps.setInt(2, idcompra);
            System.out.println(ps.toString());
            return ps.execute();
        } catch (SQLException e) {
            System.err.println(e.getErrorCode());
            return false;
        }
    }

    public void alterarMilharPessoa(Aposta a, int idmilhar) {
        try {
            ps = connection.prepareStatement(CreateSQLCompra.alterarMilharPessoa());
            ps.setInt(1, idmilhar);
            ps.setInt(2, a.getIdAposta());
            System.out.println(ps.toString());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
    }

    protected double pegarValor(Integer idcompra, Integer idPessoa) {
        try {
            ps = connection.prepareStatement(CreateNamedQueryCompra.pegarValor());
            ResultSet rs = ps.executeQuery();
            double get = 0;
            if (rs.next()) {
                get = rs.getDouble("get");
            }
            return get;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            return 0;
        }
    }

    public Integer qtdMinCartela() {
        try {
            ps = connection.prepareStatement(CreateNamedQueryCompra.qtdMinCartela());
            ResultSet rs = ps.executeQuery();
            Integer quatidadeMinima = 0;
            if (rs.next()) {
                quatidadeMinima = rs.getInt("minima");
            }
            return quatidadeMinima;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            e.printStackTrace();
            return null;
        }
    }

    public void voltarPrecoFixo(Integer chave, int qtd) {
        try {
            double valorBilhete = pegarValor(chave);
            ps = connection.prepareStatement(CreateSQLCompra.voltarPrecoFixo(chave));
            ps.setDouble(1, valorBilhete * qtd);
            ps.setInt(2, chave);
            ps.executeUpdate();
            System.out.println(ps.toString());
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    protected double pegarValor(Integer idcompra) {
        try {
            ps = connection.prepareStatement(CreateNamedQueryCompra.pegarValorValorbilhete());
            ps.setInt(1, idcompra);
            ResultSet rs = ps.executeQuery();
            double valor = 0;
            if (rs.next()) {
                valor = rs.getDouble("value");
            }

            return valor;
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
    }

    public int ativarTodosCartelasParaVenda() {
        try {
            ps = connection.prepareStatement(CreateSQLCompra.ativarTodosCartelasParaVenda());
            System.out.println(ps.toString());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            return -1;
        }

    }

    public List<Aposta> listaCompletaSemFiltrosCompras() {
        try {
            PreparedStatement ps = connection
                    .prepareStatement(CreateNamedQueryCompra.listaCompletaSemFiltrosCompras());
            ResultSet rs = ps.executeQuery();
            List<Aposta> apostas = new ArrayList<Aposta>();
            while (rs.next()) {
                Aposta aposta = new Aposta();
                aposta.setIdAposta(rs.getInt(1));
                aposta.setCompra(get(rs.getInt(2)));
                aposta.setMilhar(new MilharService().getJogo(rs.getInt(3)));
                apostas.add(aposta);
            }
            return apostas;
        } catch (Exception e) {
            // TODO: handle exception
            return new ArrayList<>();
        }
    }

    public boolean ativarCobrancaCliente(Integer valueOf) {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateSQLCompra.ativarCobrancaCliente());
            ps.setInt(1, valueOf.intValue());
            ps.execute();
            System.out.println(ps.toString());
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }

    }

    public String obterPrecoNormalizado(int key, double valorNormal) {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateSQLCompra.obterPrecoNormalizado());
            ps.setDouble(1, valorNormal);
            ps.setInt(2, key);
            ps.execute();
            return "Enviado";
        } catch (Exception e) {
            return "Cancelado";
        }

    }

    public Collection<Compra> listaEmabertoCompras() {
        try {
            ps = connection.prepareStatement(CreateNamedQueryCompra.listaEmabertoCompras());
            ResultSet rs = ps.executeQuery();
            Compra compra = null;
            Collection<Compra> compras = new ArrayDeque<Compra>();
            while (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setPremio(rs.getString("premio"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setFuncionario(funcionarioService.getFuncionario(rs.getInt("idfuncionario")));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setDesconto(rs.getDouble("desconto"));
                compras.add(compra);
            }
            return compras;
        } catch (Exception e) {
            return null;
        }

    }

    public Collection<Compra> consultarComprasEmabertoCobrador() {
        try {
            ps = connection.prepareStatement(CreateNamedQueryCompra.consultarComprasEmabertoCobrador());
            ResultSet rs = ps.executeQuery();
            Collection<Compra> compras = new ArrayDeque<Compra>();
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setPremio(rs.getString("premio"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setFuncionario(funcionarioService.getFuncionario(rs.getInt("idfuncionario")));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setApostas(as.consultarApostasIdCompra(rs.getInt("idcompra")));
                compra.setDesconto(rs.getDouble("desconto"));
                compras.add(compra);
            }
            return compras;
        } catch (Exception e) {
            return null;
        }
    }

    public Collection<Compra> catalogodeComprasComsuasApostasEmaberto(int limit, int page) {
        try {
            ps = connection.prepareStatement(CreateNamedQueryCompra.catalogodeComprasComsuasApostasEmaberto());
            ps.setInt(1, limit);
            ps.setInt(2, page);
            ResultSet rs = ps.executeQuery();
            Compra compra = null;
            Collection<Compra> compras = new ArrayDeque<Compra>();
            while (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setPremio(rs.getString("premio"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setFuncionario(funcionarioService.getFuncionario(rs.getInt("idfuncionario")));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setApostas(as.consultarApostasIdCompra(rs.getInt("idcompra")));
                compras.add(compra);
            }
            return compras;
        } catch (Exception e) {
            return null;
        }
    }

    public double calcularValorPagamentoCurrenteDate() {
        try {
            ps = connection.prepareStatement(CreateNamedQueryCompra.calcularValorPagamentoCurrenteDate());
            ResultSet rs = ps.executeQuery();
            double valor = 0;
            rs.next();
            valor = rs.getDouble("valor");
            return valor;
        } catch (Exception e) {
            return 0;
        }
    }

    public List<Compra> joinEnderecoPessoaCompraApostaGerandoPdfEmaberto() {
        try {
            ps = connection.prepareStatement(CreateNamedQueryCompra.joinEnderecoPessoaCompraApostaGerandoPdfEmaberto());
            ResultSet rs = ps.executeQuery();
            Compra compra = null;
            List<Compra> compras = new ArrayList<Compra>();
            while (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setApostas(as.consultarApostasIdCompra(rs.getInt("idcompra")));
                compras.add(compra);
            }
            return compras;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Compra> filtrarCompraPorFuncionario(Funcionario funcionario, Local local, boolean situacao) {
        try {
            ps = connection.prepareStatement(CreateNamedQueryCompra.filtrarCompraPorFuncionario());
            ps.setInt(1, local.getIdLocal());
            ps.setInt(2, funcionario.getIdFuncionario());
            ps.setBoolean(3, situacao);
            ResultSet rs = ps.executeQuery();
            List<Compra> compras = new ArrayList<Compra>();
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setApostas(as.consultarApostasIdCompra(rs.getInt("idcompra")));
                compras.add(compra);
            }
            return compras;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    public List<Compra> filtrarTodasComprasPorFuncionario(Funcionario funcionario, Local local) {
        try {
            ps = connection.prepareStatement(CreateNamedQueryCompra.filtrarTodasComprasPorFuncionario());
            ps.setInt(1, local.getIdLocal());
            ps.setInt(2, funcionario.getIdFuncionario());
            ResultSet rs = ps.executeQuery();
            List<Compra> compras = new ArrayList<Compra>();
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setApostas(as.consultarApostasIdCompra(rs.getInt("idcompra")));
                compras.add(compra);
            }
            return compras;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    public boolean ajustarValorTalaoCliente(int idCompra, double valor) {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateSQLCompra.ajustarValorTalaoCliente());
            ps.setObject(1, valor);
            ps.setObject(2, idCompra);
            System.out.println(ps.toString());
            ps.execute();
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }

    }

    public List<Compra> consultarMilharClienteQtdEValor(double valor, int qtd) {

        try {
            PreparedStatement ps = connection.prepareStatement(CreateNamedQueryCompra.consultarMilharClienteQtdEValor());
            ps.setInt(1, qtd);
            ps.setDouble(2, valor);
            List<Compra> compras = new ArrayList<>();
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setQtd_cartela(rs.getInt("qtd_cartela"));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setApostas(as.consultarApostasIdCompra(rs.getInt("idcompra")));
                compras.add(compra);
            }
            return compras;
        } catch (SQLException e) {
            System.out.println(e);
            throw new IllegalArgumentException("Erro:" + e);
        }

    }

    public int encontrarQuantidadeDeTaloesDoEndereco(long id) {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateNamedQueryCompra.encontrarQuantidadeDeTaloesDoEndereco());
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int soma = rs.getInt("soma");
            return soma;
        } catch (SQLException e) {
            return 0;
        }
    }

    public List<Compra> buscarCompraClienteMobile(String data) {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateNamedQueryCompra.buscarCompraClienteMobile());
            ps.setObject(1, data);
            ps.setObject(2, "%" + data + "%");
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            List<Compra> compras = new ArrayList<>();
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setQtd_cartela(rs.getInt("qtd_cartela"));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setApostas(as.consultarApostasIdCompra(rs.getInt("idcompra")));
                compras.add(compra);
            }
            return compras;
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        }

    }

    public int qtdTalaoInseridos() {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateNamedQueryCompra.qtdTalaoInseridos());
            ResultSet rs = ps.executeQuery();
            rs.next();
            int soma = rs.getInt("soma");
            return soma;
        } catch (SQLException e) {
            return 0;
        }
    }

    public void alterarNumeroReferencia(String referencia, int idpessoa) {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateSQLCompra.updateNumeroCartela());
            ps.setObject(1, referencia);
            ps.setObject(2, idpessoa);
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public double encontrarValorEmaberto(int idLocal) {
        try {
            try {
                PreparedStatement ps = connection.prepareStatement("select sum(c.valor) as valor "
                        + "from endereco e, compra c, pessoa p\n"
                        + "where e.idendereco = p.idendereco \n"
                        + "and p.idpessoa = c.idpessoa and not c.pagou and e.idendereco = ?");
                ps.setObject(1, idLocal);
                ResultSet rs = ps.executeQuery();
                rs.next();
                int soma = rs.getInt("valor");
                return soma;
            } catch (SQLException e) {
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }

    }

    public double encontrarValorEmConcluido(int idLocal) {
        try {
            try {
                PreparedStatement ps = connection.prepareStatement("select sum(c.valor) as valor "
                        + "from endereco e, compra c, pessoa p\n"
                        + "where e.idendereco = p.idendereco \n"
                        + "and p.idpessoa = c.idpessoa and c.pagou and e.idendereco = ?");
                ps.setObject(1, idLocal);
                ResultSet rs = ps.executeQuery();
                rs.next();
                int soma = rs.getInt("valor");
                return soma;
            } catch (SQLException e) {
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    public boolean modificarQtd(int id, int qtd) {
        try {
            String sql = "update compra set qtd_cartela = ? where idcompra = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, qtd);
            ps.setObject(2, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean modificarValor(int id, double valor) {

        try {
            String sql = "update compra set valor = ? where idcompra = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, valor);
            ps.setObject(2, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }

    }

    public Set<Compra> listaDeComprasValorDiferenteQtd() {
        try {
            String query = "select * from pessoa p , compra c where p.idpessoa  = c.idpessoa and (c.qtd_cartela * c.valorbilhete ) <> c.valor";
            PreparedStatement ps = connection
                    .prepareStatement(query);
            Set<Compra> compras = new LinkedHashSet<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Compra c = new Compra();
                c.setIdCompra(rs.getInt("idcompra"));
                c.setNumero_cartela(rs.getString("numero_cartela"));
                c.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                c.setPessoa(psp.get(rs.getInt("idpessoa")));
                c.setQtd_cartela(rs.getInt("qtd_cartela"));
                c.setPagou(rs.getBoolean("pagou"));
                c.setValor(rs.getDouble("valor"));
                c.setApostas(as.consultarApostasIdCompra(rs.getInt("idcompra")));

                compras.add(c);
            }
            return compras;
        } catch (SQLException e) {
            return null;
        }
    }

    public Object valorPerdido() {

        try {
            String query = "select sum(c.valor)  as valorperdido from pessoa p , compra c where p.idpessoa  = c.idpessoa and (c.qtd_cartela * c.valorbilhete ) <> c.valor and not c.pagou";
            PreparedStatement ps = connection
                    .prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.next();
            double valor = rs.getDouble("valorperdido");
            return valor;
        } catch (SQLException e) {
            return null;
        }

    }

    public Compra carregarCompraCliente(String numero) {
        try {
            String query = "";
            query = "select  distinct (c.idpessoa ),c.idcompra ,c.numero_cartela ,c.premio ,c.datajogo,c.cancelar ,c.pagou ,c.valor  from pessoa p inner join compra c on p.idpessoa=c.idpessoa inner join aposta a on c.idcompra=a.idcompra inner join jogo j on a.idjogo=j.idjogo where j.numero like ? limit 12 ";
            ps = connection.prepareStatement(query);
            ps.setString(1, numero);
            ResultSet rs = ps.executeQuery();
            System.out.println(ps.toString());
            Compra compra = null;
            while (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setPremio(rs.getString("premio"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setApostas(as.consultarApostasIdCompra(rs.getInt("idcompra")));

            }
            System.out.println("Log: " + ps.toString());
            return compra;

        } catch (SQLException e) {
            System.err.println("Log:" + e.getMessage());
            return null;
        }
    }

    public LinkedHashSet<Compra> todasComprasComCentenasEhMilharDoCliente() {
        try {
            String query = "select * from compra c where c.pagou ";
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            System.out.println(ps.toString());
            LinkedHashSet<Compra> compras = new LinkedHashSet<>();
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setPremio(rs.getString("premio"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setApostas(as.consultarApostasIdCompra(rs.getInt("idcompra")));
                compra.setTodasCentenasGratis(cgs.buscarCentenasGratisPelaCompraCliente(rs.getInt("idcompra")));
                compra.setTodasCentenasGratisinha(cgs.buscarCentenasGratisinha(rs.getInt("idcompra")));
                compras.add(compra);
            }
            return compras;

        } catch (SQLException e) {
            System.err.println("Log:" + e.getMessage());
            return null;
        }
    }

    public void alterarQtdValor(Compra compra) {
        try {
            String sql = "update compra set qtd_cartela = ?, valor = ? where idcompra = ?";
            ps = connection.prepareStatement(sql);
            ps.setObject(1, compra.getQtd_cartela());
            ps.setObject(2, compra.getValor());
            ps.setObject(3, compra.getIdCompra());
            ps.execute();
            System.out.println("update valor: " + ps.toString());
        } catch (SQLException e) {
            System.out.println("Erro:" + e);
        }

    }
    
    
    
    
    public Collection<Compra> selecionarComprasPeloSeuEnderecoDeCadastroListaCompleta(String local) {
        try {
            ps = connection.prepareStatement(CreateNamedQueryCompra.selecionarComprasPeloSeuEnderecoDeCadastroListaCompleta());
            ps.setInt(1, Integer.parseInt(local));
            ResultSet rs = ps.executeQuery();
             Compra compra = null;
            Collection<Compra> compras = new ArrayDeque<Compra>();
            while (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("idcompra"));
                compra.setNumero_cartela(rs.getString("numero_cartela"));
                compra.setPremio(rs.getString("premio"));
                compra.setDataJogo(DataSourceUtil.formatDataUtilCalendar(rs.getDate("datajogo")));
                compra.setPessoa(psp.get(rs.getInt("idpessoa")));
                compra.setCancelar(rs.getBoolean("cancelar"));
                compra.setPagou(rs.getBoolean("pagou"));
                compra.setValor(rs.getDouble("valor"));
                compra.setValorBilhete(rs.getDouble("valorBilhete"));
                compra.setQtd_cartela(rs.getInt("qtd_cartela"));
                compra.setApostas(as.consultarApostasIdCompra(rs.getInt("idcompra")));
                compras.add(compra);
            }
            return compras;

        } catch (Exception e) {
            return null;
        }
    }

}
