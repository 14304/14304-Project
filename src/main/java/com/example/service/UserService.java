package com.example.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.domain.User;
import com.example.exception.core.ValidationError;
import com.example.exception.core.ValidationException;
import com.example.persistence.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by silence on 2017/7/21.
 */
@Service
public class UserService {
    private UserMapper userMapper;

    public UserService(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    // 获取某个部门所有用户
    public List<User> getUsersByDepartmentId(Integer departmentId , Integer page, Integer size){
        if ( departmentId == null ){
            throw new ValidationException( new ValidationError("departmentId","exist") );
        }
        List<User> list = userMapper.selectPage(
                new Page<User>(page,size),
                new EntityWrapper<User>().eq( "department_id",departmentId )
        );
        return list;
    }

    // 测试单元
    public User getDefaultUser(){

        return User.builder()
                .id(6L)
                .username("test_username")
                .password("test_password")
                .departmentId(1L)
                .fullName("test_fullname").build();
    }

}
