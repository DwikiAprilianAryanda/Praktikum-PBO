package org.example.controllers;

import org.example.models.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HandphoneController {

    private ArrayList<Handphone> daftarHandphone = new ArrayList<>();

    public HandphoneController() {
        daftarHandphone.add(new Smartphone("Samsung", "Galaxy S23", 15000000, "Android"));
        daftarHandphone.add(new SmartphoneGaming("Asus", "ROG Phone 7", 20000000, "Android", 16));
        daftarHandphone.add(new FeaturePhone("Nokia", "3310", 500000, "2G"));
    }

    @GetMapping("/")
    public String tampilkanBeranda(Model model) {
        model.addAttribute("listHp", daftarHandphone);
        return "index";
    }

    // FITUR TAMBAH DATA (CREATE)

    // 1. Menampilkan halaman form tambah data
    @GetMapping("/tambah")
    public String tampilkanFormTambah() {
        return "tambah"; // Memanggil file tambah.html
    }

    // 2. Menangkap data yang dikirim dari form (Metode POST)
    @PostMapping("/simpan")
    public String simpanData(
            @RequestParam String merk,
            @RequestParam String nama,
            @RequestParam int harga,
            @RequestParam String jenis,
            @RequestParam String spesifikasi,
            @RequestParam int ram) {

        // Logika Polimorfisme & Instansiasi Objek
        if (jenis.equals("FeaturePhone")) {
            daftarHandphone.add(new FeaturePhone(merk, nama, harga, spesifikasi));
        } else if (jenis.equals("Smartphone")) {
            daftarHandphone.add(new Smartphone(merk, nama, harga, spesifikasi));
        } else if (jenis.equals("SmartphoneGaming")) {
            daftarHandphone.add(new SmartphoneGaming(merk, nama, harga, spesifikasi, ram));
        }

        // Setelah data ditambahkan ke ArrayList, arahkan paksa browser kembali ke Beranda ("/")
        return "redirect:/";
    }
}