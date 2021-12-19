package com.example.pricesservice;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class Controller {
    final Repo repo;
    @GetMapping
    public ResponseEntity<Prices> index() {
        Prices prices = new Prices();
        prices.setPrices(repo.findAll());
        return ResponseEntity.ok(prices);
    }
    @PostMapping
    public void add(@RequestBody Price price) {
        repo.save(price);
    }
    @GetMapping("{name}")
    public int priceOf(@PathVariable String name) {
        return repo.findById(name).get().price;
    }
}
