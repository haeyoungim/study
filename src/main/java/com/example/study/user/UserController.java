package com.example.study.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") Long id){
        return userService.getUser(id);
    }

    @PostMapping("/users")
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @PutMapping("/users/{id}")
    public User modify(@RequestBody User user,
                       @PathVariable("id") Long id){
        User user1 = User.builder()
                .id(id)
                .userId(user.getUserId())
                .email(user.getEmail())
                .pwd(user.getPwd())
                .name(user.getName())
                .phoneNum(user.getPhoneNum())
                .build();

        return userService.modify(user1);
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable("id") Long id){
        userService.delete(id);
    }
    
}
