package com.example.FriendListApplication.FriendListApp.Controller;

import com.example.FriendListApplication.FriendListApp.Entity.Friend;
import com.example.FriendListApplication.FriendListApp.Repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/friends")
public class FriendController {

    @Autowired
    private FriendRepository friendRepository;

    @PostMapping(path="/add")
    public String AddNewUser (@RequestParam String name, @RequestParam String timezone) {
        Friend n = new Friend();
        n.setName(name);
        n.setTimezone(timezone);
        friendRepository.save(n);
        return "User saved";
    }

    @DeleteMapping(path="/delete/{id}")
    public String DeleteUser (@PathVariable("id") Integer userId) {
        try {
            friendRepository.deleteById(userId);
            return "Entry deleted";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to delete entry";
        }
    }
    @DeleteMapping(path="/delete/all")
    public @ResponseBody String DeleteAllUsers() {
        try {
            friendRepository.deleteAll();;
            return "Entries deleted";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to delete entry";
        }
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Friend> GetAllUsers() {
        return friendRepository.findAll();
    }
}
