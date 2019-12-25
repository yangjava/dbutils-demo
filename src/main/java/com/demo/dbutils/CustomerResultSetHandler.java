package com.demo.dbutils;

import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerResultSetHandler <T> implements ResultSetHandler<T> {
    @Override
    public T handle(ResultSet rs) throws SQLException {
        return null;
    }

}
