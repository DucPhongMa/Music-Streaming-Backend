package com.ducphong.User.Service.service;

import java.util.List;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class UserResponse {
    private String id;
    private String email;
    private String password;
    private String role;
    private List<Song> songs;

    public UserResponse(String id, String email, String password, String role, List<Song> songs) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.songs = songs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Song> getSong() {
        return songs;
    }

    public void setSong(List<Song> song) {
        this.songs = song;
    }
}
