package com.huseyin.ToDoListApp.user.repository;

import com.huseyin.ToDoListApp.user.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {

    @Query("SELECT u FROM Users u WHERE u.username = :username")
    Optional<Users> findByUsername(@Param(value = "username") String username);


    @Modifying
    @Query("UPDATE Users u Set u.password = :password WHERE u.id = :id")
    int updatePassword(@Param("id")Long id,@Param(value = "password") String password);
}
