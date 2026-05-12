package org.example.models;

public class SmartphoneGaming extends Smartphone {
    private int kapasitasRAM;

    public SmartphoneGaming(String merk, String nama, int harga, String sistemOperasi, int kapasitasRAM) {
        super(merk, nama, harga, sistemOperasi);
        this.kapasitasRAM = kapasitasRAM;
    }

    public int getKapasitasRAM() { return kapasitasRAM; }
    public void setKapasitasRAM(int kapasitasRAM) { this.kapasitasRAM = kapasitasRAM; }

    @Override
    public void tampilkanData() {
        super.tampilkanData();
        System.out.println("  -> Kapasitas RAM: " + this.kapasitasRAM + " GB");
    }

    @Override
    public void booting() {
        super.booting();
        System.out.println("[SISTEM] Mengaktifkan mode performa tinggi dan RGB lighting...");
    }
}