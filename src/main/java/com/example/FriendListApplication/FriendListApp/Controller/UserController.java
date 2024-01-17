package com.example.FriendListApplication.FriendListApp.Controller;

import com.example.FriendListApplication.FriendListApp.Entity.User;
import com.example.FriendListApplication.FriendListApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/add)")
    public @ResponseBody String AddNewUser (@RequestParam String name, @RequestParam String timezone) {
        User n = new User();
        n.setName(name);
        n.setTimezone(timezone);
        userRepository.save(n);
        return "User saved";
    }
    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
