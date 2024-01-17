package com.example.FriendListApplication.FriendListApp.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    private String timeZone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimezone() {
        return timeZone;
    }

    public void setTimezone(String timezone) {
        this.timeZone = timeZone;
    }
}
