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
import org.springframework.dao.DataIntegrityViolationException;
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

   /* public DepartmentService(){

    }*/

   /* public DepartmentService ( DepartmentMapper departmentMapper ){
        this.departmentMapper = departmentMapper;
    }*/

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
        if ( department.getId() == null ){
            throw new ValidationException( new ValidationError("id","should.be.empty") );
        }
        department.setCreateDate( ZonedDateTime.now() );
        try{
            departmentMapper.insert( department );
        }catch (ValidationException Val){
            throw new ValidationException( new ValidationError("department","not.unique") );
        }
        return department;
    }

    // 修改
    public Department updateDepartment(Department department){
        if ( department.getId() == null ){
            throw new ValidationException( new ValidationError("id","should.be.empty") );
        }
        try{
            departmentMapper.updateById( department );
        }catch (ValidationException Val){
           throw new ValidationException( new ValidationError("department","not.unique") );
        }
        return department;
    }

    // 删除
    public void deleteDepartment(Long id){
        departmentMapper.deleteById( id );
    }

}
