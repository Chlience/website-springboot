package com.example.springboot.controller;

import com.example.springboot.common.Result;
import com.example.springboot.entity.Post;
import com.example.springboot.service.PostService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Resource
    private PostService postService;

    @RequestMapping("/getAll")
    public Result<?> getAll(){
        return postService.getAllOrderByTime();
    }

    @RequestMapping("/selectById")
    public Result<?> selectById(Integer id) {
        return postService.selectById(id);
    }

    @RequestMapping("/deleteById")
    public Result<?> deleteById(Integer id){
        return postService.deleteById(id);
    }

    @RequestMapping("/updateById")
    public Result<?> updateById(@RequestBody Post post) {
        return postService.updateById(post);
    }

    @RequestMapping("/addPost")
    public Result<?> insert(@RequestBody Post post) {
        return postService.insert(post);
    }
}
