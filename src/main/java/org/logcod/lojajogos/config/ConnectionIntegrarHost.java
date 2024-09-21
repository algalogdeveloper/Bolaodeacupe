package org.logcod.lojajogos.config;

import java.sql.Connection;
import java.sql.SQLException;
import org.postgresql.ds.PGSimpleDataSource;

public class ConnectionIntegrarHost implements DataSourceConnection {

    @Override    
    public Connection open(){      
        try { 
            PGSimpleDataSource dataSource = new PGSimpleDataSource();
            dataSource.setURL("jdbc:postgresql://localhost:5432/bolaodeacupe_bda");
            dataSource.setPassword("1@cuca82");
            dataSource.setUser("bolaodeacupe_diocesse");
            return dataSource.getConnection();
        } catch (SQLException ex) {
            throw new IllegalArgumentException(ex);
        }
    }
    

}
