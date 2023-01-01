package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.entity.Role;
import com.example.springboot.service.RoleService;
import com.example.springboot.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/role")
public class RoleController {
	@Resource
	private RoleService roleService;
	
	@Resource
	private UserService userService;
	
	@ApiOperation(value = "返回所有特权组")
	@RequestMapping("/selectAll")
	public Result<?> selectAll(){
		return roleService.selectAll();
	}
	
	@ApiOperation(value = "分页返回所有特权组")
	@RequestMapping("/selectAllInPage")
	public Result<?> selectAllInPage(@RequestBody int page) {
		return roleService.selectAllInPage(page);
	}
	
	@ApiOperation(value = "按 ID 返回特权组")
	@RequestMapping("/selectById")
	public Result<?> selectById(@RequestBody int id) {
		return roleService.selectById(id);
	}
	
	@ApiOperation(value = "按 ID 删除特权组")
	@RequestMapping("/deleteById")
	public Result<?> deleteById(@RequestBody int id){
		return roleService.deleteById(id);
	}
	
	@ApiOperation(value = "按 ID 更新特权组")
	@RequestMapping("/updateById")
	public Result<?> updateById(@RequestBody Role role) {
		return roleService.updateById(role);
	}
	
	@ApiOperation(value = "插入特权组")
	@RequestMapping("/insert")
	public Result<?> insert(@RequestBody Role role) {
		return roleService.insert(role);
	}
	
	@ApiOperation(value = "返回特权组全部用户")
	@RequestMapping("/selectByRole")
	public Result<?> selectPageByRole(@RequestBody int role) {
		return userService.selectByRole(role);
	}
	
	@ApiOperation(value = "分页返回特权组全部用户")
	@RequestMapping("/selectByRoleInPage")
	public Result<?> selectByRoleInPage(@RequestBody Map<String,String> param) {
		int role = Integer.parseInt(param.get("role"));
		int page = Integer.parseInt(param.get("page"));
		return userService.selectByRoleInPage(role, page);
	}
}
