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
	public Result<?> selectAll() {
		return postService.selectAll();
	}
	
	@ApiOperation(value = "分页返回所有博文")
	@RequestMapping("/selectAllInPage")
	public Result<?> selectAllInPage(@RequestBody Integer page) {
		return postService.selectAllInPage(page);
	}
	
	@ApiOperation(value = "按 ID 返回博文")
	@RequestMapping("/selectById")
	public Result<?> selectById(@RequestBody Integer id) {
		return postService.selectById(id);
	}
	
	@ApiOperation(value = "按 ID 删除博文")
	@RequestMapping("/deleteById")
	public Result<?> deleteById(@RequestBody Integer id) {
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
	
	@ApiOperation(value = "按 ID 取消加精博文")
	@RequestMapping("/setStarStatusFalseById")
	public Result<?> setStarStatusFalseById(@RequestBody Integer id) {
		return postService.setStarStatusById(id, false);
	}
	
	@ApiOperation(value = "按 ID 加精博文")
	@RequestMapping("/setStarStatusTrueById")
	public Result<?> setStarStatusTrueById(@RequestBody Integer id) {
		return postService.setStarStatusById(id, true);
	}
	
	@ApiOperation(value = "按 ID 取消隐藏博文")
	@RequestMapping("/setHideStatusFalseById")
	public Result<?> setHideStatusFalseById(@RequestBody Integer id) {
		return postService.setHideStatusById(id, false);
	}
	
	@ApiOperation(value = "按 ID 隐藏博文")
	@RequestMapping("/setHideStatusTrueById")
	public Result<?> setHideStatusTrueById(@RequestBody Integer id) {
		return postService.setHideStatusById(id, true);
	}
	
	@ApiOperation(value = "按 ID 设置博文待审核")
	@RequestMapping("/setReviewStatusWaitById")
	public Result<?> setReviewStatusWaitById(@RequestBody Integer id) {
		return postService.setReviewStatusById(id, 0);
	}

	@ApiOperation(value = "按 ID 设置博文审核通过")
	@RequestMapping("/setReviewStatusPassById")
	public Result<?> setReviewStatusPassById(@RequestBody Integer id) {
		return postService.setReviewStatusById(id, 1);
	}

	@ApiOperation(value = "按 ID 设置博文审核未通过")
	@RequestMapping("/setReviewStatusFailById")
	public Result<?> setReviewStatusFailById(@RequestBody Integer id) {
		return postService.setReviewStatusById(id, 2);
	}
	
	@ApiOperation(value = "按 User ID 返回博文")
	@RequestMapping("/selectByUserId")
	public Result<?> selectByUserId(@RequestBody Integer userId) {
		return postService.selectByUserId(userId);
	}
	
	@ApiOperation(value = "分页按 User ID 返回博文")
	@RequestMapping("/selectByUserIdInPage")
	public Result<?> selectByUserIdInPage(@RequestBody Map<String,String> param) {
		int userId = Integer.parseInt(param.get("userId"));
		int page = Integer.parseInt(param.get("page"));
		return userId == -1 ? postService.selectAllInPage(page) :
				postService.selectByUserIdInPage(userId, page);
	}
	
	@ApiOperation(value = "测试")
	@RequestMapping("/test")
	public Result<?> test() {return postService.test();}
}
