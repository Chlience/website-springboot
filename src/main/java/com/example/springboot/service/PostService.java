package com.example.springboot.service;


import com.baomidou.mybatisplus.annotation.OrderBy;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springboot.common.Result;
import com.example.springboot.entity.Post;
import com.example.springboot.mapper.PostMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PostService {
    @Resource
    private PostMapper postMapper;

    public Result<?> getAll() {
        return Result.success(postMapper.selectList(null));
    }

    public Result<?> getAllOrderByTime() {
        QueryWrapper<Post> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("post_time");
        return Result.success(postMapper.selectList(wrapper));
    }

    public Result<?> selectById(Integer id) {
        return Result.success(postMapper.selectById(id));
    }

    public Result<?> deleteById(Integer id) {
        postMapper.deleteById(id);
        return Result.success();
    }

    public Result<?> updateById(Post post) {
        postMapper.updateById(post);
        return Result.success();
    }

    public Result<?> insert(Post post) {
        postMapper.insert(post);
        return Result.success();
    }
}
