package com.example.springboot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.common.Result;
import com.example.springboot.entity.Message;
import com.example.springboot.mapper.MessageMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MessageService {
	final static int PAGE_RECORDS_NUM = 10;
	
	@Resource
	private MessageMapper messageMapper;
	
	public Result<?> selectById(Integer id) {
		QueryWrapper<Message> wrapper = new QueryWrapper<>();
		wrapper.eq("id", id);
		return Result.success(messageMapper.selectById(id));
	}
	
	public Result<?> deleteById(Integer id) {
		messageMapper.deleteById(id);
		return Result.success();
	}
	
	public Result<?> updateById(Message message) {
		messageMapper.updateById(message);
		return Result.success();
	}
	
	public Result<?> setHideStatusById(Integer id, Boolean hideStatus) {
		Message message = messageMapper.selectById(id);
		message.setHideStatus(hideStatus);
		messageMapper.updateById(message);
		return Result.success();
	}
	
	public Result<?> setReadStatusById(Integer id, Boolean readStatus) {
		Message message = messageMapper.selectById(id);
		message.setReadStatus(readStatus);
		messageMapper.updateById(message);
		return Result.success();
	}
	
	public Result<?> selectAll() {
		QueryWrapper<Message> queryWrapper = new QueryWrapper<>();
		queryWrapper.orderByDesc("post_time");
		return Result.success(messageMapper.selectList(queryWrapper));
	}
	
	public Result<?> selectAllInPage(Integer page) {
		QueryWrapper<Message> wrapper = new QueryWrapper<>();
		wrapper.orderByDesc("post_time");
		Page<Message> queryPage = new Page<>(page, PAGE_RECORDS_NUM);
		Page<Message> resultPage = messageMapper.selectPage(queryPage, wrapper);
		List<Message> records = resultPage.getRecords();
		if(records.size() == 0)
			return Result.error("204", "No More Content");
		return Result.success(records);
	}
	
	public Result<?> selectByDisplayUserId(Integer id) {
		QueryWrapper<Message> wrapper = new QueryWrapper<>();
		wrapper.eq("display_user_id", id)
				.eq("hide_status", false)
				.orderByDesc("post_time");
		return Result.success(messageMapper.selectList(wrapper));
	}
	
	public Result<?> selectByDisplayUserIdInPage(Integer id, Integer page) {
		QueryWrapper<Message> wrapper = new QueryWrapper<>();
		wrapper.eq("display_user_id", id)
				.eq("hide_status", false)
				.orderByDesc("post_time");
		Page<Message> queryPage = new Page<>(page, PAGE_RECORDS_NUM);
		Page<Message> resultPage = messageMapper.selectPage(queryPage, wrapper);
		List<Message> records = resultPage.getRecords();
		if(records.size() == 0)
			return Result.error("204", "No More Content");
		return Result.success(records);
	}
	
	public Result<?> selectByTransmitUserId(Integer id) {
		QueryWrapper<Message> wrapper = new QueryWrapper<>();
		wrapper.eq("transmit_user_id", id)
				.eq("hide_status", false)
				.orderByDesc("post_time");
		return Result.success(messageMapper.selectList(wrapper));
	}
	
	public Result<?> selectByTransmitUserIdInPage(Integer id, Integer page) {
		QueryWrapper<Message> wrapper = new QueryWrapper<>();
		wrapper.eq("transmit_user_id", id)
				.eq("hide_status", false)
				.orderByDesc("post_time");
		Page<Message> queryPage = new Page<>(page, PAGE_RECORDS_NUM);
		Page<Message> resultPage = messageMapper.selectPage(queryPage, wrapper);
		List<Message> records = resultPage.getRecords();
		if(records.size() == 0)
			return Result.error("204", "No More Content");
		return Result.success(records);
	}
	
	public Result<?> selectByReceiveUserId(Integer id) {
		QueryWrapper<Message> wrapper = new QueryWrapper<>();
		wrapper.eq("receive_user_id", id)
				.eq("hide_status", false)
				.orderByDesc("post_time");
		return Result.success(messageMapper.selectList(wrapper));
	}
	
	public Result<?> selectByReceiveUserIdInPage(Integer id, Integer page) {
		QueryWrapper<Message> wrapper = new QueryWrapper<>();
		wrapper.eq("receive_user_id", id)
				.eq("hide_status", false)
				.orderByDesc("post_time");
		Page<Message> queryPage = new Page<>(page, PAGE_RECORDS_NUM);
		Page<Message> resultPage = messageMapper.selectPage(queryPage, wrapper);
		List<Message> records = resultPage.getRecords();
		if(records.size() == 0)
			return Result.error("204", "No More Content");
		return Result.success(records);
	}
	
	public Result<?> selectByTransmitAndReceiveUserId(Integer transmitUserId, Integer receiveUserId) {
		QueryWrapper<Message> wrapper = new QueryWrapper<>();
		wrapper.eq("transmit_user_id", transmitUserId)
				.eq("receive_user_id", receiveUserId)
				.eq("hide_status", false)
				.orderByDesc("post_time");
		return Result.success(messageMapper.selectList(wrapper));
	}
	
	public Result<?> selectByTransmitAndReceiveUserIdInPage(Integer transmitUserId, Integer receiveUserId, Integer page) {
		QueryWrapper<Message> wrapper = new QueryWrapper<>();
		wrapper.eq("transmit_user_id", transmitUserId)
				.eq("receive_user_id", receiveUserId)
				.eq("hide_status", false)
				.orderByDesc("post_time");
		Page<Message> queryPage = new Page<>(page, PAGE_RECORDS_NUM);
		Page<Message> resultPage = messageMapper.selectPage(queryPage, wrapper);
		List<Message> records = resultPage.getRecords();
		if(records.size() == 0)
			return Result.error("204", "No More Content");
		return Result.success(records);
	}
}
