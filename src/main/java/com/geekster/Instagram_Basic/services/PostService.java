package com.geekster.Instagram_Basic.services;

import com.geekster.Instagram_Basic.models.Post;
import com.geekster.Instagram_Basic.models.User;
import com.geekster.Instagram_Basic.repositories.IPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    IPostRepo postRepo;

    @Autowired
    AuthenticationService authService;

    @Autowired
    UserService userService;

    public String addPost(Post post,String token) {
        User user=null;
        try {
            user=authService.getByToken(token).getUser();
        }catch (NullPointerException e){
            throw new NullPointerException("Invalid user input..!");
        }
        Post myPost = new Post(user,post.getPostData());

        postRepo.save(myPost);
        return "Post save successfully..!";

    }

    public List<Post> findAllPostByUserId(int id) {
        List<User> users=userService.findAllUser();
        for (User user:users){
            if(user.getUserId()==id){
                List<Post> allPost=postRepo.findByUser(user);
                return allPost;
            }
        }
        return null;
    }

}
