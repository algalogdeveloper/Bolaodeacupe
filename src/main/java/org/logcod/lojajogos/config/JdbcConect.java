package org.logcod.lojajogos.config;

public enum JdbcConect {

    JdbcIntegratorHost {
        @Override
        public DataSourceConnection conectJdbcDB() {
            return new ConnectionIntegrarHost();
        }
    },
    JdbcJelastic {
        @Override
        public DataSourceConnection conectJdbcDB() {
            return new ConnectionJelastic();
        }
    };
    public abstract DataSourceConnection conectJdbcDB();
}
