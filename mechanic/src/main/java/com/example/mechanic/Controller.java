package com.example.mechanic;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class Controller {
    final Repo repo;
    @GetMapping("{name}")
    public Pochinka pochinka(@PathVariable String name) {
        Optional<Pochinka> pochinka = repo.findById(name);
        if(pochinka.isPresent())
            return pochinka.get();
        else throw new IllegalArgumentException("not chinim it!");
    }
    @GetMapping("chinim/{name}")
    public boolean chinim(@PathVariable String name) {
        Optional<Pochinka> pochinka = repo.findById(name);
        if(pochinka.isPresent())
            return true;
        else return false;
    }
    @PostMapping
    public void add(@RequestBody Pochinka pochinka) {
        repo.save(pochinka);
    }
}
