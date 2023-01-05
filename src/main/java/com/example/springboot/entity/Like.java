package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
@TableName("like_table")
public class Like {
	@TableId(value="id", type=IdType.AUTO)
	private Integer id;
	
	@TableField("post_id")
	private Integer postId;
	
	@TableField("user_id")
	private Integer userId;
	
	@TableField("create_time")
	private Timestamp createTime;
}
