package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.entity.Comment;
import com.example.springboot.service.CommentService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/comment")
public class CommentController {
	@Resource
	private CommentService commentService;
	
	@RequestMapping("/selectById")
	public Result<?> selectById(@RequestBody Integer id) {
		return commentService.selectById(id);
	}
	
	@RequestMapping("/deleteById")
	public Result<?> deleteById(@RequestBody Integer id){
		return commentService.deleteById(id);
	}
	
	@RequestMapping("/updateById")
	public Result<?> updateById(@RequestBody Comment comment){
		return commentService.updateById(comment);
	}
	
	@RequestMapping("/selectByPostId")
	public Result<?> selectByPostId(@RequestBody Integer id) {
		return commentService.selectByPostId(id);
	}
	
	@RequestMapping("/selectPage")
	public Result<?> getByPage(@RequestBody Map<String,String> page) {
		int current = Integer.parseInt(page.get("current"));
		int size = Integer.parseInt(page.get("size"));
		return commentService.selectPage(current, size);
	}
	
	@RequestMapping("/selectPageByPostId")
	public Result<?> selectPageByPostId(@RequestBody Map<String,String> page){
		int postId = Integer.parseInt(page.get("postId"));
		int current = Integer.parseInt(page.get("current"));
		int size = Integer.parseInt(page.get("size"));
		return commentService.selectPageByPostId(postId, current, size);
	}
}
