package com.example.springboot.service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.common.Result;
import com.example.springboot.entity.User;
import com.example.springboot.mapper.RoleMapper;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.utils.Token;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
	final static int PAGE_RECORDS_NUM = 10;
	
	@Resource
	private UserMapper userMapper;
	@Resource
	private RoleMapper roleMapper;
	
	public Result<?> selectById(Integer id) {
		return Result.success(userMapper.selectById(id));
	}
	
	public Result<?> deleteById(Integer id) {
		userMapper.deleteById(id);
		return Result.success();
	}
	
	public Result<?> updateById(User user) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userMapper.updateById(user);
		return Result.success();
	}
	
	public Result<?> selectAll() {
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.orderByAsc("id");
		return Result.success(userMapper.selectList(wrapper));
	}
	
	public Result<?> selectAllInPage(Integer page) {
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.orderByAsc("id");
		Page<User> queryPage = new Page<>(page, PAGE_RECORDS_NUM);
		Page<User> resultPage = userMapper.selectPage(queryPage, wrapper);
		List<User> records = resultPage.getRecords();
		if(records.size() == 0)
			return Result.error("204", "No More Content");
		return Result.success(records);
	}
	
	public Result<?> selectByRole(Integer role) {
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.eq("role", role)
				.orderByAsc("id");
		return Result.success(userMapper.selectList(wrapper));
	}
	
	public Result<?> selectByRoleInPage(Integer role, Integer page) {
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.eq("role", role)
				.orderByAsc("id");
		Page<User> queryPage = new Page<>(page, PAGE_RECORDS_NUM);
		Page<User> resultPage = userMapper.selectPage(queryPage, wrapper);
		List<User> records = resultPage.getRecords();
		if(records.size() == 0)
			return Result.error("204", "No More Content");
		return Result.success(records);
	}
	
	public Result<?> login(User userParam) {
		// 只有登陆时需要 userName 和 password
		// 后面用来标记用户的有且仅有 id
		// 显示的是 nickName
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
		userQueryWrapper.eq("user_name", userParam.getUserName());
		User user = userMapper.selectOne(userQueryWrapper);
		if(user == null || userParam.getPassword() == null || !bCryptPasswordEncoder.matches(userParam.getPassword(), user.getPassword()))
			return Result.error("401", "用户名或密码错误");
		user.setToken(Token.getToken(user));
		user.setRoleName(roleMapper.selectById(user.getRole()).getRoleName());
		return Result.success(user);
	}
	
	public Result<?> register(User userParam) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.eq("user_name", userParam.getUserName());
		User res = userMapper.selectOne(wrapper);
		
		if (res != null) {
			return Result.error("401", "用户名已被使用");
		}
		
		User user = new User();
		user.setUserName(userParam.getUserName());
		user.setPassword(bCryptPasswordEncoder.encode(userParam.getPassword()));
		user.setNickName(userParam.getNickName());
		
		userMapper.insert(user);
		return Result.success();
	}
	
	public Result<?> updateRole(User userParam) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.eq("id", userParam.getUserName());
		User user = userMapper.selectOne(wrapper);
		if(user == null || userParam.getPassword() == null || !bCryptPasswordEncoder.matches(userParam.getPassword(), user.getPassword()))
			return Result.error("401", "用户名或密码错误");
		
		user.setRole(userParam.getRole());
		userMapper.updateById(user);
		return Result.success();
	}
	
	public Result<?> updateUserName(User userParam) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.eq("id", userParam.getUserName());
		User user = userMapper.selectOne(wrapper);
		if(user == null || userParam.getPassword() == null || !bCryptPasswordEncoder.matches(userParam.getPassword(), user.getPassword()))
			return Result.error("401", "用户名或密码错误");
		
		user.setUserName(userParam.getUserName());
		userMapper.updateById(user);
		return Result.success();
	}
	
	public Result<?> updatePassword(User userParam) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.eq("id", userParam.getId());
		User user = userMapper.selectOne(wrapper);
		if(user == null || userParam.getPassword() == null || !bCryptPasswordEncoder.matches(userParam.getPassword(), user.getPassword()))
			return Result.error("401", "用户名或密码错误");
		
		user.setPassword(userParam.getPassword());
		userMapper.updateById(user);
		return Result.success();
	}
	
	public Result<?> updateNickName(User userParam) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.eq("id", userParam.getId());
		User user = userMapper.selectOne(wrapper);
		if(user == null || userParam.getPassword() == null || !bCryptPasswordEncoder.matches(userParam.getPassword(), user.getPassword()))
			return Result.error("401", "用户名或密码错误");
		
		user.setNickName(userParam.getNickName());
		userMapper.updateById(user);
		return Result.success();
	}
	
	public Result<?> updateIntroduction(User userParam) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.eq("id", userParam.getId());
		User user = userMapper.selectOne(wrapper);
		if(user == null || userParam.getPassword() == null || !bCryptPasswordEncoder.matches(userParam.getPassword(), user.getPassword()))
			return Result.error("401", "用户名或密码错误");
		
		user.setIntroduction(userParam.getIntroduction());
		userMapper.updateById(user);
		return Result.success();
	}
}