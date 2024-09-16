package org.logcod.lojajogos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import org.logcod.lojajogos.config.ContextConfigDataSource;
import org.logcod.lojajogos.jdbc.queries.centena.CreateNamedQueryGratis;
import org.logcod.lojajogos.jdbc.queries.centena.CreateNamedQueryGratisinha;
import org.logcod.lojajogos.jdbc.sql.centena.CreateSqlGratis;
import org.logcod.lojajogos.jdbc.sql.centena.CreateSqlGratisinha;
import org.logcod.lojajogos.model.entity.CentenaGratis;
import org.logcod.lojajogos.model.entity.CentenaGratisinha;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.model.entity.Local;
import org.logcod.lojajogos.model.entity.Pessoa;
import org.logcod.lojajogos.service.CompraService;

public class RepositoryCentena {

    Connection connection;
    ContextConfigDataSource dataSource;

    public RepositoryCentena() {

        dataSource = ContextConfigDataSource.jdbcConectBD();
        connection = dataSource.aberta();
    }

    public boolean enviaCentenaGratis(CentenaGratis gratis) {
        try {
            PreparedStatement ps = connection
                    .prepareStatement(CreateSqlGratis.save());
            int chave = maxCentenaGratis() + 1;
            gratis.setIdCentena(chave);
            ps.setInt(1, gratis.getIdCentena());
            ps.setString(2, gratis.getNumero());
            ps.setInt(3, gratis.getCompra().getIdCompra());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean enviaCentenaGratis(CentenaGratisinha gratis) {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateSqlGratisinha.save());
            int chave = maxCentenaGratisinha() + 1;
            gratis.setIdCentena(chave);
            ps.setInt(1, gratis.getIdCentena());
            ps.setString(2, gratis.getNumero());
            ps.setInt(3, gratis.getCompra().getIdCompra());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public int maxCentenaGratis() {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateNamedQueryGratis.maxCentenaGratis());
            ResultSet rs = ps.executeQuery();
            rs.next();
            int id_centena = 0;
            id_centena = rs.getInt("id_centena");
            return id_centena;
        } catch (Exception e) {
            // TODO: handle exception
            return 0;
        }
    }

    public int qtdCentenaGratis() {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateNamedQueryGratis.qtdCentenaGratis());
            ResultSet rs = ps.executeQuery();
            rs.next();
            int id_centena = 0;
            id_centena = rs.getInt("id_centena");
            return id_centena;
        } catch (Exception e) {
            System.out.println(e);
            return 1;
        }
    }

    public int maxCentenaGratisinha() {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateNamedQueryGratisinha.maxCentenaGratisinha());
            ResultSet rs = ps.executeQuery();
            rs.next();
            int id_centena = 0;
            id_centena = rs.getInt("id_centena");
            return id_centena;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public int qtdCentenaGratisinha() {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateNamedQueryGratisinha.qtdCentenaGratisinha());
            ResultSet rs = ps.executeQuery();
            rs.next();
            int id_centena = 0;
            id_centena = rs.getInt("id_centena");
            return id_centena;
        } catch (Exception e) {
            return 1;
        }
    }

    public void deletaCentenaGratis(int idcompra) {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateSqlGratis.remove());
            ps.setInt(1, idcompra);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Log: " + e.getMessage());
        }
    }

    public void deletaCentenaGratisinha(int idcompra) {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateSqlGratisinha.remove());
            ps.setInt(1, idcompra);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Log: " + e.getMessage());
        }
    }

    public void deleteCentenas(int idcompra) {

        deletaCentenaGratis(idcompra);
        deletaCentenaGratisinha(idcompra);
    }

    CompraService compraService = new CompraService();

    public CentenaGratis getCentenaGratis(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateNamedQueryGratis.obter());
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            CentenaGratis centenaGratis = null;
            while (rs.next()) {
                centenaGratis = new CentenaGratis(rs.getInt(1), rs.getString(2),
                        compraService.obterCompra(rs.getInt(3)));
            }
            return centenaGratis;
        } catch (Exception e) {
            return null;
        }
    }

    public CentenaGratisinha getCentenaGratisinha(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateNamedQueryGratisinha.obter());
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            CentenaGratisinha centenaGratis = null;
            while (rs.next()) {
                centenaGratis = new CentenaGratisinha(rs.getInt(1), rs.getString(2),
                        compraService.obterCompra(rs.getInt(3)));
            }
            return centenaGratis;
        } catch (Exception e) {
            return null;
        }
    }

    public List<CentenaGratis> listaCompraComCentenasGratis() {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateNamedQueryGratis.all());
            ResultSet rs = ps.executeQuery();
            List<CentenaGratis> centenaGratis = new ArrayList<>();
            while (rs.next()) {
                CentenaGratis c = new CentenaGratis();
                c.setIdCentena(rs.getInt("id_centena"));
                c.setNumero(rs.getString("numero"));
                c.setCompra(compraService.obterCompra(rs.getInt("idcompra")));
                centenaGratis.add(c);

            }
            return centenaGratis;

        } catch (Exception e) {
            return null;
        }

    }

    public List<CentenaGratisinha> listaCompraComCentenasGratisinha() {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateNamedQueryGratisinha.all());
            ResultSet rs = ps.executeQuery();
            List<CentenaGratisinha> centenaGratis = new ArrayList<CentenaGratisinha>();
            while (rs.next()) {
                CentenaGratisinha c = new CentenaGratisinha();
                c.setIdCentena(rs.getInt(1));
                c.setNumero(rs.getString(2));
                c.setCompra(compraService.obterCompra(rs.getInt(3)));
                centenaGratis.add(c);

            }
            return centenaGratis;

        } catch (Exception e) {
            return null;
        }

    }

    int auto = 1;

    public CentenaGratis obterCentena(String centena) {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateNamedQueryGratis.obter2());
            ps.setString(1, centena);
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            CentenaGratis c = null;
            if (rs.next()) {
                c = new CentenaGratis();
                c.setIdCentena(rs.getInt(1));
                c.setNumero(rs.getString(2));
                c.setCompra(compraService.obterCompra(rs.getInt(3)));
                return c;
            }

            return new CentenaGratis(auto++, centena,
                    new Compra(new Pessoa("Não encontrada", new Local("Não encontrado"))));

        } catch (SQLException e) {
            return new CentenaGratis(auto, centena,
                    new Compra(new Pessoa("Não encontrada", new Local("Não encontrado"))));
        }

    }

    int auto2 = 1;

    public CentenaGratisinha obterCentenaGratisinha(String centena) {

        try {
            PreparedStatement ps = connection.prepareStatement(CreateNamedQueryGratisinha.obter2());
            ps.setString(1, centena);
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            CentenaGratisinha c = null;
            if (rs.next()) {
                c = new CentenaGratisinha();
                c.setIdCentena(rs.getInt(1));
                c.setNumero(rs.getString(2));
                c.setCompra(compraService.obterCompra(rs.getInt(3)));
                return c;
            }

            return new CentenaGratisinha(auto2++, centena,
                    new Compra(new Pessoa("Não encontrada", new Local("Não encontrado"))));

        } catch (SQLException e) {
            return new CentenaGratisinha(auto2, centena,
                    new Compra(new Pessoa("Não encontrada", new Local("Não encontrado"))));
        }

    }

    public CentenaGratis obter(String centena) {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateNamedQueryGratis.find());
            ps.setString(1, centena);
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            CentenaGratis c = null;
            if (rs.next()) {
                c = new CentenaGratis();
                c.setIdCentena(rs.getInt(1));
                c.setNumero(rs.getString(2));
                c.setCompra(compraService.obterCompra(rs.getInt(3)));
            }
            return c;

        } catch (SQLException e) {
            return null;
        }

    }

    public CentenaGratisinha obterTwo(String centena) {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateNamedQueryGratisinha.find());
            ps.setString(1, centena);
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            CentenaGratisinha c = null;
            if (rs.next()) {
                c = new CentenaGratisinha();
                c.setIdCentena(rs.getInt(1));
                c.setNumero(rs.getString(2));
                c.setCompra(compraService.obterCompra(rs.getInt(3)));
            }
            return c;
        } catch (SQLException e) {
            return null;
        }
    }

    public void modificarCentena(CentenaGratis gratis) {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateSqlGratis.merge());
            ps.setString(1, gratis.getNumero());
            ps.setInt(2, gratis.getIdCentena());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e);

        }
    }

    public boolean deleteCentena(int id_centena) {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateSqlGratis.remove2());
            ps.setInt(1, id_centena);
            ps.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean deleteCentenaTow(Integer valueOf) {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateSqlGratisinha.remove2());
            ps.setInt(1, valueOf);
            ps.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public void modificarCentena(CentenaGratisinha gratis) {
        try {
            PreparedStatement ps = connection.prepareStatement(CreateSqlGratisinha.merge());
            ps.setString(1, gratis.getNumero());
            ps.setInt(2, gratis.getIdCentena());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e);

        }
    }

    public LinkedHashSet<CentenaGratis> buscarCentenasGratisPelaCompraCliente(int param) {
          try {
            PreparedStatement ps = connection.prepareStatement("select * from centena_gratis cg where cg.idcompra = ?");
            ps.setObject(1, param);
            ResultSet rs = ps.executeQuery();
            LinkedHashSet<CentenaGratis> centenaGratis = new LinkedHashSet<>();
            while (rs.next()) {
                CentenaGratis c = new CentenaGratis();
                c.setIdCentena(rs.getInt(1));
                c.setNumero(rs.getString(2));
                centenaGratis.add(c);
            }
            return centenaGratis;

        } catch (SQLException e) {
            return null;
        }

    }
    
    public LinkedHashSet<CentenaGratisinha> buscarCentenasGratisinha(int param) {
          try {
            PreparedStatement ps = connection.prepareStatement("select * from centena_gratisinha cg where cg.idcompra = ?");
            ps.setObject(1, param);
            ResultSet rs = ps.executeQuery();
            LinkedHashSet<CentenaGratisinha> centenas = new LinkedHashSet<>();
            while (rs.next()) {
                CentenaGratisinha c = new CentenaGratisinha();
                c.setIdCentena(rs.getInt(1));
                c.setNumero(rs.getString(2));
                centenas.add(c);
            }
            return centenas;

        } catch (SQLException e) {
            return null;
        }

    }


}
