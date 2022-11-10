package com.example.springboot.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.springboot.entity.User;
import com.example.springboot.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Date;

@Slf4j
@Component
public class Token {
    @Resource
    private UserMapper userMapper;
    
    private static UserMapper staticUserMapper;
    // 实现静态方法需要将 UserMapper 转为静态类
    
    @PostConstruct
    public void init() {
        staticUserMapper = userMapper;
    }
    // PostConstruct 在 Resource 注入后执行
    
    private static final String SECRET = "d0601806-5bed-11ed-9b6a-0242ac120002";

    public static String getToken(User user) {
        return JWT.create()
                .withExpiresAt(new Date(System.currentTimeMillis() + (5 * 60 * 1000)))
                .withAudience(user.getId().toString())
                .sign(Algorithm.HMAC256(SECRET)); //HS256
    }
    
    public static User getUser(String token) {
        try {
            String audience = JWT.decode(token).getAudience().get(0);
            Integer userId = Integer.valueOf(audience);
            return staticUserMapper.selectById(userId);
        } catch (Exception e) {
            log.error("解析token失败", e);
            return null;
        }
    }
}
