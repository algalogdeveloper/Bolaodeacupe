package org.logcod.lojajogos.migration;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Objects;
import org.flywaydb.core.Flyway;

public class FlywayConfig {

    public static void createConfigFlywayDB() {
         
           Flyway flyway = Flyway.configure()
                    .dataSource("jdbc:postgresql://" + conectDBHost() + ":5432/bolaodeacupe_bda", "bolaodeacupe_diocesse",
                            "1@cuca82")
                    .load();
            flyway.migrate();
       
    }

    public static String conectDBHost(){
        try {
            Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces();
            String[] hosts = new String[5];
            int count = 1;
            while (nis.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) nis.nextElement();
                Enumeration<InetAddress> ias = ni.getInetAddresses();
                while (ias.hasMoreElements()) {
                    InetAddress ia = (InetAddress) ias.nextElement();
                    hosts[count++] = ia.getHostAddress();
                }
            }
            return Objects.equals(hosts[3], "127.0.0.1") ? "127.0.0.1" : hosts[3];
        } catch (SocketException e) {
            return "127.0.0.1";
        }

    }

}
