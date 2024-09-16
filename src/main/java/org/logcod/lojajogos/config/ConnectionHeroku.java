package org.logcod.lojajogos.config;

import java.sql.DriverManager;
import java.util.Properties;

import org.logcod.lojajogos.config.util.Informacoes;

public class ConnectionHeroku implements DataSourceConnection {
    protected String HOST="ec2-34-207-12-160.compute-1.amazonaws.com";
    protected String USER="nabnqoipzpuptr";
    protected String PASSWD="1b0a0b6a8fa7f41fba98b6fa41313f4a3771189c1428c2d83b3b6c4c29e270d4";
    protected String BD = "d4guqohis59qqt";
    @Override
    public java.sql.Connection open() {
        try {
            Properties ps = new Properties();
            ps.setProperty("user", USER);
            ps.setProperty("password", PASSWD);
            Class.forName("org.postgresql.Driver").newInstance();
            return DriverManager.getConnection("jdbc:postgresql://"+HOST+":5432/"+BD+"?sslmode = require", ps);
	       	} catch (Exception e) {
            Informacoes.SOP(e.getCause());
            return null;
        }

    }

}
