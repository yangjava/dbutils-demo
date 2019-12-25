package com.demo.dbutils;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Create {


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
            String sql="INSERT INTO user (id, name, age, email) VALUES(?,?,?,?)";

            int total = queryRunner.update(connection, sql,8,"冯八", "15","test8@163.com");

            //从结果集中提取数据
            System.out.println(total+" records inserted");
        } finally {
            //清理环境
            DbUtils.close(connection);
        }
    }
}
