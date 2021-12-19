package com.example.pricesservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository<Price,String> {
}
