package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.entity.User;
import com.example.springboot.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/getAll")
    public Result<?> getAll(){
        return userService.getAll();
    }

    @RequestMapping("/selectById")
    public Result<?> selectById(@RequestBody Integer id) {
        return userService.selectById(id);
    }

    @RequestMapping("/deleteById")
    public Result<?> deleteById(@RequestBody Integer id){
        return userService.deleteById(id);
    }

    @RequestMapping("/updateById")
    public Result<?> update(@RequestBody User user){
        return userService.updateById(user);
    }

    @PostMapping("/login")
    public Result<?> login(@RequestBody User userParam) {
        return userService.login(userParam);
    }

    @PostMapping("/register")
    public Result<?> register(@RequestBody User user) {
        return userService.register(user);
    }
}
