package com.example.springboot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.common.Result;
import com.example.springboot.entity.Post;
import com.example.springboot.mapper.PostMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

@Service
public class PostService {
	final static int PAGE_RECORDS_NUM = 10;
	@Resource
	private PostMapper postMapper;
	
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
		post.setTopStatus(false);
		post.setStarStatus(false);
		postMapper.insert(post);
		return Result.success();
	}
	
	public Result<?> setStarStatusById(Integer id, Boolean starStatus) {
		Post post = postMapper.selectById(id);
		post.setStarStatus(starStatus);
		postMapper.updateById(post);
		return Result.success();
	}
	
	public Result<?> setTopStatusById(Integer id, Boolean topStatus) {
		Post post = postMapper.selectById(id);
		post.setTopStatus(topStatus);
		post.setTopTime(new Timestamp(new Date().getTime()));
		postMapper.updateById(post);
		return Result.success();
	}
	
	public Result<?> setHideStatusById(Integer id, Boolean hideStatus) {
		Post post = postMapper.selectById(id);
		post.setHideStatus(hideStatus);
		postMapper.updateById(post);
		return Result.success();
	}
	
	public Result<?> setReviewStatusById(Integer id, Integer reviewStatus) {
		Post post = postMapper.selectById(id);
		post.setReviewStatus(reviewStatus);
		return Result.success();
	}
	
	public Result<?> selectAll() {
		QueryWrapper<Post> wrapper = new QueryWrapper<>();
		wrapper.orderByDesc("top")
				.orderByDesc("top_time");
		return Result.success(postMapper.selectList(wrapper));
	}
	
	public Result<?> selectAllInPage(Integer page) {
		QueryWrapper<Post> wrapper = new QueryWrapper<>();
		wrapper.eq("hide_status", false)
				.eq("review_status", 1)
				.orderByDesc("top")
				.orderByDesc("top_time");
		Page<Post> queryPage = new Page<>(page, PAGE_RECORDS_NUM);
		Page<Post> resultPage = postMapper.selectPage(queryPage, wrapper);
		
		List<Post> records = resultPage.getRecords();
		if(records.size() == 0)
			return Result.error("204", "No More Content");
		return Result.success(records);
	}
	
	public Result<?> selectByUserId(Integer userId) {
		QueryWrapper<Post> wrapper = new QueryWrapper<>();
		wrapper.eq("user_id", userId)
				.orderByDesc("post_time");
		return Result.success(postMapper.selectList(wrapper));
	}
	
	public Result<?> selectByUserIdInPage(Integer userId, Integer page) {
		QueryWrapper<Post> wrapper = new QueryWrapper<>();
		wrapper.eq("user_id", userId)
				.orderByDesc("post_time");
		Page<Post> queryPage = new Page<>(page, PAGE_RECORDS_NUM);
		Page<Post> resultPage = postMapper.selectPage(queryPage, wrapper);
		
		List<Post> records = resultPage.getRecords();
		if(records.size() == 0)
			return Result.error("204", "No More Content");
		return Result.success(records);
	}
	
	public Result<?> test() {
		Post post = new Post();
		post.setUserId(1);
		post.setStarStatus(false);
		post.setTopStatus(false);
		post.setContent("timezone test");
		postMapper.insert(post);
		return Result.success();
	}
}
