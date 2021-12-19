package com.example.customer;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;
@NoArgsConstructor
@Data
public class Prices {
    private List<Price> prices;
}
