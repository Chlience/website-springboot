package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.entity.Like;
import com.example.springboot.service.LikeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/like")
public class LikeController {
	@Resource
	public LikeService likeService;
	
	@ApiOperation(value = "按 ID 返回点赞")
	@RequestMapping("/selectById")
	public Result<?> selectById(@RequestBody Integer id) {
		return likeService.selectById(id);
	}
	
	@ApiOperation(value = "按 ID 删除点赞")
	@RequestMapping("/deleteById")
	public Result<?> deleteById(@RequestBody Integer id){
		return likeService.deleteById(id);
	}
	
	@ApiOperation(value = "按 ID 更新点赞")
	@RequestMapping("/updateById")
	public Result<?> updateById(@RequestBody Like like){
		return likeService.updateById(like);
	}
	
	@ApiOperation(value = "返回所有点赞")
	@RequestMapping("/selectAll")
	public Result<?> selectAll() {
		return likeService.selectAll();
	}
	
	@ApiOperation(value = "分页返回所有点赞")
	@RequestMapping("/selectAllInPage")
	public Result<?> selectAllInPage(@RequestBody Integer page) {
		return likeService.selectAllInPage(page);
	}
	
	@ApiOperation(value = "按用户 ID 返回点赞")
	@RequestMapping("/selectByUserId")
	public Result<?> selectByUserId(@RequestBody Integer userId) {
		return likeService.selectByUserId(userId);
	}
	
	@ApiOperation(value = "分页按用户 ID 返回点赞")
	@RequestMapping("/selectByUserIdInPage")
	public Result<?> selectByUserIdInPage(@RequestBody Map<String, String> param) {
		Integer userId = Integer.valueOf(param.get("userId"));
		Integer page = Integer.valueOf(param.get("page"));
		return likeService.selectByUserIdInPage(userId, page);
	}
	
	@ApiOperation(value = "按博文 ID 返回点赞")
	@RequestMapping("/selectByPostId")
	public Result<?> selectByPostId(@RequestBody Integer postId) {
		return likeService.selectByPostId(postId);
	}
	
	@ApiOperation(value = "分页按博文 ID 返回点赞")
	@RequestMapping("/selectByPostIdInPage")
	public Result<?> selectByPostIdInPage(@RequestBody Map<String, String> param) {
		Integer postId = Integer.valueOf(param.get("postId"));
		Integer page = Integer.valueOf(param.get("page"));
		return likeService.selectByPostIdInPage(postId, page);
	}
}