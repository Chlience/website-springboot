package com.example.springboot.service;

import com.example.springboot.mapper.PostMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleService {
    @Resource
    private PostMapper postMapper;
}
