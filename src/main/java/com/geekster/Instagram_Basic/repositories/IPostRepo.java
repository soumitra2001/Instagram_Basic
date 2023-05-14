package com.geekster.Instagram_Basic.repositories;

import com.geekster.Instagram_Basic.models.Post;
import com.geekster.Instagram_Basic.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPostRepo extends JpaRepository<Post,Long> {
    List<Post> findByUser(User user);
}
