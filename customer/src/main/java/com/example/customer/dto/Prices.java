package com.example.customer.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@Data
public class Prices {
    private List<Price> prices;
}
