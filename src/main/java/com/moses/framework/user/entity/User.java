/*********************************************
 *
 * Copyright (C) 2018 IBM All rights reserved.
 *
 ********* K*I*N*G ********** B*A*C*K *******/
package com.moses.framework.user.entity;

import lombok.Data;

/**
 * @author Moses *
 * @Date 2019/1/21 15:35
 */
@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    private Boolean remember;
}
