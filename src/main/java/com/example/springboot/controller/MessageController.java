package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.entity.Message;
import com.example.springboot.service.MessageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/message")
public class MessageController {
	@Resource
	private MessageService messageService;
	
	@ApiOperation(value = "返回所有评论")
	@RequestMapping("/selectAll")
	public Result<?> selectAll() {
		return messageService.selectAll();
	}
	
	@ApiOperation(value = "分页返回所有评论")
	@RequestMapping("/selectAllInPage")
	public Result<?> selectAllInPage(@RequestBody Integer page) {
		return messageService.selectAllInPage(page);
	}
	
	@ApiOperation(value = "按 ID 返回评论")
	@RequestMapping("/selectById")
	public Result<?> selectById(@RequestBody Integer id) {
		return messageService.selectById(id);
	}
	
	@ApiOperation(value = "按 ID 删除评论")
	@RequestMapping("/deleteById")
	public Result<?> deleteById(@RequestBody Integer id){
		return messageService.deleteById(id);
	}
	
	@ApiOperation(value = "按 ID 更新评论")
	@RequestMapping("/updateById")
	public Result<?> updateById(@RequestBody Message message){
		return messageService.updateById(message);
	}
	
	
	@ApiOperation(value = "按 ID 取消隐藏消息")
	@RequestMapping("/setHideStatusFalseById")
	public Result<?> setHideStatusFalseById(@RequestBody Integer id) {
		return messageService.setHideStatusById(id, false);
	}
	
	@ApiOperation(value = "按 ID 隐藏消息")
	@RequestMapping("/setHideStatusTrueById")
	public Result<?> setHideStatusTrueById(@RequestBody Integer id) {
		return messageService.setHideStatusById(id, true);
	}
	
	@ApiOperation(value = "按 ID 显示状态设为未读")
	@RequestMapping("/setReadStatusUnreadById")
	public Result<?> setReadStatusUnreadById(@RequestBody Integer id) {
		return messageService.setReadStatusById(id, false);
	}
	
	@ApiOperation(value = "按 ID 显示状态设为已读")
	@RequestMapping("/setReadStatusReadById")
	public Result<?> setReadStatusReadById(@RequestBody Integer id) {
		return messageService.setReadStatusById(id, true);
	}
	
	
}
