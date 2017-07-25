package com.example.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.domain.User;
import com.example.exception.core.ValidationError;
import com.example.exception.core.ValidationException;
import com.example.persistence.DepartmentMapper;
import com.example.persistence.UserMapper;
import com.example.security.DepartmentStatus;
import org.springframework.stereotype.Service;
import com.example.domain.Department;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * Created by silence on 2017/7/20.
 */
@Service
public class DepartmentService extends ServiceImpl<DepartmentMapper,Department>{

    private DepartmentMapper departmentMapper;
    private UserMapper userMapper;

    public DepartmentService(){

    }

    public DepartmentService ( DepartmentMapper departmentMapper ){
        this.departmentMapper = departmentMapper;
    }

    public DepartmentService ( DepartmentMapper departmentMapper , UserMapper userMapper){
        this.departmentMapper = departmentMapper;
        this.userMapper = userMapper;
    }
    // 查询部门列表
    public List<Department> getDepartments(Page<Department> page){

        List<Department> list = departmentMapper.selectPage(
                page,
                new EntityWrapper<Department>()
        );
        return list;
    }
    // 根据Id获取部门
    public Department getDepartmentByID(Long id){
        return  departmentMapper.selectById( id );
    }
    // 按部门名称查询
    public Department searchDepartment(String name){
        Department department = new Department();
        department.setName( name );
        return departmentMapper.selectOne( department );
    }
    // 新增
    public Department createDepartment(Department department){

        department.setCreateDate( ZonedDateTime.now() );
        try{
            departmentMapper.insert( department );
        }catch (ValidationException Val){
            throw new ValidationException( new ValidationError("department","exist") );
        }
        return department;
    }
    // 修改
    public void updateDepartment(Department department){

        try{
            departmentMapper.updateById( department );
        }catch (ValidationException Val){
            throw new ValidationException( new ValidationError("department","exist") );
        }

    }
    // 删除
    public int deleteDepartment(Long id){
        return departmentMapper.deleteById( id );
    }

   /* // 获取某个用户所属部门
    public Department queryUserToDepartment( BigInteger departmentId ){
        Department department = departmentMapper.selectById( departmentId );
        return  department;
    }*/
}
