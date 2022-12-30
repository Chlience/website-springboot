package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.entity.Post;
import com.example.springboot.service.PostService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/post")
public class PostController {
	@Resource
	private PostService postService;
	
	@ApiOperation(value = "返回所有博文")
	@RequestMapping("/selectAll")
	public Result<?> selectAll(){
		return postService.selectAll();
	}
	
	@ApiOperation(value = "按 ID 返回博文")
	@RequestMapping("/selectById")
	public Result<?> selectById(Integer id) {
		return postService.selectById(id);
	}
	
	@ApiOperation(value = "按 ID 删除博文")
	@RequestMapping("/deleteById")
	public Result<?> deleteById(Integer id){
		return postService.deleteById(id);
	}
	
	@ApiOperation(value = "按 ID 更新博文")
	@RequestMapping("/updateById")
	public Result<?> updateById(@RequestBody Post post) {
		return postService.updateById(post);
	}
	
	@ApiOperation(value = "插入博文")
	@RequestMapping("/insert")
	public Result<?> insert(@RequestBody Post post) {
		return postService.insert(post);
	}
	
	@ApiOperation(value = "分页返回所有博文")
	@RequestMapping("/selectAllInPage")
	public Result<?> selectAllInPage(@RequestBody Map<String,String> page) {
		int current = Integer.parseInt(page.get("current"));
		int size = Integer.parseInt(page.get("size"));
		return postService.selectAllInPage(current, size);
	}
	
	@ApiOperation(value = "分页按 ID 返回博文")
	@RequestMapping("/selectByUserIdInPage")
	public Result<?> selectByUserIdInPage(@RequestBody Map<String,String> page) {
		int userId = Integer.parseInt(page.get("userId"));
		int current = Integer.parseInt(page.get("current"));
		int size = Integer.parseInt(page.get("size"));
		return userId == -1 ? postService.selectAllInPage(current, size) :
				postService.selectByUserIdInPage(userId, current, size);
	}
	
	@ApiOperation(value = "测试")
	@RequestMapping("/test")
	public Result<?> test() {return postService.test();}
}
