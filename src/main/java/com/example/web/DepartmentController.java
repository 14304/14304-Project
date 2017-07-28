package com.example.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.domain.Department;
import com.example.domain.User;
import com.example.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import com.example.exception.core.ValidationError;
import com.example.exception.core.ValidationException;

/**
 * Created by silence on 2017/7/20.
 */
@RestController
@RequestMapping("/api")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController( DepartmentService departmentService ){
        this.departmentService = departmentService;
    }

    // 查询部门列表
    @GetMapping("/departments")
    public List<Department> getDepartments(@RequestParam Integer current,@RequestParam Integer size){
        if( current == null ){
            throw new ValidationException( new ValidationError( "current", "should.be.empty") );
        }
        if ( size == null ) {
            throw new ValidationException( new ValidationError( "size", "should.be.empty") );
        }
       Page<Department> page = new Page<Department>(current,size);
       return departmentService.getDepartments(page);
    }

    // 根据Id查询部门列表
    @GetMapping("/departments/{departmentId}")
    public Department getDepartmentByID(@PathVariable Long departmentId){
        if( departmentId == null ){
            throw new ValidationException( new ValidationError( "departmentId", "should.be.empty") );
        }
        return departmentService.getDepartmentByID( departmentId );
    }

    // 根据部门名称搜索部门列表
    @GetMapping("/departments/search")
    public Department searchDepartment(@RequestParam String keyword){
        if( keyword == null ){
            throw new ValidationException( new ValidationError( "departmentName", "should.be.empty") );
        }
        return departmentService.searchDepartment( keyword );
    }

    // 新增
    @PostMapping("/departments")
    public Department insertDepartment(@RequestBody @Valid Department department){
        return departmentService.createDepartment( department );
    }

    // 修改
   @PutMapping("/departments")
    public Department updateDepartment(@RequestBody @Valid Department department){
        return  departmentService.updateDepartment( department );
    }

    // 实验两个update效果
    /*@PutMapping("/departments")
    public String updateDepartment(@RequestBody Department department){

       *//*departmentService.update(department,new EntityWrapper<Department>());*//*
        departmentService.updateAllColumnById(department);
        return "success update";
    }*/

    // 删除
    @DeleteMapping("/departments/{departmentId}")
    public void deleteDepartment(@PathVariable Long departmentId){
        if( departmentId == null ){
            throw new ValidationException( new ValidationError( "departmentId", "should.be.empty") );
        }
        departmentService.deleteDepartment( departmentId );
    }

}
