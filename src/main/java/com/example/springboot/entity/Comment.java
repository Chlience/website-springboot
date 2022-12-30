package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("comment")
public class Comment {
	@TableId(value="id", type=IdType.AUTO)
	private Integer id;
	
	@TableField("post_id")
	private Integer postId;
	
	@TableField("reply_id")
	private Integer replyId;
	
	@TableField("user_id")
	private Integer userId;
	
	@TableField("content")
	private String content;
	
	@TableField("post_time")
	private Date postTime;
}
