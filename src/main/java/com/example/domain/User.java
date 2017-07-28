package com.example.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by silence on 2017/7/20.
 */
@Data
@Builder
@NoArgsConstructor  //添加无参数构造器
@TableName("atl_user")
public class User {
    @TableId(type = IdType.AUTO)
    @TableField(strategy = FieldStrategy.NOT_NULL)
    private Long  id;
    @TableField(value = "department_id",strategy = FieldStrategy.NOT_NULL)
    private Long  departmentId;
    @TableField(strategy = FieldStrategy.NOT_NULL)
    private String username;
    @TableField(strategy = FieldStrategy.NOT_NULL)
    private String password;
    @TableField(value = "full_name")
    private String fullName;

}
