package com.demo.dbutils;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UserRowHandler extends BeanHandler<User> {

    public UserRowHandler() {
        super(User.class, new BasicRowProcessor(new BeanProcessor(mapColumnsToFields())));
    }

    @Override
    public User handle(ResultSet rs) throws SQLException {
        User user = super.handle(rs);
        user.setEmail(user.getName() +"@163.com");
        return user;
    }

    public static Map<String, String> mapColumnsToFields() {
        Map<String, String> columnsToFieldsMap = new HashMap<>();
        columnsToFieldsMap.put("ID", "id");
        columnsToFieldsMap.put("AGE", "age");
        return columnsToFieldsMap;
    }


}
