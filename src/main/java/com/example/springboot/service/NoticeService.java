package com.example.springboot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.common.Result;
import com.example.springboot.entity.Notice;
import com.example.springboot.mapper.NoticeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NoticeService {
	final static int PAGE_RECORDS_NUM = 10;
	
	@Resource
	private NoticeMapper noticeMapper;
	
	public Result<?> selectById(Integer id) {
		QueryWrapper<Notice> wrapper = new QueryWrapper<>();
		wrapper.eq("id", id);
		return Result.success(noticeMapper.selectById(id));
	}
	
	public Result<?> deleteById(Integer id) {
		noticeMapper.deleteById(id);
		return Result.success();
	}
	
	public Result<?> updateById(Notice notice) {
		noticeMapper.updateById(notice);
		return Result.success();
	}
	
	public Result<?> setReadStatusById(Integer id, Boolean readStatus) {
		Notice notice = noticeMapper.selectById(id);
		notice.setReadStatus(readStatus);
		noticeMapper.updateById(notice);
		return Result.success();
	}
	
	public Result<?> setReadStatusByUserId(Integer userId, Boolean readStatus) {
		QueryWrapper<Notice> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("user_id", userId)
				.eq("read_status", readStatus);
		Notice notice = new Notice();
		notice.setReadStatus(true);
		noticeMapper.update(notice, queryWrapper);
		return Result.success();
	}
	
	public Result<?> selectAll() {
		QueryWrapper<Notice> queryWrapper = new QueryWrapper<>();
		queryWrapper.orderByDesc("create_time");
		return Result.success(noticeMapper.selectList(queryWrapper));
	}
	
	public Result<?> selectAllInPage(Integer page) {
		QueryWrapper<Notice> queryWrapper = new QueryWrapper<>();
		queryWrapper.orderByDesc("create_time");
		Page<Notice> queryPage = new Page<>(page, PAGE_RECORDS_NUM);
		Page<Notice> resultPage = noticeMapper.selectPage(queryPage, queryWrapper);
		List<Notice> records = resultPage.getRecords();
		if(records.size() == 0)
			return Result.error("204", "No More Content");
		return Result.success(records);
	}
	
	public Result<?> selectByUserId(Integer userId) {
		QueryWrapper<Notice> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("user_id", userId)
				.orderByDesc("create_time");
		return Result.success(noticeMapper.selectList(queryWrapper));
	}
	
	public Result<?> selectByUserIdInPage(Integer userId, Integer page) {
		QueryWrapper<Notice> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("user_id", userId)
				.orderByDesc("create_time");
		Page<Notice> queryPage = new Page<>(page, PAGE_RECORDS_NUM);
		Page<Notice> resultPage = noticeMapper.selectPage(queryPage, queryWrapper);
		List<Notice> records = resultPage.getRecords();
		if(records.size() == 0)
			return Result.error("204", "No More Content");
		return Result.success(records);
	}
}
