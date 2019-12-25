package com.demo.dbutils;

import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserHandler extends BeanHandler<User> {

    public UserHandler() {
        super(User.class);
    }

    @Override
    public User handle(ResultSet rs) throws SQLException {
        User user = super.handle(rs);
        user.setEmail(user.getName() +"@163.com");
        return user;
    }
}
