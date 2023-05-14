package com.geekster.Instagram_Basic.repositories;

import com.geekster.Instagram_Basic.models.AuthenticationToken;
import com.geekster.Instagram_Basic.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthenticationRepo extends JpaRepository<AuthenticationToken,Long> {

    AuthenticationToken getByUser(User user);

    AuthenticationToken getByToken(String token);
}
