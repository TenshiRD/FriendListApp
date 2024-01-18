package com.example.FriendListApplication.FriendListApp.Controller;

import com.example.FriendListApplication.FriendListApp.Entity.Friend;
import com.example.FriendListApplication.FriendListApp.Repository.FriendRepository;
import com.example.FriendListApplication.FriendListApp.Service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/friends")
public class FriendController {

    @Autowired
    private FriendRepository friendRepository;
    @Autowired
    private FriendService friendService;

    @PostMapping(path="/add")
    public String AddNewFriend (@RequestParam String name, @RequestParam String timezone) {
        friendService.AddFriend(name, timezone);
        return "User saved";
    }

    @DeleteMapping(path="/delete/{id}")
    public String DeleteEntry (@PathVariable("id") Long userId) {
        try {
            friendService.DeleteEntry(userId);
            return "Entry deleted";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to delete entry";
        }
    }
    @DeleteMapping(path="/delete/all")
    public @ResponseBody String EmptyFriendList() {
        try {
            friendService.DeleteAllEntries();
            return "Entries deleted";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to delete entries";
        }
    }
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Friend> GetFriendList() {
        return friendService.GetAllFriends();
    }
}
