package com.example.pricesservice;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Price {
    @Id
    String name;
    int price;
}
