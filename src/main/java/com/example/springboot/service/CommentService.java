package com.example.springboot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.common.Result;
import com.example.springboot.entity.Post;
import com.example.springboot.entity.Comment;
import com.example.springboot.entity.User;
import com.example.springboot.mapper.CommentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentService {
	@Resource
	private CommentMapper commentMapper;
	
	public Result<?> selectById(Integer id) {
		QueryWrapper<Post> wrapper = new QueryWrapper<>();
		wrapper.eq("id", id);
		return Result.success(commentMapper.selectById(id));
	}
	
	public Result<?> deleteById(Integer id) {
		commentMapper.deleteById(id);
		return Result.success();
	}
	
	public Result<?> updateById(Comment comment) {
		commentMapper.updateById(comment);
		return Result.success();
	}
	
	public Result<?> selectAll() {
		QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
		queryWrapper.orderByDesc("post_time");
		return Result.success(commentMapper.selectList(queryWrapper));
	}
	
	public Result<?> selectAllInPage(Integer current, Integer size) {
		Page<Comment> queryPage = new Page<>(current, size);
		QueryWrapper<Comment> wrapper = new QueryWrapper<>();
		wrapper.orderByAsc("id");
		Page<Comment> page = commentMapper.selectPage(queryPage, wrapper);
		List<Comment> records = page.getRecords();
		if(records.size() == 0)
			return Result.error("204", "No More Content");
		return Result.success(records);
	}
	
	public Result<?> selectByPostId(Integer id) {
		QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("post_id", id).orderByDesc("post_time");
		return Result.success(commentMapper.selectList(queryWrapper));
	}
	
	public Result<?> selectByPostIdInPage(Integer id, Integer current, Integer size) {
		Page<Comment> queryPage = new Page<>(current, size);
		QueryWrapper<Comment> wrapper = new QueryWrapper<>();
		wrapper.eq("post_id", id).orderByDesc("post_time");
		Page<Comment> page = commentMapper.selectPage(queryPage, wrapper);
		List<Comment> records = page.getRecords();
		if(records.size() == 0)
			return Result.error("204", "No More Content");
		return Result.success(records);
	}
}
