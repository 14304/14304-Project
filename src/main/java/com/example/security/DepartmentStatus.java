package com.example.security;

import com.example.domain.SysEnum;
import org.springframework.util.Assert;

/**
 * Created by silence on 2017/7/21.
 */
public enum  DepartmentStatus implements SysEnum {
    ENABLED(1), DISABLED (0);

    private int id;

    DepartmentStatus(int id) {
        this.id = id;
    }

    public static DepartmentStatus parse(int id) {
        DepartmentStatus departmentStatus = null;
        for (DepartmentStatus method : DepartmentStatus.values()) {
            if (method.getId() == id) {
                departmentStatus = method;
            }
        }
        Assert.notNull(departmentStatus, "DepartmentStatus[id=" + id + "] not found");
        return departmentStatus;
    }

    @Override
    public int getId() {
        return this.id;
    }
}
