package com.example.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class CustomerApplication {

    public static void main(String[] args) {
        addTovari();
        pochinitDetali();
    }
    private static void pochinitDetali() {
        List<String> names = new ArrayList<String>();
        List<String> namesNo = new ArrayList<String>();
        List<String> namesYes = new ArrayList<String>();
        names.add("koleco");
        names.add("koleco");
        names.add("kolecdasasdo");
        names.add("koleco2");
        RestTemplate query = new RestTemplate();
        int price = 0;
        int time = 0;
        for(int i = 0; i < names.size(); i++)
            if(query.getForEntity("http://localhost:9001/chinim/" + names.get(i), boolean.class).getBody()) {
                try {
                    price += query.getForEntity("http://localhost:9000/" + names.get(i), int.class).getBody();
                    Pochinka pochinka = query.getForEntity("http://localhost:9001/" + names.get(i), Pochinka.class).getBody();
                    price += pochinka.cost;
                    time += pochinka.time;
                    namesYes.add(names.get(i));
                } catch (HttpServerErrorException e) {
                    namesNo.add(names.get(i));
                }
            } else {
                namesNo.add(names.get(i));
            }
        for(int i = 0; i < namesNo.size(); i++)
            System.out.println("No " + namesNo.get(i) + "!");
        System.out.println("BILL");
        for(int i = 0; i < namesYes.size(); i++)
            System.out.println("1x " + namesYes.get(i));
        System.out.println("TOTAL: " + price);
        System.out.println("prihodite cherez " + time + " secund");
    }
    private static void buyTovari() {
        List<String> names = new ArrayList<String>();
        List<String> namesNo = new ArrayList<String>();
        names.add("koleco");
        names.add("kolecdasasdo");
        names.add("koleco2");
        RestTemplate query = new RestTemplate();
        int price = 0;
        for(int i = 0; i < names.size(); i++)
            try {
                price += query.getForEntity("http://localhost:9000/" + names.get(i), int.class).getBody();
            } catch (HttpServerErrorException e) {
                namesNo.add(names.get(i));
            }
        for(int i = 0; i < namesNo.size(); i++)
            System.out.println("No " + namesNo.get(i) + "!");
        System.out.println("BILL");
        System.out.println(price);
    }
    private static void addTovari() {
        RestTemplate query = new RestTemplate();
        Price koleco = new Price();
        koleco.setName("koleco");
        koleco.setPrice(100);
        query.postForEntity("http://localhost:9000",new HttpEntity<Price>(koleco),Price.class);
        Pochinka kolecoPochinka = new Pochinka();
        kolecoPochinka.setName("koleco");
        kolecoPochinka.setCost(40);
        kolecoPochinka.setTime(400);
        query.postForEntity("http://localhost:9001",new HttpEntity<Pochinka>(kolecoPochinka),Pochinka.class);
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
