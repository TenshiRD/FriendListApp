package com.example.FriendListApplication.FriendListApp.Repository;


import com.example.FriendListApplication.FriendListApp.Entity.Friend;
import org.springframework.data.repository.CrudRepository;

public interface FriendRepository extends CrudRepository<Friend, Integer> {
}
