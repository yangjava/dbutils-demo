package com.demo.dbutils;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class DataSourceQuery {

    public static void main(String[] args) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(CustomDataSource.getInstance());
        // 执行查询
        User user = queryRunner.query("SELECT * FROM user WHERE id=?",
                new BeanHandler<User>(User.class), "1");
        //从结果集中提取数据
        System.out.println(user.toString());
    }
}
