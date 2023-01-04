package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("message")
public class Message {
	@TableId(value="id", type=IdType.AUTO)
	private Integer id;
	
	@TableField("display_user_id")
	private Integer displayUserId;
	
	/* hide = hide_status*/
	@TableField("hide_status")
	private Boolean hideStatus;
	
	/* read = read_status*/
	@TableField("read_status")
	private Boolean readStatus;
	
	@TableField("transmit_user_id")
	private Integer transmitUserId;
	
	@TableField("receive_user_id")
	private Integer receiveUserId;
	
	@TableField("content")
	private String content;
	
	@TableField("post_time")
	private Date postTime;
}
