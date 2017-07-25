/*
 * Copyright (c) 2017. Shanghai Zhenhui Information Technology Co,. ltd.
 * All rights are reserved.
 */

package com.example.security;

import com.example.domain.SysEnum;
import org.springframework.util.Assert;

/**
 * Created by markfredchen on 11/07/2017.
 */
public enum AuthenticationMethod implements SysEnum {
    ENABLED(1), DISABLED (0);

    private int id;

    AuthenticationMethod(int id) {
        this.id = id;
    }

    public static AuthenticationMethod parse(int id) {
        AuthenticationMethod authenticationMethod = null;
        for (AuthenticationMethod method : AuthenticationMethod.values()) {
            if (method.getId() == id) {
                authenticationMethod = method;
            }
        }
        Assert.notNull(authenticationMethod, "AuthenticationMethod[id=" + id + "] not found");
        return authenticationMethod;
    }

    @Override
    public int getId() {
        return this.id;
    }
}
