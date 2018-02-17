package com.shoppaholic.shoppaholic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class DataBaseUsage implements CommandLineRunner {
 @Autowired
 private ProductRepository productRepository;
 @Override
 public void run(String... args) throws Exception {
 productRepository.save(new Product("FIFA", 45, "El mejor simulador de fútbol","Videojuegos","18/10/2017","https://images-eu.ssl-images-amazon.com/images/I/51D3CEXmKjL._SL500_AC_SS250_.jpg"));
 productRepository.save(new Product("PUBG", 30, "Sobrevive ","2/12/2017","https://images-na.ssl-images-amazon.com/images/I/51P14ZPWsoL._AC_UL160_.jpg"));
 }
}