package org.logcod.lojajogos.config;

import java.sql.Connection; 

public class ContextConfigDataSource {

    private static Connection connection = null;
    protected JdbcConect conexao = JdbcConect.JdbcIntegratorHost;
    private static ContextConfigDataSource configDataSource;

    private ContextConfigDataSource() {
        try {
            DataSourceConnection conn = conexao.conectJdbcDB();
            connection = conn.open();            
        } catch (Exception e) {
            System.out.println("Conectado com erro: " + e.getMessage());
        }
    }

    public static synchronized ContextConfigDataSource jdbcConectBD() {
        if (configDataSource == null) {
            configDataSource = new ContextConfigDataSource();
        }
        return configDataSource;
    }

    public Connection aberta() {
        return connection;
    }
    
    public void close(){
        try {
            connection.close();
        } catch (Exception e) {
        }
        
    }

   
}
