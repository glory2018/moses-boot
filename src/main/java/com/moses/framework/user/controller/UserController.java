/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.moses.framework.user.controller;

import com.moses.framework.user.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Joe Grandja
 */
@Controller
public class UserController {
    @GetMapping("/admin")
    public String admin() {
        return "/user/admin";
    }

    @GetMapping("/user")
    public String user() {
        return "/user/user";
    }

    @GetMapping("/toRegister")
    public String toRegister() {
        return "/user/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        return "/login";
    }
}
