package com.example.pricesservice.API.dto;

import com.example.pricesservice.Repo.Model.Price;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
@Data
@RequiredArgsConstructor
public class Prices {
    List<Price> prices;
}
