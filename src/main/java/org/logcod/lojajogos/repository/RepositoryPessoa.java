package org.logcod.lojajogos.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Calendar;
import java.util.Collection;

import org.logcod.lojajogos.config.ContextConfigDataSource;
import org.logcod.lojajogos.config.util.DataSourceUtil;
import org.logcod.lojajogos.jdbc.queries.pessoa.CreateNamedQueryPessoa;
import org.logcod.lojajogos.jdbc.sql.pessoa.CreateSQLPessoa;
import org.logcod.lojajogos.model.entity.Pessoa;
import org.logcod.lojajogos.service.LocalService;

public class RepositoryPessoa {

    private Connection connection;
    protected ContextConfigDataSource dataSource;
    protected LocalService sl = new LocalService();

    public RepositoryPessoa() {
        dataSource = ContextConfigDataSource.jdbcConectBD();
        connection = dataSource.aberta();
    }

    public Pessoa get(Integer idpessoa) {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateNamedQueryPessoa.obterPessoaId());
            ps.setInt(1, idpessoa);
            ResultSet rs = ps.executeQuery();
            Pessoa p = null;
            if (rs.next()) {
                p = new Pessoa();
                p.setIdPessoa(rs.getInt("idpessoa"));
                p.setNome(rs.getString("nome"));
                p.setContato(rs.getString("contato"));
                p.setReferencia(rs.getString("referencia"));
                p.setEmail(rs.getString("email"));
                p.setLocal(sl.get(rs.getInt("idendereco")));
                p.setDataRegistro(DataSourceUtil.formatDataUtilCalendar(rs.getDate("dataregistro")));

            }
            return p;
        } catch (SQLException e) {
            System.out.println("Log: " + e);
            return new Pessoa();
        }
    }

    public Collection<Pessoa> consultasPessoas(String name, String email, String contato) {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateNamedQueryPessoa.consultarPorNomeEmailContato());
            ps.setString(1, "%" + name + "%");
            ps.setString(2, email);
            ps.setString(3, contato);
            ResultSet rs = ps.executeQuery();
            Collection<Pessoa> pessoas = new ArrayDeque<Pessoa>();
            Pessoa p;
            while (rs.next()) {
                p = new Pessoa();
                p.setIdPessoa(rs.getInt("idpessoa"));
                p.setNome(rs.getString("nome"));
                p.setContato(rs.getString("contato"));
                p.setReferencia(rs.getString("referencia"));
                p.setEmail(rs.getString("email"));
                p.setLocal(sl.get(rs.getInt("idendereco")));
                p.setDataRegistro(DataSourceUtil.formatDataUtilCalendar(rs.getDate("dataregistro")));
                pessoas.add(p);
            }
            return pessoas;
        } catch (SQLException e) {
            System.out.println("Log: " + e.getMessage());
            return null;
        }
    }

    public Pessoa consultarPeloEmailContato(String email, String contato) {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateNamedQueryPessoa.consultarPorEmailContato());
            ps.setString(1, email);
            ps.setString(2, contato);
            ResultSet rs = ps.executeQuery();
            Pessoa p = null;
            if (rs.next()) {
                p = new Pessoa();
                p.setIdPessoa(rs.getInt("idpessoa"));
                p.setNome(rs.getString("nome"));
                p.setContato(rs.getString("contato"));
                p.setReferencia(rs.getString("referencia"));
                p.setEmail(rs.getString("email"));
                p.setLocal(sl.get(rs.getInt("idendereco")));

            }
            return p;
        } catch (SQLException e) {
            System.out.println("Log: " + e.getMessage());
            return null;
        }
    }

    public Pessoa consultarPeloNome(String nome) {
        try {

            PreparedStatement ps = connection.prepareStatement(CreateNamedQueryPessoa.consultarPorNome());
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            Pessoa p = null;
            if (rs.next()) {
                p = new Pessoa();
                p.setIdPessoa(rs.getInt("idpessoa"));
                p.setNome(rs.getString("nome"));
                p.setContato(rs.getString("contato"));
                p.setReferencia(rs.getString("referencia"));
                p.setEmail(rs.getString("email"));
                p.setLocal(sl.get(rs.getInt("idendereco")));

            }
            return p;
        } catch (SQLException e) {
            System.out.println("Log: " + e.getMessage());
            return null;
        }
    }

    public Pessoa referenciaCartela(String numero) {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateNamedQueryPessoa.consultarPorContato());
            ps.setString(1, numero);
            ResultSet rs = ps.executeQuery();
            Pessoa p = null;
            if (rs.next()) {
                p = new Pessoa();
                p.setIdPessoa(rs.getInt("idpessoa"));
                p.setNome(rs.getString("nome"));
                p.setContato(rs.getString("contato"));
                p.setReferencia(rs.getString("referencia"));
                p.setEmail(rs.getString("email"));
                p.setLocal(sl.get(rs.getInt("idendereco")));

            }
            return p;
        } catch (SQLException e) {
            System.out.println("Log: " + e.getMessage());
            return null;
        }
    }

    public Pessoa consultarNome(String nome) {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateNamedQueryPessoa.consultaNome());
            ps.setString(1, "%" + nome.trim() + "%");
            ResultSet rs = ps.executeQuery();
            Pessoa p = null;
            if (rs.next()) {
                p = new Pessoa();
                p.setIdPessoa(rs.getInt("idpessoa"));
                p.setNome(rs.getString("nome"));
                p.setContato(rs.getString("contato"));
                p.setReferencia(rs.getString("referencia"));
                p.setEmail(rs.getString("email"));
                p.setLocal(sl.get(rs.getInt("idendereco")));
            }
            return p;
        } catch (SQLException e) {
            System.out.println("Log: " + e.getMessage());
            return null;
        }
    }

    public int maxIdPessoa() {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateNamedQueryPessoa.maxIdPessoa());
            ResultSet rs = ps.executeQuery();
            rs.next();
            int idpessoa = 0;
            idpessoa = rs.getInt("idpessoa");
            return idpessoa;
        } catch (Exception e) {
            // TODO: handle exception
            return 0;
        }
    }

    public Pessoa save(Pessoa p) {
        try {

            PreparedStatement ps = connection.prepareStatement(CreateSQLPessoa.insertPessoa());
            int chave = maxIdPessoa() + 1;
            ps.setInt(1, chave);
            ps.setString(2, p.getNome());
            ps.setString(3, p.getEmail());
            ps.setString(4, p.getContato());
            ps.setString(5, p.getReferencia());
            ps.setInt(6, p.getLocal().getIdLocal());
            ps.setDate(7, new Date(Calendar.getInstance().getTimeInMillis()));
            ps.execute();
            Pessoa pessoa = get(chave);
            System.out.println("salvou com id: " + pessoa);
            return pessoa;
        } catch (SQLException e) {
            System.out.println("Log: " + e.getMessage());
            return null;
        }
    }

    public int update(Pessoa p) {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateSQLPessoa.mergePessoa());
            ps.setString(1, p.getNome());
            ps.setString(2, p.getEmail());
            ps.setString(3, p.getContato());
            ps.setString(4, p.getReferencia());
            ps.setInt(5, p.getLocal().getIdLocal());
            ps.setInt(6, p.getIdPessoa());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Log: " + e.getLocalizedMessage());
            return -1;
        }
    }

    public void delete(int idPessoa) {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateSQLPessoa.removePessoa());
            ps.setInt(1, idPessoa);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Log: " + e.getMessage());
        }
    }

}
