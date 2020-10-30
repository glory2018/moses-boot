/*
 * Copyright © 2020 bjfansr@cn.ibm.com Inc. All rights reserved
 * @description: com.moses.framework.samples.exam.Test
 * @version V1.0
 */
package com.moses.framework.exam.sort;

import com.moses.framework.exam.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Moses
 * @date 2020/4/3
 */
public class TestSort {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        List<User> list = new ArrayList<>();
        list.add(new User("aa", df.parse("2015-01-01")));
        list.add(new User("dd", df.parse("2019-01-01")));
        list.add(new User("cc", df.parse("2018-01-01")));
        list.add(new User("bb", df.parse("2017-01-01")));
        list.add(new User("zz", df.parse("2016-01-01")));
        list.add(new User("xx", df.parse("2015-02-01")));
        list.add(new User("yy", df.parse("2015-03-01")));
        list.add(new User("uu", df.parse("2015-04-01")));
        list.sort((User u1, User u2) -> u1.getUsername().compareTo(u2.getUsername()));
        System.out.println("------------按名称排序------------");
        for (User u : list) {
            System.out.println("username=" + u.getUsername() + ";register_time=" + df.format(u.getRegister_time()));
        }
        System.out.println("------------按时间排序------------");
        list.sort((User u1, User u2) -> u1.getRegister_time().compareTo(u2.getRegister_time()));
        for (User u : list) {
            System.out.println("username=" + u.getUsername() + ";register_time=" + df.format(u.getRegister_time()));
        }
    }
}