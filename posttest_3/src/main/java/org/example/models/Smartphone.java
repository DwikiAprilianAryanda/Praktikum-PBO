package org.example.models;

public class Smartphone extends Handphone {
    private String sistemOperasi;

    public Smartphone(String merk, String nama, int harga, String sistemOperasi) {
        super(merk, nama, harga);
        this.sistemOperasi = sistemOperasi;
    }

    public String getSistemOperasi() {
        return sistemOperasi;
    }

    public void setSistemOperasi(String sistemOperasi) {
        this.sistemOperasi = sistemOperasi;
    }

    public void tampilkanData() {
        super.tampilkanData();
        System.out.println("  -> Sistem Operasi: " + this.sistemOperasi);
    }
}