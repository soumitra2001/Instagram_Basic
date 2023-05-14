package com.geekster.Instagram_Basic.repositories;

import com.geekster.Instagram_Basic.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IUserRepo extends JpaRepository<User,Long> {

    User findByUserEmail(String userEmail);

    User getByUserEmail(String userEmail);

    @Modifying
    @Query(value = "update user set user_age= :age,user_ph_number= :phNo where user_id= :id",nativeQuery = true)
    void updateUser(int age,String phNo,Long id);
}
