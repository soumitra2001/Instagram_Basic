package com.geekster.Instagram_Basic.controllers;

import com.geekster.Instagram_Basic.dto.SignInInput;
import com.geekster.Instagram_Basic.dto.SignInOutput;
import com.geekster.Instagram_Basic.dto.SignUpInput;
import com.geekster.Instagram_Basic.dto.SignUpOutput;
import com.geekster.Instagram_Basic.models.User;
import com.geekster.Instagram_Basic.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public SignUpOutput signUp(@Valid @RequestBody SignUpInput signUpInput){
        return userService.userSignUp(signUpInput);
    }

    @PostMapping("/signin")
    public SignInOutput signIn(@Valid @RequestBody SignInInput signInInput){
        return userService.userSignIn(signInInput);
    }

    @PutMapping("/info")
    public String updateUserDetails(@RequestParam String token,@RequestParam int age,@RequestParam String phNo){
        return userService.updateUserInfo(token,age,phNo);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users=userService.findAllUser();
        return new ResponseEntity<>(users,users!=null?HttpStatus.OK:HttpStatus.NO_CONTENT);
    }

}
