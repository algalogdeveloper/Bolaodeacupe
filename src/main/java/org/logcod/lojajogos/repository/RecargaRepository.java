package org.logcod.lojajogos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.logcod.lojajogos.config.ContextConfigDataSource;
import org.logcod.lojajogos.model.entity.Recarga;

public class RecargaRepository {

    protected Connection connection;
    protected ContextConfigDataSource dataSource;

    public RecargaRepository() {
        dataSource = ContextConfigDataSource.jdbcConectBD();
        connection = dataSource.aberta();
    }

    public void enviarRecarga(Recarga r) {
        try {
            PreparedStatement ps = connection
                    .prepareStatement("insert into recarga values (?,?,?,?) ");
            ps.setObject(1, (ultimoId() + 1));
            ps.setObject(2, r.getDataRecarga());
            ps.setObject(3, r.getDescricao());
            ps.setObject(4, r.getValor());
            ps.execute();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    
     public void updateRecarga(Recarga r) {
        try {
            PreparedStatement ps = connection
                    .prepareStatement("update recarga set datarecarga = ?, descricao = ? , valorrecarga = ? where idrecarga = ? ");
            ps.setObject(4,r.getIdRecarga());
            ps.setObject(3, r.getValor());
            ps.setObject(2, r.getDescricao());
            ps.setObject(1, r.getDataRecarga());            
            ps.execute();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    
    public Recarga ultimaRecarga() {
        try {
            PreparedStatement ps = connection.prepareStatement("select * from recarga where idrecarga = ?");
            ps.setObject(1, ultimoId());
            System.out.println("Ultima Recarga: "+ps.toString());
            ResultSet rs = ps.executeQuery();
            Recarga recarga = null;
            if (rs.next()) {
                recarga = new Recarga(rs.getLong(1), rs.getDate(2).toLocalDate(), rs.getString(3), rs.getDouble(4));
            }
            return recarga;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
    
    
     public List<Recarga> todasRecargas() {
        try {
            PreparedStatement ps = connection.prepareStatement("select * from recarga order by idrecarga");
            ResultSet rs = ps.executeQuery();
            List<Recarga> recargas = new ArrayList<>();
            while (rs.next()) {
              Recarga  recarga = new Recarga(rs.getLong(1), rs.getDate(2).toLocalDate(), rs.getString(3),rs.getDouble(4));
              recargas.add(recarga);
            }
            return recargas;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    protected long ultimoId() {
        try {
            PreparedStatement ps = connection.prepareStatement("select max(idrecarga) as ultimo from recarga");
            ResultSet rs = ps.executeQuery();
            System.out.println("Ultima ID: "+ps.toString());
            long ultimoId = 0;
            if (rs.next()) 
             ultimoId = rs.getInt("ultimo");
            return ultimoId;
        } catch (SQLException e) {
           return 0;
        }
    }
    
    public void remover (long id){
        try {
            PreparedStatement ps = connection.prepareStatement("delete from recarga where idrecarga = ?");
            ps.setObject(1, id);
            ps.execute();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

}
