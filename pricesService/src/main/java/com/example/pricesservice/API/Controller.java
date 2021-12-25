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
    Price f(String name, int price) {
        Price p = new Price();
        p.setName(name);
        p.setPrice(price);
        return p;
    }
    @GetMapping("init")
    public void initBase() {
        add(f("koleco",100));
    }
    @GetMapping
    public ResponseEntity<Prices> index() {
        return ResponseEntity.ok(service.getPrices());
    }
    @PostMapping
    public void add(@RequestBody Price price) {
        service.addPrice(price);
    }
    @GetMapping("price/{name}")
    public ResponseEntity<Price> priceOf(@PathVariable String name) {

        try {

            return ResponseEntity.ok(service.getPrice(name));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

        }
}
