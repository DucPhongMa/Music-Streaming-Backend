package com.ducphong.User.Service.service;

import com.ducphong.User.Service.model.User;
import com.ducphong.User.Service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<?> createUser(User user){
        try{
            return new ResponseEntity<User>(userRepository.save(user), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> fetchUserById(String id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            List<Song> songs = new ArrayList<>();
            for(Integer songId : user.get().getSongId()) {
                Song song = restTemplate.getForObject("http://SONG-SERVICE/api/song/" + songId, Song.class);
                songs.add(song);
            }
            UserResponse userResponse = new UserResponse(
                    user.get().getId(),
                    user.get().getEmail(),
                    user.get().getPassword(),
                    user.get().getRole(),
                    songs
            );
            return new ResponseEntity<>(userResponse, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No User Found",HttpStatus.NOT_FOUND);
        }
    }


    public ResponseEntity<?> fetchUsers(){
        List<User> users = userRepository.findAll();
        if(!users.isEmpty()){
            return new ResponseEntity<List<User>>(users, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No Users",HttpStatus.NOT_FOUND);
        }
    }
}
