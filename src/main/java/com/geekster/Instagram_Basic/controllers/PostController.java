package com.geekster.Instagram_Basic.controllers;

import com.geekster.Instagram_Basic.models.Post;
import com.geekster.Instagram_Basic.services.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/post")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/{token}")
    public String addPost(@Valid @RequestBody Post post,@PathVariable String token){
        return postService.addPost(post,token);
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<List<Post>> getAllPostById(@PathVariable int id){
        List<Post> posts=postService.findAllPostByUserId(id);

        return new ResponseEntity<>(posts,posts.isEmpty()? HttpStatus.NO_CONTENT:HttpStatus.OK);
    }


}
