package org.logcod.lojajogos.config;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionJelastic implements DataSourceConnection {

    protected Properties conectJdbc() {
        try {
            Properties properties = System.getProperties();
            properties.load(getClass().getClassLoader().getResourceAsStream("datasourcejdbc.properties"));
            return properties;
        } catch (IOException ex) {
            throw new IllegalArgumentException(ex);
        }

    }

    @Override
    public java.sql.Connection open() {
        Properties properties = conectJdbc();
        try {
            Class.forName(properties.getProperty("driver")).newInstance();
            DriverManager.setLoginTimeout(100);
            return DriverManager.getConnection(properties.getProperty("url"), properties);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            return null;
        }

    }

}
