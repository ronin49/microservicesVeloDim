package com.example.customer;

import lombok.Data;

@Data
public class Price {
    String name;
    int price;
    public String ToString() {
        String s = "";
        s += name + "\t" + price;
        return s;
    }
}