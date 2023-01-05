package com.example.springboot.controller;
import com.example.springboot.common.Result;
import com.example.springboot.entity.Message;
import com.example.springboot.service.MessageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

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
	
	@ApiOperation(value = "按 ID 显示所有发出或收到的信息")
	@RequestMapping("/selectByDisplayUserId")
	public Result<?> selectByDisplayUserId(@RequestBody Integer id) {
		return messageService.selectByDisplayUserId(id);
	}
	
	@ApiOperation(value = "分页按 ID 显示所有发出或收到的信息")
	@RequestMapping("/selectByDisplayUserIdInPage")
	public Result<?> selectByDisplayUserIdInPage(@RequestBody Map<String, String> param) {
		Integer id = Integer.valueOf(param.get("id"));
		Integer page = Integer.valueOf(param.get("page"));
		return messageService.selectByDisplayUserIdInPage(id, page);
	}
	
	@ApiOperation(value = "按 ID 显示所有发出的信息")
	@RequestMapping("/selectByTransmitUserId")
	public Result<?> selectByTransmitUserId(@RequestBody Integer id) {
		return messageService.selectByTransmitUserId(id);
	}
	
	@ApiOperation(value = "分页按 ID 显示所有发出的信息")
	@RequestMapping("/selectByTransmitUserIdInPage")
	public Result<?> selectByTransmitUserIdInPage(@RequestBody Map<String, String> param) {
		Integer id = Integer.valueOf(param.get("id"));
		Integer page = Integer.valueOf(param.get("page"));
		return messageService.selectByTransmitUserIdInPage(id, page);
	}
	
	@ApiOperation(value = "按 ID 显示所有收到的信息")
	@RequestMapping("/selectByReceiveUserId")
	public Result<?> selectByReceiveUserId(@RequestBody Integer id) {
		return messageService.selectByReceiveUserId(id);
	}
	
	@ApiOperation(value = "分页按 ID 显示所有收到的信息")
	@RequestMapping("/selectByReceiveUserIdInPage")
	public Result<?> selectByReceiveUserIdInPage(@RequestBody Map<String, String> param) {
		Integer id = Integer.valueOf(param.get("id"));
		Integer page = Integer.valueOf(param.get("page"));
		return messageService.selectByReceiveUserIdInPage(id, page);
	}
	
	@ApiOperation(value = "按发送 ID 和接受 ID 显示所有信息")
	@RequestMapping("/selectByTransmitAndReceiveUserId")
	public Result<?> selectByTransmitAndReceiveUserId(@RequestBody Map<String, String> param) {
		Integer transmitUserId = Integer.valueOf(param.get("transmitUserId"));
		Integer receiveUserId = Integer.valueOf(param.get("receiveUserId"));
		return messageService.selectByTransmitAndReceiveUserId(transmitUserId, receiveUserId);
	}
	
	@ApiOperation(value = "分页按发送 ID 和接受 ID 显示所有信息")
	@RequestMapping("/selectByTransmitAndReceiveUserIdInPage")
	public Result<?> selectByTransmitAndReceiveUserIdInPage(@RequestBody Map<String, String> param) {
		Integer transmitUserId = Integer.valueOf(param.get("transmitUserId"));
		Integer receiveUserId = Integer.valueOf(param.get("receiveUserId"));
		Integer page = Integer.valueOf(param.get("page"));
		return messageService.selectByTransmitAndReceiveUserIdInPage(transmitUserId, receiveUserId, page);
	}
}
