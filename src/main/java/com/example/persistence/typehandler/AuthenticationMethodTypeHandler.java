/*
 * Copyright (c) 2017. Shanghai Zhenhui Information Technology Co,. ltd.
 * All rights are reserved.
 */

package com.example.persistence.typehandler;

import com.example.security.AuthenticationMethod;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by markfredchen on 11/07/2017.
 */
public class AuthenticationMethodTypeHandler extends BaseTypeHandler<AuthenticationMethod> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, AuthenticationMethod authenticationMethod, JdbcType jdbcType) throws SQLException {
        if (authenticationMethod != null) {
            ps.setInt(i, authenticationMethod.getId());
        } else {
            ps.setString(i, null);
        }
    }

    @Override
    public AuthenticationMethod getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return AuthenticationMethod.parse(rs.getInt(columnName));
    }

    @Override
    public AuthenticationMethod getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return AuthenticationMethod.parse(rs.getInt(columnIndex));
    }

    @Override
    public AuthenticationMethod getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return AuthenticationMethod.parse(cs.getInt(columnIndex));
    }
}
