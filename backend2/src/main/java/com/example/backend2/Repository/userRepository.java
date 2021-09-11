package com.example.backend2.Repository;

import com.example.backend2.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface userRepository extends JpaRepository<Users,Long> {

    @Query(value = "SELECT * FROM Users WHERE name = ?1 AND  password = ?2", nativeQuery = true)
    List<Users> findByUserNameAndPassword (String name , String password);


}
