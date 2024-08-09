package com.ducphong.Song.controller;

import com.ducphong.Song.model.Song;
import com.ducphong.Song.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SongController {
    @Autowired
    private SongService songService;

    @PostMapping("/api/song")
    public Song addSchool(@RequestBody Song song){
        return songService.addSong(song);
    }
    @GetMapping("/api/song")
    public List<Song> fetchSchools(){
        return songService.fetchSongs();
    }
    @GetMapping("/api/song/{id}")
    public Song fetchSchoolById(@PathVariable int id){
        return songService.fetchSongById(id);
    }

    @DeleteMapping("/api/song/{id}")
    public String deleteSong(@PathVariable int id){
        return songService.deleteSong(id);
    }

    @PutMapping("/api/song/{id}")
    public String updateSong(@PathVariable int id, @RequestBody Song song){
        return songService.updateSong(id, song);
    }
}
