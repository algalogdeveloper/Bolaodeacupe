package org.logcod.lojajogos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.logcod.lojajogos.config.ContextConfigDataSource;
import org.logcod.lojajogos.jdbc.queries.endereco.CreateNamedQueryEndereco;
import org.logcod.lojajogos.jdbc.sql.endereco.CreateSQLEndereco;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.model.entity.Local;

public class RepositoryLocal {

    private Connection connection;
    protected ContextConfigDataSource dataSource;

    public RepositoryLocal() {
        dataSource = ContextConfigDataSource.jdbcConectBD();
        connection = dataSource.aberta();
    }

    public Set<Local> consultarEnderecosComPessoas() {
        try {
            Set<Local> consultarPessa = new HashSet<Local>();
            PreparedStatement ps = connection.prepareStatement(CreateNamedQueryEndereco.consultarEnderecosComPessoas());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Local l = new Local();
                l.setIdLocal(rs.getInt("id"));
                l.setDescricao(rs.getString("dr"));
                l.setCidade(rs.getString("cd"));
                consultarPessa.add(l);
            }
            return consultarPessa;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Set<Local> consultarEnderecosComPessoasSempagar() {
        try {
            Set<Local> consultarPessa = new HashSet<Local>();
            PreparedStatement ps = connection.prepareStatement(CreateNamedQueryEndereco.consultarEnderecosComPessoasSempagar());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Local l = new Local();
                l.setIdLocal(rs.getInt("id"));
                l.setDescricao(rs.getString("dr"));
                l.setCidade(rs.getString("cd"));
                consultarPessa.add(l);
            }
            return consultarPessa;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public boolean save(Local local) {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateSQLEndereco.insertEndereco());
            ps.setInt(1, retornarChave() + 1);
            ps.setString(2, local.getDescricao());
            ps.setString(3, local.getCidade());
            return ps.execute();
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }

    }

    public int update(Local l) {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateSQLEndereco.mergeEndereco());
            ps.setString(1, l.getDescricao());
            ps.setString(2, l.getCidade());
            ps.setInt(3, l.getIdLocal());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return -1;
        }
    }

    public int retornarChave() {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateNamedQueryEndereco.retornarChave());
            ResultSet rs = ps.executeQuery();
            rs.next();
            int chave = 0;
            chave = rs.getInt("chave");
            return chave;
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
    }

    // Removendo endereço
    public int delete(int idlocal) {
        try {
            PreparedStatement pst = connection.prepareStatement(CreateSQLEndereco.removeEndereco());
            pst.setInt(1, idlocal);
            return pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return -1;
        }

    }

    // buscando endereco
    public LinkedHashSet<Local> getLocals() {

        LinkedHashSet<Local> locals = new LinkedHashSet<Local>();
        try {
            PreparedStatement pst = connection.prepareStatement(CreateNamedQueryEndereco.getLocals());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Local local = new Local();
                local.setIdLocal(rs.getInt("idendereco"));
                local.setDescricao(rs.getString("descricao"));
                local.setCidade(rs.getString("cidade"));
                locals.add(local);
            }
            return locals;
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return locals;
        }
    }

    public List<Local> listaVendasEmaberto() {
        try {
            PreparedStatement pst = connection.prepareStatement(CreateNamedQueryEndereco.listaVendasEmaberto());
            ResultSet rs = pst.executeQuery();
            List<Local> locals = new ArrayList<>();
            Local local;
            while (rs.next()) {
                local = new Local();
                local.setIdLocal(rs.getInt("chave"));
                local.setDescricao(rs.getString("descricao"));
                local.setCidade(rs.getString("cidade"));
                locals.add(local);
            }
            return locals;
        } catch (Exception e) {
            return new ArrayList<Local>();
        }
    }

    public LinkedHashSet<Local> consultaEndereco(String consulta) {
        try {
            PreparedStatement pst = connection.prepareStatement(CreateNamedQueryEndereco.consultaEndereco());
            pst.setString(1, "%" + consulta + "%");
            ResultSet rs = pst.executeQuery();
            LinkedHashSet<Local> locals = new LinkedHashSet<Local>();
            Local local;
            while (rs.next()) {
                local = new Local();
                local.setIdLocal(rs.getInt("idendereco"));
                local.setDescricao(rs.getString("descricao"));
                local.setCidade(rs.getString("cidade"));
                locals.add(local);
            }
            return locals;
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    public Local getEndereco(int id) {
        try {
            PreparedStatement pst = connection.prepareStatement(CreateNamedQueryEndereco.getEndereco());
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            Local local = null;
            if (rs.next()) {
                local = new Local();
                local.setIdLocal(rs.getInt("idendereco"));
                local.setDescricao(rs.getString("descricao"));
                local.setCidade(rs.getString("cidade"));
            }
            return local;
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return new Local();
        }

    }

    public Local obterLocal(String descricao) {
        try {
            PreparedStatement pst = connection.prepareStatement(CreateNamedQueryEndereco.obterLocal());
            pst.setString(1, descricao);
            ResultSet rs = pst.executeQuery();
            Local local = null;
            if (rs.next()) {
                local = new Local();
                local.setIdLocal(rs.getInt("idendereco"));
                local.setDescricao(rs.getString("descricao"));
                local.setCidade(rs.getString("cidade"));
            }
            return local;
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return new Local();
        }
    }

    public LinkedHashSet<Local> listaEnderecosCompraDoFuncionario(int id) {
        try {
            String query = "SELECT distinct(e.descricao) as rua,e.idendereco as idendereco,e.cidade as cidade FROM endereco e, funcionario f, compra c , pessoa p\n"
                    + "where p.idpessoa = c.idpessoa\n"
                    + "and  f.idfuncionario = c.idfuncionario \n"
                    + "and e.idendereco = p.idendereco and f.idfuncionario = ? \n"
                    + " LIMIT 100 " ;
            PreparedStatement ps = connection
                    .prepareStatement(query);
            ps.setObject(1, id);
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            LinkedHashSet<Local> locais = new LinkedHashSet<>();
            while (rs.next()) {
                Local l = new Local();
               l.setIdLocal(rs.getInt("idendereco"));
               l.setDescricao(rs.getString("rua"));
               l.setCidade(rs.getString("cidade"));
               locais.add(l);
            }
            return locais;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

}
