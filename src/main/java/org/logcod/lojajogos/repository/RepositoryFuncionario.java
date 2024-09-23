package org.logcod.lojajogos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import org.logcod.lojajogos.config.ContextConfigDataSource;
import org.logcod.lojajogos.config.util.ProtegerPasswordUsuario;
import org.logcod.lojajogos.jdbc.queries.funcionario.CreateNamedQueryFuncionario;
import org.logcod.lojajogos.jdbc.sql.funcionario.CreateSQLFuncionario;
import org.logcod.lojajogos.model.entity.Funcionario;

public class RepositoryFuncionario {

    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    protected ContextConfigDataSource dataSource;

    public RepositoryFuncionario() {
        dataSource = ContextConfigDataSource.jdbcConectBD();
        connection = dataSource.aberta();
    }

    public boolean validarLogin(String login, String senha) {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateNamedQueryFuncionario.validarFuncionario());
            ps.setString(1, login);
            ps.setString(2, ProtegerPasswordUsuario.esconderSenha(senha));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        return true;
    }

    public Funcionario getFuncionario(int id) {
        try {
            ps = connection.prepareStatement(CreateNamedQueryFuncionario.unique());
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            Funcionario f = new Funcionario();
            f.setIdFuncionario(rs.getInt("idfuncionario"));
            f.setNome(rs.getString("nome"));
            f.setContato(rs.getString("contato"));
            f.setLogin(rs.getString("login"));
            f.setPermissao(rs.getInt("permissao"));
            f.setSenha(rs.getString("senha"));
            return f;
        } catch (SQLException e) {
            return null;
        }
    }

    public Collection<Funcionario> getFuncionarios(int limit) {
        try {
            ps = connection
                    .prepareStatement(CreateNamedQueryFuncionario.get());
            ps.setInt(1, limit);
            rs = ps.executeQuery();
            Collection<Funcionario> funcionarios = new ArrayList<Funcionario>();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setIdFuncionario(rs.getInt("idfuncionario"));
                f.setNome(rs.getString("nome"));
                f.setContato(rs.getString("contato"));
                f.setLogin(rs.getString("login"));
                f.setPermissao(rs.getInt("permissao"));
                f.setSenha(rs.getString("senha"));
                f.setEmail(rs.getString("email"));
                funcionarios.add(f);
            }
            return funcionarios;
        } catch (SQLException e) {
            return null;
        }
    }

    public Collection<Funcionario> consultarFuncionarios(String consulta) {
        try {
            ps = connection.prepareStatement(CreateNamedQueryFuncionario.consultarFuncionarios());
            ps.setObject(1, consulta);
            ps.setObject(2, consulta);
            rs = ps.executeQuery();
            Collection<Funcionario> funcionarios = new ArrayDeque<>();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setIdFuncionario(rs.getInt("idfuncionario"));
                f.setNome(rs.getString("nome"));
                f.setContato(rs.getString("contato"));
                f.setLogin(rs.getString("login"));
                f.setPermissao(rs.getInt("permissao"));
                f.setSenha(rs.getString("senha"));
                funcionarios.add(f);
            }
            return funcionarios;
        } catch (SQLException e) {
            return null;
        }
    }
    
    
     public Collection<Funcionario> todos() {
        try {
            ps = connection.prepareStatement("select * from funcionario");
            rs = ps.executeQuery();
            Collection<Funcionario> funcionarios = new ArrayDeque<>();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setIdFuncionario(rs.getInt("idfuncionario"));
                f.setNome(rs.getString("nome"));
                f.setContato(rs.getString("contato"));
                f.setLogin(rs.getString("login"));
                f.setPermissao(rs.getInt("permissao"));
                f.setSenha(rs.getString("senha"));
                funcionarios.add(f);
            }
            return funcionarios;
        } catch (SQLException e) {
            return null;
        }
    }

    public int maxId() {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateNamedQueryFuncionario.maxId());
            ResultSet rs = ps.executeQuery();
            rs.next();
            int id = 0;
            id = rs.getInt("id");
            return id;
        } catch (Exception e) {
            // TODO: handle exception
            return 0;
        }
    }

    public Funcionario save(Funcionario f) {
        try {
            ps = connection.prepareStatement(CreateSQLFuncionario.save());
            Integer key = maxId() + 1;
            ps.setInt(1, key);
            ps.setString(2, f.getNome());
            ps.setString(3, f.getContato());
            ps.setString(4, f.getLogin());
            ps.setString(5, f.getSenha());
            ps.setInt(6, f.getPermissao());
            ps.setString(7, f.getEmail());
            ps.executeUpdate();
            Funcionario funcionario = getFuncionario(key);
            return funcionario;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Funcionario update(Funcionario f) {
        try {
            ps = connection.prepareStatement(CreateSQLFuncionario.merge());
            ps.setString(1, f.getNome());
            ps.setString(2, f.getContato());
            ps.setInt(3, f.getPermissao());
            ps.setString(4, f.getEmail());
            ps.setInt(6, f.getIdFuncionario());
            ps.setObject(5, f.getSenha());
            ps.executeUpdate();
            return f;
        } catch (SQLException e) {
            System.out.println("Log: " + e.getMessage());
            return null;
        }
    }

    public Funcionario logar(String login, String senha) {
        try {
            ps = connection.prepareStatement(CreateNamedQueryFuncionario.logar());
            ps.setString(1, login);
            ps.setString(2, ProtegerPasswordUsuario.esconderSenha(senha));
            rs = ps.executeQuery();
            Funcionario f = null;
            if (rs.next()) {
                f = new Funcionario();
                f.setIdFuncionario(rs.getInt("idfuncionario"));
                f.setNome(rs.getString("nome"));
                f.setLogin(rs.getString("login"));
                f.setSenha(rs.getString("senha"));
                f.setPermissao(rs.getInt("permissao"));
            }
            return f;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public Funcionario obter(String email) {
        try {
            ps = connection.prepareStatement(CreateNamedQueryFuncionario.obter());
            ps.setString(1, email);
            rs = ps.executeQuery();
            Funcionario f = null;
            if (rs.next()) {
                f = new Funcionario();
                f.setIdFuncionario(rs.getInt("idfuncionario"));
                f.setNome(rs.getString("nome"));
                f.setLogin(rs.getString("login"));
                f.setPermissao(rs.getInt("permissao"));
                f.setEmail(rs.getString("email"));
                f.setSenha(rs.getString("senha"));
            }
            return f;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void remove(long param) {
     try {
            ps = connection.prepareStatement("delete from funcionario  where idfuncionario = ?");
            ps.setObject(1,param);
            System.out.println("Log:"+ps.toString());
            ps.executeUpdate();           
        } catch (SQLException e) {
            System.out.println("Log: " + e.getMessage());
           
        }
    
    }

   
}
