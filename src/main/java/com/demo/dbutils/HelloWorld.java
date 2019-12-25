package com.demo.dbutils;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HelloWorld {

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
            User user = queryRunner.query(connection, "SELECT * FROM user WHERE id=?",
                    new BeanHandler<User>(User.class), "1");
            //从结果集中提取数据
            System.out.println(user.toString());
        } finally {
            //清理环境
            DbUtils.close(connection);
        }
    }


}
