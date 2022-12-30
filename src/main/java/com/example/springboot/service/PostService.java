package com.example.springboot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
	
	public Result<?> selectPage(Integer current, Integer size) {
		Page<Post> postPage = new Page<>(current, size);
		QueryWrapper<Post> wrapper = new QueryWrapper<>();
		wrapper.orderByDesc("post_time");
		Page<Post> page = postMapper.selectPage(postPage, wrapper);
		
		List<Post> records = page.getRecords();
		if(records.size() == 0)
			return Result.error("204", "No More Content");
		return Result.success(records);
	}
	public Result<?> selectPageByUserId(Integer userId, Integer current, Integer size) {
		Page<Post> queryPage = new Page<>(current, size);
		QueryWrapper<Post> wrapper = new QueryWrapper<>();
		wrapper.eq("user_id", userId).orderByDesc("post_time");
		Page<Post> page = postMapper.selectPage(queryPage, wrapper);
		
		List<Post> records = page.getRecords();
		if(records.size() == 0)
			return Result.error("204", "No More Content");
		return Result.success(records);
	}
	public Result<?> test() {
		return Result.success();
	}
}
