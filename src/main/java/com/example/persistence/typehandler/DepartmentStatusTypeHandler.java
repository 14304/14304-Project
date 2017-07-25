package com.example.persistence.typehandler;

import com.example.security.DepartmentStatus;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by silence on 2017/7/21.
 */
public class DepartmentStatusTypeHandler extends BaseTypeHandler<DepartmentStatus> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, DepartmentStatus departmentStatus, JdbcType jdbcType) throws SQLException {
        if (departmentStatus != null) {
            ps.setInt(i, departmentStatus.getId());
        } else {
            ps.setString(i, null);
        }
    }

    @Override
    public DepartmentStatus getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return DepartmentStatus.parse(rs.getInt(columnName));
    }

    @Override
    public DepartmentStatus getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return DepartmentStatus.parse(rs.getInt(columnIndex));
    }

    @Override
    public DepartmentStatus getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return DepartmentStatus.parse(cs.getInt(columnIndex));
    }
}
