package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("message")
public class Message {
	@TableId(value="id", type=IdType.AUTO)
	private Integer id;
	
	@TableField("display_user_id")
	private Integer displayUserId;
	
	@TableField("transmit_user_id")
	private Integer transmitUserId;
	
	@TableField("receive_user_id")
	private Integer receiveUserId;
	
	/* read = read_status*/
	@TableField("read_status")
	private Boolean readStatus;
	
	/* hide = hide_status*/
	@TableField("hide_status")
	private Boolean hideStatus;
	
	@TableField("content")
	private String content;
	
	@TableField("post_time")
	private Timestamp postTime;
}
