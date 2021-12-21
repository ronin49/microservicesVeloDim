package com.example.pricesservice.Repo;

import com.example.pricesservice.Repo.Model.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository<Price,String> {
}
