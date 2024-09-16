package org.logcod.lojajogos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.logcod.lojajogos.config.ContextConfigDataSource;
import org.logcod.lojajogos.jdbc.queries.jogo.CreateNamedQueryJogo;
import org.logcod.lojajogos.jdbc.sql.jogo.CreateSQLJogo;
import org.logcod.lojajogos.model.entity.Milhar;

public class RepositoryMilhar {

    private final Connection connection;
    protected ContextConfigDataSource dataSource;

    public RepositoryMilhar() {
        dataSource = ContextConfigDataSource.jdbcConectBD();
        connection = dataSource.aberta();
    }

    public void salvarJogo(Milhar jogo) {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateSQLJogo.insertJogo());
            ps.setInt(1, retornaChave() + 1);
            ps.setString(2, jogo.getValue());
            ps.setBoolean(3, jogo.isDisponivel());
            ps.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public int retornaChave() {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateNamedQueryJogo.retornaChave());
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

    public Milhar getJogo(String value) {

        Milhar jogo = null;
        try {
            PreparedStatement pst = connection.prepareStatement(CreateNamedQueryJogo.getJogo());
            pst.setString(1, value);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                jogo = new Milhar();
                jogo.setIdMilhar(rs.getInt(1));
                jogo.setValue(rs.getString(2));
                jogo.setDisponivel(rs.getBoolean(3));
            }
            return jogo;
        } catch (SQLException e) {
            System.out.println("Não encontrado: " + e.getSQLState());
            return jogo;
        }

    }

    public Milhar find(String value) {

        Milhar jogo = null;
        try {
            PreparedStatement pst = connection.prepareStatement(CreateNamedQueryJogo.findJogo());
            pst.setString(1, value);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                jogo = new Milhar();
                jogo.setIdMilhar(rs.getInt(1));
                jogo.setValue(rs.getString(2));
                jogo.setDisponivel(rs.getBoolean(3));
            }
            return jogo;
        } catch (SQLException e) {
            System.out.println("Não encontrado: " + e.getSQLState());
            return jogo;
        }

    }

    public Milhar getJogo(Integer value) {

        Milhar jogo = null;
        try {
            PreparedStatement pst = connection.prepareStatement(CreateNamedQueryJogo.getJogoId());
            pst.setInt(1, value);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                jogo = new Milhar();
                jogo.setIdMilhar(rs.getInt(1));
                jogo.setValue(rs.getString(2));
                jogo.setDisponivel(rs.getBoolean(3));

            }
            return jogo;
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return jogo;
        }

    }

    public List<Milhar> getJogos(String value) {
        List<Milhar> jogos = new ArrayList<>();
        try {
            PreparedStatement pst = connection.prepareStatement(CreateNamedQueryJogo.getJogos(value));
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Milhar jogo = new Milhar();
                jogo.setIdMilhar(rs.getInt(1));
                jogo.setValue(rs.getString(2));
                jogo.setDisponivel(rs.getBoolean(3));
                jogos.add(jogo);
            }
            return jogos;
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return jogos;
        }

    }

    public Collection<Milhar> selecioneMilharVendidos(String buscar) {
        Collection<Milhar> jogos = new ArrayList<>();
        try {
            PreparedStatement pst = connection.prepareStatement(CreateNamedQueryJogo.selecioneMilharVendidos());
            pst.setString(1, "%" + buscar + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Milhar jogo = new Milhar();
                jogo.setIdMilhar(rs.getInt(1));
                jogo.setValue(rs.getString(2));
                jogo.setDisponivel(rs.getBoolean(3));
                jogos.add(jogo);
            }
            return jogos;
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            return jogos;
        }

    }

    public int getNaoDisponivel(Milhar jogo) {
        try {
            PreparedStatement pst = connection.prepareStatement(CreateSQLJogo.naoDisponivel());
            pst.setString(1, jogo.getValue());
            return pst.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
            return -1;
        }

    }

    public Milhar obterMilhar(String numero) {
        try {
            PreparedStatement pst = connection.prepareStatement(CreateNamedQueryJogo.createQueryMilharVinculadoAhPessoa());
            pst.setString(1, numero);
            ResultSet rs = pst.executeQuery();
            Milhar milhar = null;
            while (rs.next()) {
                milhar = new Milhar();
                milhar.setIdMilhar(rs.getInt("idjogo"));
                milhar.setValue(rs.getString("numero"));
                milhar.setDisponivel(rs.getBoolean("disponivel"));
            }
            return milhar;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public int getNaoDisponivel(int jogo) {

        try {
            PreparedStatement pst = connection.prepareStatement(CreateSQLJogo.getNaoDisponivel());
            pst.setInt(1, jogo);
            System.out.println(pst.toString());
            return pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return -1;
        }

    }

    public int getDisponivel(String milhar) {
        try {
            PreparedStatement pst = connection.prepareStatement(CreateSQLJogo.disponivel());
            pst.setString(1, milhar);
            System.out.println(pst.toString());
            return pst.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
            return -1;
        }
    }

    public int getDisponivel(Milhar milhar) {
        try {
            PreparedStatement pst = connection.prepareStatement(CreateSQLJogo.disponivelMilhar());
            pst.setString(1, milhar.getValue());
            return pst.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
            return -1;
        }
    }

    public int todosDisponiveis() {
        try {
            PreparedStatement pst = connection.prepareStatement(CreateSQLJogo.all());
            return pst.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
            return -1;
        }
    }

}
