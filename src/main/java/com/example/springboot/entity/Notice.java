package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
@TableName("notice")
public class Notice {
	@TableId(value="id", type=IdType.AUTO)
	private Integer id;
	
	@TableField("user_id")
	private Integer userId;
	
	/* read = read_status*/
	@TableField("read_status")
	private Boolean readStatus;
	
	@TableField("content")
	private String content;
	
	@TableField("create_time")
	private Timestamp createTime;
}
