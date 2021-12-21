package com.example.pricesservice.API;

import com.example.pricesservice.Repo.Model.Price;
import com.example.pricesservice.API.dto.Prices;
import com.example.pricesservice.Services.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class Controller {
    final Service service;
    @GetMapping
    public ResponseEntity<Prices> index() {
        return ResponseEntity.ok(service.getPrices());
    }
    @PostMapping
    public void add(@RequestBody Price price) {
        service.addPrice(price);
    }
    @GetMapping("{name}")
    public int priceOf(@PathVariable String name) {
        return service.getPrice(name);
    }
}
