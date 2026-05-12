package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TokoApplication {
    public static void main(String[] args) {
        // Menyalakan server web internal (Tomcat)
        SpringApplication.run(TokoApplication.class, args);
        System.out.println("SERVER WEB BERHASIL MENYALA! Buka http://localhost:8080 di browser Anda.");
    }
}