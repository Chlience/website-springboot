package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.entity.Post;
import com.example.springboot.service.PostService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/post")
public class PostController {
	@Resource
	private PostService postService;
	
	@RequestMapping("/getAll")
	public Result<?> getAll(){
		return postService.getAll();
	}
	
	@RequestMapping("/selectById")
	public Result<?> selectById(Integer id) {
		return postService.selectById(id);
	}
	
	@RequestMapping("/deleteById")
	public Result<?> deleteById(Integer id){
		return postService.deleteById(id);
	}
	
	@RequestMapping("/updateById")
	public Result<?> updateById(@RequestBody Post post) {
		return postService.updateById(post);
	}
	
	@RequestMapping("/insert")
	public Result<?> insert(@RequestBody Post post) {
		return postService.insert(post);
	}
	
	@RequestMapping("/selectPage")
	public Result<?> getByPage(@RequestBody Map<String,String> page) {
		int current = Integer.parseInt(page.get("current"));
		int size = Integer.parseInt(page.get("size"));
		return postService.selectPage(current, size);
	}
	
	@RequestMapping("/selectPageByUserId")
	public Result<?> selectPageByUserId(@RequestBody Map<String,String> page) {
		int userId = Integer.parseInt(page.get("userId"));
		int current = Integer.parseInt(page.get("current"));
		int size = Integer.parseInt(page.get("size"));
		return userId == -1 ? postService.selectPage(current, size) :
				postService.selectPageByUserId(userId, current, size);
	}
	
	@RequestMapping("/test")
	public Result<?> test() {return postService.test();}
}
