package com.example.web;

import com.example.domain.User;
import com.example.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by silence on 2017/7/21.
 */

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("search/by/department")
    public List<User> getUsersByDepartmentId(@RequestParam Integer id,@RequestParam Integer page,@RequestParam Integer size){
        List<User> list = null;
        try {
             list = userService.getUsersByDepartmentId( id , page, size );
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @GetMapping("/default")
    public User getDefaultUser(){
        return userService.getDefaultUser();
    }
}
