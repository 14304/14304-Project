package com.example.web;

import com.example.security.SecurityUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by silence on 2017/7/25.
 */
@RestController
@RequestMapping("/api")
public class DemoRestController {
    @GetMapping("/hello")
    @PreAuthorize("hasRole('ADMIN')")
    public String greeting(){
        return "hello world "+ SecurityUtils.getCurrentUser();
    }

    @GetMapping("/public/api")
    public String publicAPI() {
        return "this is public API";
    }
}
