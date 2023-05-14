package com.geekster.Instagram_Basic.services;

import com.geekster.Instagram_Basic.models.AuthenticationToken;
import com.geekster.Instagram_Basic.models.User;
import com.geekster.Instagram_Basic.repositories.IAuthenticationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayProperties;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    IAuthenticationRepo authRepo;

    public void saveToken(AuthenticationToken token){
        authRepo.save(token);
    }

    public AuthenticationToken findTokenByUser(User user) {
        return authRepo.getByUser(user);
    }

    public AuthenticationToken getByToken(String token) {
        return authRepo.getByToken(token);
    }
}
