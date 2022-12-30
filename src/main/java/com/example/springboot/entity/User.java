package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User {
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	
	@TableField("role")
	private Integer role;
	
	@TableField("user_name")
	private String userName;
	
	@TableField("password")
	private String password;
	
	@TableField("nick_name")
	private String nickName;
	
	@TableField("introduction")
	private String introduction;
	
	@TableField(exist = false)
	private String token;
	
	@TableField(exist = false)
	private String roleName;
}
