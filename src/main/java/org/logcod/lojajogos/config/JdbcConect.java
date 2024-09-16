package org.logcod.lojajogos.config;

public enum JdbcConect {

    JdbcIntegratorHost {
        @Override
        public DataSourceConnection conectJdbcDB() {
            return new ConnectionIntegrarHost();
        }
    },
    JdbcHeroku {
        @Override
        public DataSourceConnection conectJdbcDB() {
            return new ConnectionHeroku();
        }
    },
    JdbcJelastic {
        @Override
        public DataSourceConnection conectJdbcDB() {
            return new ConnectionJelastic();
        }
    },
    JdbcMariadb {
        @Override
        public DataSourceConnection conectJdbcDB() {
            return new ConnectionMariaDB();
        }
    },
    JdbcPostgres {
        @Override
        public DataSourceConnection conectJdbcDB() {
            return new ConnectionPostgresLocal();
        }
    };

    public abstract DataSourceConnection conectJdbcDB();
}
