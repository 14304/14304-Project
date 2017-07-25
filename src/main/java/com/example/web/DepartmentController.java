package com.example.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.domain.Department;
import com.example.domain.User;
import com.example.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
import java.util.List;

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
       Page<Department> page = new Page<Department>(current,size);
       return departmentService.getDepartments(page);
    }
    // 根据Id查询部门列表
    @GetMapping("/departments/{departmentId}")
    public Department getDepartmentByID(@PathVariable Long departmentId){
        return departmentService.getDepartmentByID( departmentId );
    }
    // 根据部门名称搜索部门列表
    @GetMapping("/departments/search")
    public Department searchDepartment(@RequestParam String keyword){
        return departmentService.searchDepartment( keyword );
    }
    // 新增
    @PostMapping("/departments")
    public String insertDepartment(@RequestBody @Valid Department department){
        try{
            departmentService.createDepartment( department );
        }catch (Exception e){
            e.printStackTrace();
            return "failed insert";
        }
        return "success insert";
    }
    // 修改
   /* @PutMapping("/departments")
    public String updateDepartment(@RequestBody @Valid Department department){
        try {
            departmentService.updateDepartment( department );
        }catch (Exception e){
            e.printStackTrace();
            return "failed update";
        }
        return "success update";

    }*/
    @PutMapping("/departments")
    public String updateDepartment(@RequestBody Department department){
        /*try {
            departmentService.updateDepartment( department );
        }catch (Exception e){
            e.printStackTrace();
            return "failed update";
        }*/
       /* departmentService.update(department,new EntityWrapper<Department>());*/
        departmentService.updateAllColumnById(department);
        return "success update";
    }
    // 删除
    @DeleteMapping("/departments/{departmentId}")
    public String deleteDepartment(@PathVariable Long departmentId){
        return "success delete : "+ departmentService.deleteDepartment(departmentId);
    }
   /* @GetMapping("/users/search/by/department")
    public List<User> getUsersByDepartmentId(@RequestParam Integer id,@RequestParam Integer page,@RequestParam Integer size){
        return departmentService.getUsersByDepartmentId( id , page, size );
    }*/

    /*@GetMapping("/selectUserDep")
    public Department queryUserToDepartment(@RequestParam BigInteger id){
        return departmentService.queryUserToDepartment( id );
    }*/
}
