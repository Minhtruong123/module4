package com.example.validatesong.service;

import com.example.validatesong.model.Song;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISongService {
    List<Song> listAllSongs();

    void addNewSong(Song song);

    Song findSongById(int id);

    void updateSong(Song song);
}
