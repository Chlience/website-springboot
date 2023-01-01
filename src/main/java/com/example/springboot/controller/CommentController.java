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
	
	@ApiOperation(value = "返回所有评论")
	@RequestMapping("/selectAll")
	public Result<?> selectAll() {
		return commentService.selectAll();
	}
	
	@ApiOperation(value = "分页返回所有评论")
	@RequestMapping("/selectAllInPage")
	public Result<?> selectAllInPage(@RequestBody int page) {
		return commentService.selectAllInPage(page);
	}
	
	@ApiOperation(value = "按 ID 返回评论")
	@RequestMapping("/selectById")
	public Result<?> selectById(@RequestBody int id) {
		return commentService.selectById(id);
	}
	
	@ApiOperation(value = "按 ID 删除评论")
	@RequestMapping("/deleteById")
	public Result<?> deleteById(@RequestBody int id){
		return commentService.deleteById(id);
	}
	
	@ApiOperation(value = "按 ID 更新评论")
	@RequestMapping("/updateById")
	public Result<?> updateById(@RequestBody Comment comment){
		return commentService.updateById(comment);
	}
	
	@ApiOperation(value = "按博文 ID 返回评论")
	@RequestMapping("/selectByPostId")
	public Result<?> selectByPostId(@RequestBody int id) {
		return commentService.selectByPostId(id);
	}
	
	@ApiOperation(value = "分页按博文 ID 返回评论")
	@RequestMapping("/selectByPostIdInPage")
	public Result<?> selectByPostIdInPage(@RequestBody Map<String,String> param){
		int postId = Integer.parseInt(param.get("postId"));
		int page = Integer.parseInt(param.get("page"));
		return commentService.selectByPostIdInPage(postId, page);
	}
}
