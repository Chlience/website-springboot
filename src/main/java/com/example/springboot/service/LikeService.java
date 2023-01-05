package com.example.springboot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.common.Result;
import com.example.springboot.entity.Like;
import com.example.springboot.entity.Post;
import com.example.springboot.mapper.LikeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LikeService {
	final static int PAGE_RECORDS_NUM = 10;
	@Resource
	private LikeMapper likeMapper;
	
	public Result<?> selectById(Integer id) {
		QueryWrapper<Post> wrapper = new QueryWrapper<>();
		wrapper.eq("id", id);
		return Result.success(likeMapper.selectById(id));
	}
	
	public Result<?> deleteById(Integer id) {
		likeMapper.deleteById(id);
		return Result.success();
	}
	
	public Result<?> updateById(Like like) {
		likeMapper.updateById(like);
		return Result.success();
	}
	
	public Result<?> selectAll() {
		QueryWrapper<Like> queryWrapper = new QueryWrapper<>();
		queryWrapper.orderByDesc("create_time");
		return Result.success(likeMapper.selectList(queryWrapper));
	}
	
	public Result<?> selectAllInPage(Integer page) {
		QueryWrapper<Like> wrapper = new QueryWrapper<>();
		wrapper.orderByDesc("create_time");
		Page<Like> queryPage = new Page<>(page, PAGE_RECORDS_NUM);
		Page<Like> resultPage = likeMapper.selectPage(queryPage, wrapper);
		List<Like> records = resultPage.getRecords();
		if(records.size() == 0)
			return Result.error("204", "No More Content");
		return Result.success(records);
	}
	
	public Result<?> selectByUserId(Integer userId) {
		QueryWrapper<Like> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("user_id", userId)
				.orderByDesc("create_time");
		return Result.success(likeMapper.selectList(queryWrapper));
	}
	
	public Result<?> selectByUserIdInPage(Integer userId, Integer page) {
		QueryWrapper<Like> wrapper = new QueryWrapper<>();
		wrapper.eq("user_id", userId)
				.orderByDesc("create_time");
		Page<Like> queryPage = new Page<>(page, PAGE_RECORDS_NUM);
		Page<Like> resultPage = likeMapper.selectPage(queryPage, wrapper);
		List<Like> records = resultPage.getRecords();
		if(records.size() == 0)
			return Result.error("204", "No More Content");
		return Result.success(records);
	}
	
	public Result<?> selectByPostId(Integer postId) {
		QueryWrapper<Like> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("post_id", postId)
				.orderByDesc("create_time");
		return Result.success(likeMapper.selectList(queryWrapper));
	}
	
	public Result<?> selectByPostIdInPage(Integer postId, Integer page) {
		QueryWrapper<Like> wrapper = new QueryWrapper<>();
		wrapper.eq("post_id", postId)
				.orderByDesc("create_time");
		Page<Like> queryPage = new Page<>(page, PAGE_RECORDS_NUM);
		Page<Like> resultPage = likeMapper.selectPage(queryPage, wrapper);
		List<Like> records = resultPage.getRecords();
		if(records.size() == 0)
			return Result.error("204", "No More Content");
		return Result.success(records);
	}
}
