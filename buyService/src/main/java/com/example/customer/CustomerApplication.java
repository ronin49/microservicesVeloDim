package com.example.customer;

import com.example.customer.dto.Pochinka;
import com.example.customer.dto.Price;
import com.example.customer.dto.Prices;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@RequiredArgsConstructor
public class CustomerApplication {
    public static void main(String[] args) {
        init();
        showTovari();
        buy("koleco");
        buy("koleco");
        buy("koleco2");
        total();
    }
    private static int total = 0;
    private static void total() {
        System.out.println("TOTAL: " + total);
    }
    private static void init() {
        RestTemplate query = new RestTemplate();
        query.getForEntity("http://localhost:9000/init",Void.class);
    }
    private static void buy(String name) {
        RestTemplate query = new RestTemplate();
        try {
            Price price = query.getForEntity("http://localhost:9000/price/" + name, Price.class).getBody();
            System.out.println("buying " + name + " - " + price.getPrice());
            total += price.getPrice();
        } catch (Exception e) {
            System.out.println("No " + name + " left! We can order!");
        }
    }
    private static void showTovari() {
        RestTemplate query = new RestTemplate();
        Prices prices = query.getForEntity("http://localhost:9000",Prices.class).getBody();
        System.out.println("MARKET");
        System.out.println("name\tprice");
        for(int i = 0; i < prices.getPrices().size(); i++)
            System.out.println(prices.getPrices().get(i).ToString());
    }
}
