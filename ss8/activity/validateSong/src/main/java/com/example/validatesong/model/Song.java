package com.example.validatesong.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Size(max = 800)
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$")
    private String nameSong;
    @NotEmpty
    @Size(max = 300)
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$")
    private String singer;
    @NotEmpty
    @Size(max = 1000)
    @Pattern(regexp = "^[a-zA-Z0-9^, ]*$")
    private String typeSong;

    public Song() {
    }

    public Song(Integer id, String nameSong, String singer, String typeSong) {
        this.id = id;
        this.nameSong = nameSong;
        this.singer = singer;
        this.typeSong = typeSong;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getTypeSong() {
        return typeSong;
    }

    public void setTypeSong(String typeSong) {
        this.typeSong = typeSong;
    }
}
