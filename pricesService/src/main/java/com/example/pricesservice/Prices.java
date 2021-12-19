package com.example.pricesservice;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
@Data
@RequiredArgsConstructor
public class Prices {
    private List<Price> prices;
}
