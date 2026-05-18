package org.example.controllers;

import org.example.models.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/tambah")
    public String tampilkanFormTambah() {
        return "tambah";
    }

    // ==========================================
    // SIMPAN DATA BARU (CREATE) - DENGAN VALIDASI MINUS
    // ==========================================
    @PostMapping("/simpan")
    public String simpanData(
            @RequestParam String merk,
            @RequestParam String nama,
            @RequestParam int harga,
            @RequestParam String jenis,
            @RequestParam(defaultValue = "") String tipeJaringan,
            @RequestParam(defaultValue = "") String sistemOperasi,
            @RequestParam(defaultValue = "0") int kapasitasRAM) {

        // Validasi Backend: Mencegah input minus
        if (harga < 0) harga = 0;
        if (kapasitasRAM < 0) kapasitasRAM = 0;

        if (jenis.equals("FeaturePhone")) {
            daftarHandphone.add(new FeaturePhone(merk, nama, harga, tipeJaringan));
        } else if (jenis.equals("Smartphone")) {
            daftarHandphone.add(new Smartphone(merk, nama, harga, sistemOperasi));
        } else if (jenis.equals("SmartphoneGaming")) {
            daftarHandphone.add(new SmartphoneGaming(merk, nama, harga, sistemOperasi, kapasitasRAM));
        }

        return "redirect:/";
    }

    @GetMapping("/hapus/{id}")
    public String hapusData(@PathVariable int id) {
        if (id >= 0 && id < daftarHandphone.size()) {
            daftarHandphone.remove(id);
        }
        return "redirect:/";
    }

    // ==========================================
    // MENUJU HALAMAN MODIFIKASI DATA (EDIT)
    // ==========================================
    @GetMapping("/edit/{id}")
    public String tampilkanFormEdit(@PathVariable int id, Model model) {
        if (id < 0 || id >= daftarHandphone.size()) {
            return "redirect:/";
        }

        Handphone hpSelected = daftarHandphone.get(id);
        String jenisObjek = "";

        // Identifikasi jenis subclass menggunakan instanceof
        if (hpSelected instanceof SmartphoneGaming) {
            jenisObjek = "SmartphoneGaming";
        } else if (hpSelected instanceof Smartphone) {
            jenisObjek = "Smartphone";
        } else if (hpSelected instanceof FeaturePhone) {
            jenisObjek = "FeaturePhone";
        }

        model.addAttribute("hp", hpSelected);
        model.addAttribute("id", id);
        model.addAttribute("jenisObek", jenisObjek);

        return "edit";
    }

    // ==========================================
    // PROSES EKSEKUSI PEMBARUAN DATA (UPDATE)
    // ==========================================
    @PostMapping("/update/{id}")
    public String perbaruiData(
            @PathVariable int id,
            @RequestParam String merk,
            @RequestParam String nama,
            @RequestParam int harga,
            @RequestParam(defaultValue = "") String tipeJaringan,
            @RequestParam(defaultValue = "") String sistemOperasi,
            @RequestParam(defaultValue = "0") int kapasitasRAM) {

        if (id >= 0 && id < daftarHandphone.size()) {
            Handphone hpTarget = daftarHandphone.get(id);

            // Validasi proteksi nilai di bawah 0
            if (harga < 0) harga = 0;
            if (kapasitasRAM < 0) kapasitasRAM = 0;

            // Update data dasar superclass melalui setter encapsulation
            hpTarget.setMerk(merk);
            hpTarget.setNama(nama);
            hpTarget.setHarga(harga);

            // Update data spesifik menggunakan konsep Downcasting Polimorfisme
            if (hpTarget instanceof SmartphoneGaming) {
                SmartphoneGaming sg = (SmartphoneGaming) hpTarget;
                sg.setSistemOperasi(sistemOperasi);
                sg.setKapasitasRAM(kapasitasRAM);
            } else if (hpTarget instanceof Smartphone) {
                Smartphone sp = (Smartphone) hpTarget;
                sp.setSistemOperasi(sistemOperasi);
            } else if (hpTarget instanceof FeaturePhone) {
                FeaturePhone fp = (FeaturePhone) hpTarget;
                fp.setTipeJaringan(tipeJaringan);
            }
        }
        return "redirect:/";
    }
}