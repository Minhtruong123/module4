package com.example.validatesong.controller;

import com.example.validatesong.model.Song;
import com.example.validatesong.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String showListSong(Model model){
        model.addAttribute("listSong", songService.listAllSongs());
        return "list";
    }
    @GetMapping("/showFormCreate")
    public String showFormCreate(Model model){
        model.addAttribute("song", new Song());
        return "create";
    }
    @PostMapping("createSong")
    public String createNewSong(@Validated @ModelAttribute Song song, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return "create";
        }else {
            songService.addNewSong(song);
            return "redirect:/song";
        }
    }
    @GetMapping("formEdit/{id}")
    public String showFormEdit(@PathVariable Integer id, Model model){
        model.addAttribute("song", songService.findSongById(id));
        return "edit";
    }
    @PostMapping("editSong")
    public String editSong(@ModelAttribute Song song,BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return "edit";
        }else {
            songService.updateSong(song);
            return "redirect:/song";
        }
    }
}
