package com.demo.dbutils;

import com.mchange.v2.c3p0.jboss.C3P0PooledDataSource;
import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

public class CustomDataSource {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    private static final String URL = "jdbc:mysql://localhost:3306/test";

    private static final String USER = "root";

    private static final String PASSWORD = "root";

    private static final BasicDataSource basicDataSource;

    static {
        basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(JDBC_DRIVER);
        basicDataSource.setUsername(USER);
        basicDataSource.setPassword(PASSWORD);
        basicDataSource.setUrl(URL);
    }

    public static DataSource getInstance() {
        return basicDataSource;
    }

}
