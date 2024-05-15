package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.model2.NameEntry;
import com.example.demo.repository2.NameEntryRepository;

@RestController
public class NameEntryController {

    @Autowired
    private NameEntryRepository nameEntryRepository;
    
    @PostMapping("/addName")
    public NameEntry addName(@RequestBody String name) {
        NameEntry newNameEntry = new NameEntry(name);
        return nameEntryRepository.save(newNameEntry);
    }
    
    @GetMapping("/getAllNames")
    public List<NameEntry> getAllNames(){
    	return nameEntryRepository.findAll();
    }
    
    @GetMapping("/getNameById/{id}")
    public Optional<NameEntry> getNameById(@PathVariable int id) {
    	return nameEntryRepository.findById(id);
    }
    
    
}
