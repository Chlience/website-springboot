package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.entity.User;
import com.example.springboot.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	
	@ApiOperation(value = "返回所有用户")
	@RequestMapping("/selectAll")
	public Result<?> selectAll(){
		return userService.selectAll();
	}
	
	@ApiOperation(value = "分页返回全部用户")
	@RequestMapping("/selectAllInPage")
	public Result<?> selectAllInPage(@RequestBody Map<String,String> param) {
		int current = Integer.parseInt(param.get("current"));
		int size = Integer.parseInt(param.get("size"));
		return userService.selectAllInPage(current, size);
	}
	
	@ApiOperation(value = "按 ID 返回用户")
	@RequestMapping("/selectById")
	public Result<?> selectById(@RequestBody int id) {
		return userService.selectById(id);
	}
	
	@ApiOperation(value = "按 ID 删除")
	@RequestMapping("/deleteById")
	public Result<?> deleteById(@RequestBody int id){
		return userService.deleteById(id);
	}
	
	@ApiOperation(value = "按 ID 更新")
	@RequestMapping("/updateById")
	public Result<?> updateById(@RequestBody User user){
		return userService.updateById(user);
	}
	
	@ApiOperation(value = "返回某权限全部用户")
	@RequestMapping("/selectByRole")
	public Result<?> selectPageByRole(@RequestBody int role) {
		return userService.selectByRole(role);
	}
	
	@ApiOperation(value = "分页返回某权限全部用户")
	@RequestMapping("/selectByRoleInPage")
	public Result<?> selectByRoleInPage(@RequestBody Map<String,String> param) {
		int role = Integer.parseInt(param.get("role"));
		int current = Integer.parseInt(param.get("current"));
		int size = Integer.parseInt(param.get("size"));
		return userService.selectByRoleInPage(role, current, size);
	}
	
	@ApiOperation(value = "用户登录")
	@PostMapping("/login")
	public Result<?> login(@RequestBody User userParam) {
		return userService.login(userParam);
	}
	
	@ApiOperation(value = "用户注册")
	@PostMapping("/register")
	public Result<?> register(@RequestBody User user) {
		return userService.register(user);
	}
	
	@ApiOperation(value = "更新用户权限")
	@PostMapping("/updateRole")
	public Result<?> updateRole(@RequestBody User user) {
		return userService.updateRole(user);
	}
	
	@ApiOperation(value = "更新用户名")
	@PostMapping("/updateUserName")
	public Result<?> updateUserName(@RequestBody User user) {
		return userService.updateUserName(user);
	}
	
	@ApiOperation(value = "更新用户密码")
	@PostMapping("/updatePassword")
	public Result<?> updatePassword(@RequestBody User user) {
		return userService.updatePassword(user);
	}
	
	@ApiOperation(value = "更新用户昵称")
	@PostMapping("/updateNickName")
	public Result<?> updateNickName(@RequestBody User user) {
		return userService.updateNickName(user);
	}
	
	@ApiOperation(value = "更新用户介绍")
	@PostMapping("/updateIntroduction")
	public Result<?> updateIntroduction(@RequestBody User user) {
		return userService.updateIntroduction(user);
	}
}
