package org.logcod.lojajogos.config;

import java.sql.Connection;
import java.sql.DriverManager;

import org.logcod.lojajogos.config.util.Informacoes;

public class ConnectionMariaDB implements DataSourceConnection {

    protected String url = "jdbc:mysql://127.0.0.1:3306/bolaodeacupe";
    protected String user = "root";
    protected String password = "";

    @Override
    public Connection open() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Informacoes.SOP("conectado...");
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            Informacoes.SOP(e.fillInStackTrace());
            return null;
        }

    }

}
