package com.geekster.Instagram_Basic.services;

import com.geekster.Instagram_Basic.dto.SignInInput;
import com.geekster.Instagram_Basic.dto.SignInOutput;
import com.geekster.Instagram_Basic.dto.SignUpInput;
import com.geekster.Instagram_Basic.dto.SignUpOutput;
import com.geekster.Instagram_Basic.models.AuthenticationToken;
import com.geekster.Instagram_Basic.models.User;
import com.geekster.Instagram_Basic.repositories.IUserRepo;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    IUserRepo userRepo;

    @Autowired
    AuthenticationService authService;

    @SneakyThrows
    public SignUpOutput userSignUp(SignUpInput signUpInput) {
        // Check if the User is already exists or not
        User user = userRepo.findByUserEmail(signUpInput.getEmailId());

        if(user!=null){
            throw new IllegalAccessException("User already exists..SignIn instead");
        }

        // Encrypted the password
        String encryptedPassword=null;
        try {
            encryptedPassword=encryptMyPassword(signUpInput.getPassword());
        }catch (Exception e){
            e.printStackTrace();
        }

        //Creation of a user Object
        user = new User(signUpInput.getFirstName(),signUpInput.getLastName(),signUpInput.getEmailId(),encryptedPassword);

        //Save User in DB
        userRepo.save(user);

        //Save User Authentication Info into Authentication-Token Table
        AuthenticationToken token=new AuthenticationToken(user);
        authService.saveToken(token);

        //Return SigUp output
        return new SignUpOutput("User account created successfully..!", HttpStatus.CREATED);

    }

    private String encryptMyPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(password.getBytes());
        byte[] digested = md5.digest();

        String hash="";
        for(byte val:digested){
            hash += String.format("%02X",val);
        }
        return hash;
    }

    public SignInOutput userSignIn(SignInInput signInInput) {
        User user = userRepo.getByUserEmail(signInInput.getUserEmail());

        if(user==null){
            throw new IllegalArgumentException("Invalid UserName or Password..!");
        }

        String encryptedPassword=null;
        try {
            encryptedPassword = encryptMyPassword(signInInput.getPassword());
        }catch (Exception e){
            e.printStackTrace();
        }
        boolean isCorrectPassword=user.getUserPassword().equals(encryptedPassword);

        if(!isCorrectPassword){
            throw new IllegalArgumentException("Invalid UserName or Password..!");
        }

        String token=authService.findTokenByUser(user).getToken();

        return new SignInOutput("User LogIn successful..!",token);

    }


    @Transactional
    public String updateUserInfo(String token,int age,String phNo) {
        Long id=null;
        try {
            id=authService.getByToken(token).getUser().getUserId();
        }catch (NullPointerException e){
            throw new NullPointerException("Invalid user input..!");
        }
        userRepo.updateUser(age,phNo,id);
        return "User successfully updated..!";

    }

    public List<User> findAllUser() {
        return userRepo.findAll();
    }
}
