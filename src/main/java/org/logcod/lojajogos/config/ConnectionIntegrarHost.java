package org.logcod.lojajogos.config;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionIntegrarHost implements DataSourceConnection {

    @Override
    public java.sql.Connection open() {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/bolaodeacupe_bda", "bolaodeacupe_diocesse", "1@cuca82");
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            return null;

        }

    }
    

}
