package net.ys.mapper;

import net.ys.bean.Admin;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminMapper implements RowMapper<Admin> {
    @Override
    public Admin mapRow(ResultSet resultSet, int i) throws SQLException {
        Admin admin = new Admin();
        admin.setId(resultSet.getString("id"));
        admin.setMagType(resultSet.getInt("mag_type"));
        admin.setUsername(resultSet.getString("username"));
        admin.setPwd(resultSet.getString("pwd"));
        return admin;
    }
}