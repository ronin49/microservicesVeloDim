package com.example.pricesservice.Repo.Model;

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
