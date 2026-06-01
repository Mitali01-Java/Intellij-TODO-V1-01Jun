package org.example.userservice.UserService;

import lombok.AllArgsConstructor;
import org.example.userservice.ExceptionHandling.UserAlreadyExist;
import org.example.userservice.UserEntity.User;
import org.example.userservice.UserRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {


    private final UserRepository userRepository;

    // create user
    public User CreateUser(User user) {
        if(userRepository.existsByUserId(user.getUserid())){
            throw new RuntimeException("User already exist with id : "+ user.getUserid());
        }
        return userRepository.save(user);
    }
    //list of user
    public List<User> AllUsers() {
        return userRepository.findAll();
    }

    // update user
    public User UpdateUser(Integer userid,User user) {
        User existinguser = userRepository.findById(userid)
                .orElseThrow(() -> new RuntimeException("user not found"));

        existinguser.setUsername(user.getUsername());
        existinguser.setPassword(user.getPassword());

        return userRepository.save(existinguser);
    }

    //Del user
    public String DeleteUser(Integer userid) {

        User user = userRepository.findById(userid)
                .orElseThrow(() ->
                        new RuntimeException("User not found with id: " + userid));

        userRepository.delete(user);

        return "User deleted successfully";
    }




    // get user by username
//    public User getUserByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }
//
//    public User getUserByUserId(Integer userid) {
//        return userRepository.findByUserid(userid);
//    }





}
