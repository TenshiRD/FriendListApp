package com.example.FriendListApplication.FriendListApp.Repository;


import com.example.FriendListApplication.FriendListApp.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
