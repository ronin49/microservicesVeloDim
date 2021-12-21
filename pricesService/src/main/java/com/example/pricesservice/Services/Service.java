package com.example.pricesservice.Services;

import com.example.pricesservice.Repo.Model.Price;
import com.example.pricesservice.API.dto.Prices;
import com.example.pricesservice.Repo.Repo;
import lombok.RequiredArgsConstructor;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class Service {
    final Repo repo;
    public Prices getPrices() {
        Prices prices = new Prices();
        prices.setPrices(repo.findAll());
        return prices;
    }
    public void addPrice(Price price) {
        repo.save(price);
    }
    public int getPrice(String name) {
        return repo.findById(name).get().getPrice();
    }
}
