package com.feiniaojin.dddexample.cms.ui.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    public Map<String, Object> login() {
        Map<String, Object> result = new HashMap<>();
        result.put("token", UUID.randomUUID().toString());
        result.put("roles", Collections.singletonList("admin"));
        return result;
    }

    @RequestMapping("/info")
    public Map<String, Object> info() {
        Map<String, Object> data = new HashMap<>();
        data.put("roles", Collections.singletonList("admin"));
        data.put("introduction", "I am a super administrator");
        data.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        data.put("name", "Super Admin");
        return data;
    }
}
