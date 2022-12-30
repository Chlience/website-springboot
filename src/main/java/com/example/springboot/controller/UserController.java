package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.entity.User;
import com.example.springboot.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

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
	
	@PostMapping("/updateRole")
	public Result<?> updateRole(@RequestBody User user) {
		return userService.updateRole(user);
	}
	
	@PostMapping("/updateUserName")
	public Result<?> updateUserName(@RequestBody User user) {
		return userService.updateUserName(user);
	}
	
	@PostMapping("/updatePassword")
	public Result<?> updatePassword(@RequestBody User user) {
		return userService.updatePassword(user);
	}
	
	@PostMapping("/updateNickName")
	public Result<?> updateNickName(@RequestBody User user) {
		return userService.updateNickName(user);
	}
	
	@PostMapping("/updateIntroduction")
	public Result<?> updateIntroduction(@RequestBody User user) {
		return userService.updateIntroduction(user);
	}
	
	@RequestMapping("/selectPage")
	public Result<?> getByPage(@RequestBody Map<String,String> page) {
		int current = Integer.parseInt(page.get("current"));
		int size = Integer.parseInt(page.get("size"));
		return userService.selectPage(current, size);
	}
}
