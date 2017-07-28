package com.example.domain;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import com.baomidou.mybatisplus.enums.IdType;
import com.example.security.AuthenticationMethod;
import com.example.security.DepartmentStatus;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.ZonedDateTime;


/**
 * Created by silence on 2017/7/20.
 */
@Data
@TableName("atl_department")
public class Department{

    @TableField(strategy = FieldStrategy.NOT_NULL)
    private Long id;
    @TableField(value="department_name",strategy = FieldStrategy.NOT_NULL)
    private String name;
    private String code;
    @TableField(value="department_status",strategy = FieldStrategy.NOT_NULL)
    private DepartmentStatus status;
    @TableField(strategy = FieldStrategy.NOT_NULL)
    private ZonedDateTime createDate;




}
