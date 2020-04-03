/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.ibm.mosesboot.exam.User
 * @version V1.0
 */
package com.ibm.mosesboot.exam;

import java.util.Date;

/**
 * @author Moses
 * @date 2020/4/3
 */
public class User {
    private String username;
    private Date register_time;

    public User(String username, Date register_time) {
        this.username = username;
        this.register_time = register_time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getRegister_time() {
        return register_time;
    }

    public void setRegister_time(Date register_time) {
        this.register_time = register_time;
    }
}