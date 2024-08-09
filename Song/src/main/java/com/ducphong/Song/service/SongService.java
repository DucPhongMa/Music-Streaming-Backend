package com.ducphong.Song.service;

import com.ducphong.Song.model.Song;
import com.ducphong.Song.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    public Song addSong(Song song){
        return songRepository.save(song);
    }

    public List<Song> fetchSongs(){
        return songRepository.findAll();
    }
    public Song fetchSongById(int id){
        return songRepository.findById(String.valueOf(id)).orElse(null);
    }

    public String deleteSong(int id) {
        Optional<Song> songOptional = songRepository.findById(String.valueOf(id));
        if (songOptional.isPresent()) {
            songRepository.deleteById(String.valueOf(id));
            return "Song is deleted";
        } else {
            return "Song not found";
        }
    }

    public String updateSong(@PathVariable int id, @RequestBody Song songDetails) {
        Optional<Song> songOptional = songRepository.findById(String.valueOf(id));
        if (songOptional.isPresent()) {
            Song song = songOptional.get();
            if (songDetails.getSongTitle() != null) {
                song.setSongTitle(songDetails.getSongTitle());
            }
            if (songDetails.getArtistName() != null) {
                song.setArtistName(songDetails.getArtistName());
            }
            if (songDetails.getGenre() != null) {
                song.setGenre(songDetails.getGenre());
            }
            if (songDetails.getDuration() != null) {
                song.setDuration(songDetails.getDuration());
            }
            if (songDetails.getFilePath() != null) {
                song.setFilePath(songDetails.getFilePath());
            }

            songRepository.save(song);
            return "Song is updated";
        } else {
            return "Song not found";
        }
    }
}
