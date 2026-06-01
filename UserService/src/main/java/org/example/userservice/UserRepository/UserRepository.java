package org.example.userservice.UserRepository;

import org.example.userservice.UserEntity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUsername(String username);
    User findByUserid(Integer userid);
    boolean existsByUserId(Integer userid);
}
