package com.example.ClinicApp.Repository;

import com.example.ClinicApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query(value = "select * from user where username=?1",nativeQuery = true)
    Optional<User> findUserByName(String username);

}
