package com.zj.web.server.controller;

import com.zj.test.util.TestHelper;
import com.zj.util.commons.StringUtil;
import com.zj.web.server.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Random;

/**
 * @author: zhou jian
 * @qq: 2025513
 * @description:
 * @version: 1.0
 * @create-time: 2021/4/23 19:51
 * @finished: false
 * @finished-time:
 */
@Controller
public class RequestController {


    @GetMapping("/getdata")
    @ResponseBody
    public User getWithData(HttpServletRequest request) {
        User user = new User();
        user.setUsername(StringUtil.random32());
        user.setPassword(StringUtil.random32());
        user.setAge(1 + new Random().nextInt(100));
        printHeaders(request);
        return user;
    }

    @GetMapping("/get")
    public String get(HttpServletRequest request) {
        User user = new User();
        user.setUsername(StringUtil.random32());
        user.setPassword(StringUtil.random32());
        user.setAge(1 + new Random().nextInt(100));
        printHeaders(request);
        return "/index.html";
    }

    @GetMapping("/postdata")
    @ResponseBody
    public User postWithData(HttpServletRequest request) {
        User user = new User();
        user.setUsername(StringUtil.random32());
        user.setPassword(StringUtil.random32());
        user.setAge(1 + new Random().nextInt(100));
        printHeaders(request);
        return user;
    }

    @GetMapping("/post")
    public String post(HttpServletRequest request) {
        User user = new User();
        user.setUsername(StringUtil.random32());
        user.setPassword(StringUtil.random32());
        user.setAge(1 + new Random().nextInt(100));
        printHeaders(request);
        return "/index.html";
    }

    private void printHeaders(HttpServletRequest request) {
        TestHelper.println("客户端传递的所有header:");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            TestHelper.println(name, request.getHeader(name));
        }
    }
}
