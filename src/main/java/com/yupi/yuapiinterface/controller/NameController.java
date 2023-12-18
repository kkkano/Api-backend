package com.yupi.yuapiinterface.controller;

import com.yupi.yuapiinterface.model.User;
import org.springframework.web.bind.annotation.*;

/**
 * 名称 API
 *
 * @author yupi
 */
@RestController
@RequestMapping("name")
public class NameController {
    @GetMapping("/")
    public String getNameByGet(String name) {
        return "GET 你的名字是" + name;
    }

    @PostMapping("/2")
    public String getNameByPost(@RequestParam String name) {
        return "POST 你的名字是" + name;
    }

    @PostMapping("/1")
    public String getUserNameByPost(@RequestBody User user) {
        return "POST 用户名字是" + user.getUsername();
    }
}