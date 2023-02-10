package com.example.library_model.controller;

import com.example.library_model.model.Library;
import com.example.library_model.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Library-app")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping("find-all")
    public List<Library> findAllLibrary(@RequestBody Library library){
        return libraryService.findAllLibrary();
    }
    @GetMapping("find-id/id/{id}")
    public Library findById(@PathVariable int id){
        return libraryService.findById(id);
    }
    @PostMapping("add-library")
    public void addLibrary(@RequestBody Library library){
        libraryService.addLibrary(library);
    }
    @PutMapping("update-library/id/{id}")
    public void updateLibrary(@PathVariable int id, @RequestBody Library library){
        libraryService.updateLibrary(id,library);
    }
    @DeleteMapping("delete-library/id/{id}")
    public void deleteLibrary(@PathVariable int id){
        libraryService.deleteLibrary(id);
    }
}