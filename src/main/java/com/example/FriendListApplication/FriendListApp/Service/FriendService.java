package com.example.FriendListApplication.FriendListApp.Service;

import com.example.FriendListApplication.FriendListApp.Entity.Friend;
import com.example.FriendListApplication.FriendListApp.Repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendService {
    @Autowired
    private FriendRepository friendRepository;

    public void AddFriend(String name, String timezone) {
        Friend n = new Friend();
        n.setName(name);
        n.setTimezone(timezone);
        friendRepository.save(n);
    }

    public void DeleteEntry(Long userId){
        friendRepository.deleteById(userId);
    }

    public void DeleteAllEntries() {
        friendRepository.deleteAll();
    }

    public Iterable<Friend> GetAllFriends(){
        return friendRepository.findAll();
    }
}
