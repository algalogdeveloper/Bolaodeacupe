package org.logcod.lojajogos.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionPostgresLocal implements DataSourceConnection {

    @Override
    public Connection open() {
        try {
            Properties properties = conectDB();
            Class.forName(properties.getProperty("driver")).newInstance();
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/bolaodeacupe_bda", properties);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException(e.getLocalizedMessage());
        }

    }

    
    private Properties conectDB() {
        try {
            InputStream loader = ConnectionPostgresLocal.class.getClassLoader()
                    .getResourceAsStream("config.properties");
            Properties properties = new Properties();
            properties.load(loader);
            return properties;
        } catch (IOException e) {
            return null;
        }

    }
}
