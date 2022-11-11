package com.example.springboot.service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springboot.common.Result;
import com.example.springboot.entity.User;
import com.example.springboot.mapper.RoleMapper;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.utils.Token;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleMapper roleMapper;
    
    public Result<?> getAll() {
        //不需要where条件,查询是全部数据.
        return Result.success(userMapper.selectList(null));
    }
    
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
    
    public Result<?> login(User userParam) {
        // 只有登陆时需要 userName 和 password
        // 后面用来标记用户的有且仅有 id
        // 显示的是 nickName
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("user_name", userParam.getUserName());
        User user = userMapper.selectOne(userQueryWrapper);
        if(user == null || !bCryptPasswordEncoder.matches(userParam.getPassword(), user.getPassword()))
            return Result.error("-1", "用户名或密码错误");
        user.setToken(Token.getToken(user));
        user.setRoleName(roleMapper.selectById(user.getRoleId()).getRoleName());
        return Result.success(user);
    }
    
    public Result<?> register(User userParam) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userParam.getUserName());
        User res = userMapper.selectOne(queryWrapper);
        
        if (res != null) {
            return Result.error("-1", "用户名已被使用");
        }
        
        User user = new User();
        user.setUserName(userParam.getUserName());
        user.setPassword(bCryptPasswordEncoder.encode(userParam.getPassword()));
        user.setNickName(userParam.getNickName());
    
        userMapper.insert(user);
        return Result.success();
    }
}