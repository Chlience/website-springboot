package com.example.springboot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.common.Result;
import com.example.springboot.entity.Role;
import com.example.springboot.entity.User;
import com.example.springboot.mapper.RoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleService {
    final static int PAGE_RECORDS_NUM = 10;
    
    @Resource
    private RoleMapper roleMapper;
    
    public Result<?> selectById(int id) {
        return Result.success(roleMapper.selectById(id));
    }
    
    public Result<?> deleteById(int id) {
        roleMapper.deleteById(id);
        return Result.success();
    }
    
    public Result<?> updateById(Role role) {
        roleMapper.updateById(role);
        return Result.success();
    }
    
    public Result<?> insert(Role role) {
        roleMapper.insert(role);
        return Result.success();
    }
    
    public Result<?> selectAll() {
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("id");
        return Result.success(roleMapper.selectList(wrapper));
    }
    
    public Result<?> selectAllInPage(int page) {
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("id");
        Page<Role> queryPage = new Page<>(page, PAGE_RECORDS_NUM);
        Page<Role> resultPage = roleMapper.selectPage(queryPage, wrapper);
        
        List<Role> records = resultPage.getRecords();
        if(records.size() == 0)
            return Result.error("204", "No More Content");
        return Result.success(records);
    }
}
