package com.darius.contentcalendar.controller;

import com.darius.contentcalendar.model.Content;
import com.darius.contentcalendar.repository.ContentCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/content")
public class ContentController {

//    private ContentCollectionRepository repository;
//    public ContentController(ContentCollectionRepository contentCollectionRepository) {
//        this.repository = contentCollectionRepository;
//    }

    private final ContentCollectionRepository repository;

    @Autowired
    public ContentController(ContentCollectionRepository repository) {
        this.repository = repository;
    }

    // make a request and find all the pieces of content in the system
    // create, read, update, delete
    @GetMapping("")
    public List<Content> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Content findByID(@PathVariable Integer id) {
        return repository.findByID(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "content not found"));
    }

    @PostMapping("")
    public void create(@RequestBody Content content) {
        repository.save(content);
    }




}












