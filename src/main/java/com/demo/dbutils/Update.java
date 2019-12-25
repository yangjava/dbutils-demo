package com.demo.dbutils;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Update {


    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    private static final String URL = "jdbc:mysql://localhost:3306/test";

    private static final String USER = "root";

    private static final String PASSWORD = "root";


    public static void main(String[] args) throws SQLException {

        QueryRunner queryRunner = new QueryRunner();
        // 注册驱动
        DbUtils.loadDriver(JDBC_DRIVER);
        //加载连接
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        try {
            // 执行查询
            String sql="Update user set age = ? where id =?";

            int total = queryRunner.update(connection, sql,8,1);

            //从结果集中提取数据
            System.out.println(total+" records updated");
        } finally {
            //清理环境
            DbUtils.close(connection);
        }
    }
}
