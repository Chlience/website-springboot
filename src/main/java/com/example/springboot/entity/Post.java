package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("post")
public class Post {
	@TableId(value="id", type=IdType.AUTO)
	private Integer id;
	
	@TableField("user_id")
	private Integer userId;
	
	@TableField("content")
	private String content;
	
	@TableField("post_time")
	private Timestamp postTime;
	
	/* hiding = hide_status*/
	@TableField("hide_status")
	private Boolean hideStatus;
	
	/* 0: wait; 1: pass; 2: fail; */
	@TableField("review_status")
	private Integer reviewStatus;
	
	@TableField("star_status")
	private Boolean starStatus;
}
