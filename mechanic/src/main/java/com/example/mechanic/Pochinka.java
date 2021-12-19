package com.example.mechanic;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Pochinka {
    @Id
    String name;
    int cost;
    int time;
}
