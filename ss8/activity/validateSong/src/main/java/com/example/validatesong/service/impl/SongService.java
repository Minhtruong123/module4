package com.example.validatesong.service.impl;

import com.example.validatesong.model.Song;
import com.example.validatesong.repository.ISongRepository;
import com.example.validatesong.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository songRepository;

    @Override
    public List<Song> listAllSongs() {
        return songRepository.findAll();
    }

    @Override
    public void addNewSong(Song song) {
        songRepository.save(song);
    }

    @Override
    public Song findSongById(int id) {
        return songRepository.getById(id);
    }

    @Override
    public void updateSong(Song song) {
        songRepository.save(song);
    }
}
