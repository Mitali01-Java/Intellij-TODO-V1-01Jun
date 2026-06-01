package org.example.userservice.UserController;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.userservice.UserEntity.User;
import org.example.userservice.UserService.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/User")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/All")
    public ResponseEntity<?> AllUsers(){
       // return new ResponseEntity.status(HttpStatus.OK).body(userService.AllUsers());
        return ResponseEntity.status(HttpStatus.OK).body(userService.AllUsers());
    }

    @PostMapping("/Add")
    public ResponseEntity<?> AddUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.OK).body(userService.CreateUser(user));
    }

    @PutMapping("/UpdateUser/{userid}")
    public ResponseEntity<?> UpdateUser(@PathVariable Integer userid ,@RequestBody User user){
        User updateuser = userService.UpdateUser(userid,user);
        return ResponseEntity.status(HttpStatus.OK).body(updateuser);
    }

    @DeleteMapping("/Delete/{userid}")
    public ResponseEntity<?> DeleteUser(@PathVariable Integer userid){
        String user = userService.DeleteUser(userid);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }





}
