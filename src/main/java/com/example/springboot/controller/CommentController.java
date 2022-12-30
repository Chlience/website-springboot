package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.entity.Comment;
import com.example.springboot.service.CommentService;
import io.swagger.annotations.ApiOperation;
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
	
	@ApiOperation(value = "按 ID 返回评论")
	@RequestMapping("/selectById")
	public Result<?> selectById(@RequestBody Integer id) {
		return commentService.selectById(id);
	}
	
	@ApiOperation(value = "按 ID 删除评论")
	@RequestMapping("/deleteById")
	public Result<?> deleteById(@RequestBody Integer id){
		return commentService.deleteById(id);
	}
	
	@ApiOperation(value = "按 ID 更新评论")
	@RequestMapping("/updateById")
	public Result<?> updateById(@RequestBody Comment comment){
		return commentService.updateById(comment);
	}
	
	@ApiOperation(value = "返回所有评论")
	@RequestMapping("/selectAll")
	public Result<?> selectAll() {
		return commentService.selectAll();
	}
	
	@ApiOperation(value = "分页返回所有评论")
	@RequestMapping("/selectAllInPage")
	public Result<?> selectAllInPage(@RequestBody Map<String,String> page) {
		int current = Integer.parseInt(page.get("current"));
		int size = Integer.parseInt(page.get("size"));
		return commentService.selectAllInPage(current, size);
	}
	
	@ApiOperation(value = "按博文 ID 返回评论")
	@RequestMapping("/selectByPostId")
	public Result<?> selectByPostId(@RequestBody Integer id) {
		return commentService.selectByPostId(id);
	}
	
	@ApiOperation(value = "分页按博文 ID 返回评论")
	@RequestMapping("/selectByPostIdInPage")
	public Result<?> selectByPostIdInPage(@RequestBody Map<String,String> page){
		int postId = Integer.parseInt(page.get("postId"));
		int current = Integer.parseInt(page.get("current"));
		int size = Integer.parseInt(page.get("size"));
		return commentService.selectByPostIdInPage(postId, current, size);
	}
}
