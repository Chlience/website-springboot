package com.example.springboot.controller;
import com.example.springboot.common.Result;
import com.example.springboot.entity.Notice;
import com.example.springboot.service.NoticeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Map;

public class NoticeController {
	@Resource
	private NoticeService noticeService;
	
	@ApiOperation(value = "按 ID 返回通知")
	@RequestMapping("/selectById")
	public Result<?> selectById(@RequestBody Integer id) {
		return noticeService.selectById(id);
	}
	
	@ApiOperation(value = "按 ID 删除通知")
	@RequestMapping("/deleteById")
	public Result<?> deleteById(@RequestBody Integer id){
		return noticeService.deleteById(id);
	}
	
	@ApiOperation(value = "按 ID 更新通知")
	@RequestMapping("/updateById")
	public Result<?> updateById(@RequestBody Notice notice){
		return noticeService.updateById(notice);
	}
	
	@ApiOperation(value = "按 ID 显示状态设为未读")
	@RequestMapping("/setReadStatusUnreadById")
	public Result<?> setReadStatusUnreadById(@RequestBody Integer id) {
		return noticeService.setReadStatusById(id, false);
	}
	
	@ApiOperation(value = "按 ID 显示状态设为已读")
	@RequestMapping("/setReadStatusReadById")
	public Result<?> setReadStatusReadById(@RequestBody Integer id) {
		return noticeService.setReadStatusById(id, true);
	}
	
	@ApiOperation(value = "按用户 ID 显示状态设为未读")
	@RequestMapping("/setReadStatusUnReadByUserId")
	public Result<?> setReadStatusUnReadByUserId(@RequestBody Integer userId) {
		return noticeService.setReadStatusByUserId(userId, false);
	}
	
	@ApiOperation(value = "按用户 ID 显示状态设为已读")
	@RequestMapping("/setReadStatusReadByUserId")
	public Result<?> setReadStatusReadByUserId(@RequestBody Integer userId) {
		return noticeService.setReadStatusByUserId(userId, true);
	}
	
	@ApiOperation(value = "返回所有通知")
	@RequestMapping("/selectAll")
	public Result<?> selectAll() {
		return noticeService.selectAll();
	}
	
	@ApiOperation(value = "分页返回所有通知")
	@RequestMapping("/selectAllInPage")
	public Result<?> selectAllInPage(@RequestBody Integer page) {
		return noticeService.selectAllInPage(page);
	}
	
	@ApiOperation(value = "按用户 ID 返回所有通知")
	@RequestMapping("/selectByUserId")
	public Result<?> selectByUserId(@RequestBody Integer userId) {
		return noticeService.selectByUserId(userId);
	}
	
	@ApiOperation(value = "分页返回所有通知")
	@RequestMapping("/selectByUserIdInPage")
	public Result<?> selectByUserIdInPage(@RequestBody Map<String, String> param) {
		Integer userId = Integer.valueOf(param.get("userId"));
		Integer page = Integer.valueOf(param.get("page"));
		return noticeService.selectByUserIdInPage(userId, page);
	}
}
